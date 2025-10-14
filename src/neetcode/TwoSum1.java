package neetcode;

import jdk.jshell.EvalException;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarOutputStream;

public class TwoSum1 {
    public static void main(String[] args) {
        int[] array = {0, 2, 4, 12, 7};
        int sum = 14;
        int[] indices = new int[2];
        indices = findSumOfTwoNumber(array, sum);
        for (int i = 0; i < indices.length; i++) {
            System.out.println(indices[i]);
        }
    }

    private static int[] findSumOfTwoNumber(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = {-1, -1};
        for (int i = 0; i < array.length; i++) {
            int value = target - array[i];
            if (value <= 0) continue;
            if (map.containsKey(array[i])) {
                result[0] = map.get(array[i]);
                result[1] = i;
                break;
            }
            map.put(value, i);
            System.out.println(map + " " + i);
        }
        return result;
    }
}