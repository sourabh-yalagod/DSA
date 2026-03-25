class RecentCounter {
    PriorityQueue<Integer> pq;
    public RecentCounter() {
        this.pq = new PriorityQueue<>();
    }
    
    public int ping(int t) {
        pq.offer(t);
        int count = 0;
        while(!pq.isEmpty() && pq.peek() < t - 3000){
            pq.poll();
        }
        return pq.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */