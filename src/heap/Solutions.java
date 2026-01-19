package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solutions {
    public static void main(String[] args) {
        int[] array = {3, 2, 1, 5, 4, 6};
        balanceQueue(array);
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

    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int ele : nums) {
            pq.add(ele);
            if (pq.size() > k) pq.poll();
        }
        return pq.poll();
    }

    private static int leastInterval(char[] tasks, int n) {
        int count = 0;
        PriorityQueue<Character> pq = new PriorityQueue<>(Character::compareTo);
        for (char ch : tasks) pq.add(ch);
        char prev = ' ';
        List<Character> list = new ArrayList<>();
        int prog = n;
        while (!pq.isEmpty()) {
            char task = pq.poll();
            if (prog == 0) {
                count++;
                prog = n;
            }
            if (prev != task) {
                prev = task;
            }
            prev = pq.poll();

        }
        return count;
    }

    private static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        for (int[] axis : points) {
            pq.add(axis);
            if (pq.size() > k) pq.poll();
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) break;
            int[] axis = pq.poll();
            result[i][0] = axis[0];
            result[i][1] = axis[1];
        }
        return result;

    }

    private static void balanceQueue(int[] array) {
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < array.length; i++) {
            left.offer(array[i]);
            if (left.size() < right.size()) {
                left.offer(array[i]);
            }
        }
        System.out.println("Left : " + left);
    }
}
