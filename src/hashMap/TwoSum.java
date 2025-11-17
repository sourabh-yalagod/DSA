package hashMap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] array = {12, 2, 3, 4, 99};
        int target = 16;
        int[] indexs = twoSum(array, target);
        for (int i = 0; i < indexs.length; i++) {
            System.out.println(indexs[i]);
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                break;
            }
            map.put(difference, i);
        }
        return result;
    }
}
