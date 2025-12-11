package DSA_250;

import java.util.HashMap;
import java.util.Map;

public class ArrayEasy {
    public static void main(String[] args) {
        int[] array = {12, 32, 42, 53, 6, 75, 1};
        int[] result = twoSum(array, 81);
    }

    private static int[] twoSum(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = {-1, -1};
        for (int i = 0; i < array.length; i++) {
            int remaining = target - array[i];
            if (map.containsKey(remaining)) {
                result[0] = map.get(remaining);
                result[1] = i;
                System.out.println(result[0]);
                System.out.println(result[1]);
                return result;
            }
            map.put(array[i], i);
        }
        return result;
    }
}
