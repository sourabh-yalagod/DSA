package neetCode150.heap;

import java.util.PriorityQueue;

public class Solutions {
    PriorityQueue<Integer> pq;
    PriorityQueue<Integer> pqMax;
    int k;

    Solutions() {
        this.pq = new PriorityQueue<>();
        this.pqMax = new PriorityQueue<>((a, b) -> b - a);
    }

    public void KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) pq.poll();
        return pq.isEmpty() ? 0 : pq.peek();
    }

    public int lastStoneWeight(int[] stones) {
        for (int stone : stones) pqMax.offer(stone);
        while (!pqMax.isEmpty()) {
            if (pqMax.size() == 1) return pqMax.peek();
            int first = pqMax.poll();
            int second = pqMax.poll();
            int remaining = first - second;
            if (remaining == 0) continue;
            pqMax.offer(remaining);
        }
        return -1;
    }
}
