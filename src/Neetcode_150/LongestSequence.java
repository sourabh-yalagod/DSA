package Neetcode_150;

import java.util.HashSet;
import java.util.Set;

public class LongestSequence {
    public static void main(String[] args) {
        int[] arr = {0, 0, -1};
        int count = countSequence(arr);
        System.out.println(count);
    }

    private static int countSequence(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int ele : nums) {
            set.add(ele);
        }
        int maxCount = 0;
        for (int ele : nums) {
            if (!set.contains(ele - 1)) {
                int currentNumber = ele;
                int count = 0;
                while (set.contains(currentNumber)) {
                    currentNumber++;
                    count++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
