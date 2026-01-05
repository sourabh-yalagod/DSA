package heap;

import java.util.PriorityQueue;

public class Solutions {
    public static void main(String[] args) {
    }

    private static int lastStone(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int ele : stones) pq.add(ele);
        while (pq.size() > 1) {
            int large = pq.poll();
            int small = pq.poll();
            if (large == small) continue;
            pq.add(large - small);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

    class KthLargest {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        private int k = 0;

        public KthLargest(int k, int[] nums) {
            for (int ele : nums) {
                pq.offer(ele);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            this.k = k;
        }

        public int add(int val) {
            pq.add(val);
            if (pq.size() > this.k) {
                pq.poll();
            }
            return pq.isEmpty() ? 0 : pq.peek();
        }
    }
}
