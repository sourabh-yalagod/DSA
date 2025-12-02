package Neetcode_150;

import java.util.HashMap;
import java.util.Map;

public class ContainDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(isContain(arr));
    }

    public static boolean isContain(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                return true;
            }
            map.put(array[i], array[i]);
        }
        return false;
    }
}
