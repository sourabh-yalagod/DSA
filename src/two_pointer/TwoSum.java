package two_pointer;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 7, 8, 9, 12, 34, 456, 890};
        int target = 3;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = {-1, -1};
        for (int i = 0; i < array.length; i++) {
            int difference = target - array[i];
            if (map.containsKey(difference)) {
                result[0] = map.get(difference);
                result[1] = i;
                break;
            }
            map.put(array[i], i);
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(" " + result[i]);
        }
    }
}
