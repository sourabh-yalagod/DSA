package heap;

import java.util.PriorityQueue;

public class Solutions {
    public static void main(String[] args) {}

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
}
