package Neetcode_150;

import java.util.ArrayList;
import java.util.List;

public class MaximumSubarray {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int count = maximumSubarray(arr);
        System.out.println(count);
    }

    private static int maximumSubarray(int[] numbers) {
        long count = Integer.MIN_VALUE;
        int innerCount = 0;
        for (int number : numbers) {
            innerCount += number;
            count = Math.max(innerCount, count);
            if (innerCount < 0) innerCount = 0;
        }
        return (int) count;
    }
}
