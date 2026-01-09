package heap;

import java.time.LocalDateTime;
import java.util.*;

class Twitter {
    Map<Integer, Set<Integer>> users;
    Map<Integer, List<Tweet>> tweets;

    class Tweet {
        public int userId;
        public int tweetId;
        public LocalDateTime createdAt;

        public Tweet(int userId, int id) {
            this.userId = userId;
            this.tweetId = id;
            this.createdAt = LocalDateTime.now();
        }
    }

    public Twitter() {
        this.tweets = new HashMap<>();
        this.users = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(userId, tweetId);
        List<Tweet> userTweets = tweets.getOrDefault(userId, new ArrayList<>());
        userTweets.add(tweet);
        tweets.put(userId, userTweets);
    }


    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.createdAt.compareTo(a.createdAt));
        for (List<Tweet> tweet : tweets.values()) {
            if (!pq.isEmpty() && pq.size() > 10) pq.poll();
        }
        List<Integer> feed = new ArrayList<>();
        while (!pq.isEmpty()) feed.add(pq.poll().tweetId);
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> user = users.getOrDefault(followerId, new HashSet<>());
        user.add(followeeId);
        users.put(followerId, user);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> user = users.getOrDefault(followerId, new HashSet<>());
        user.remove((Integer) followeeId);
        users.put(followerId, user);
    }
}
