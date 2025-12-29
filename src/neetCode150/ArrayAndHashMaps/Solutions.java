package neetCode150.ArrayAndHashMaps;

import java.util.HashSet;
import java.util.Set;

public class Solutions {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 4, 5};
        System.out.println(containsDuplicate(array));
    }

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            else set.add(nums[i]);
        }
        return false;
    }
}
