package Neetcode_150;

import java.util.*;

public class TopKElements {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2,2, 2, 5, 6};
        int k = 2;
        List<Integer> result = topKElements(arr, k);
        System.out.println(result);
    }

    private static List<Integer> topKElements(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], (ele) -> 0);
            map.put(arr[i], map.get(arr[i]) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        System.out.println(map);
        map.keySet().forEach(ele -> {
            queue.add(map.get(ele));
        });
        System.out.println(queue);
        for (int i = 0; i < k; i++) {
            result.add(queue.poll());
        }
        return result;
    }
}
