package binarySearch;

import java.util.HashMap;
import java.util.Map;

public class MountainArray {
    public static void main(String[] args) {
//        int[] array = {12, 23, 34, 67};
//        int[] array = {56, 56, 56, 56, 56, 67, 56, 56, 56, 56, 56};
        int[] array = {12, 23, 56, 56, 56, 56, 56};
        System.out.println(findRange(array, 56, 0, array.length - 1));
        Map<Character, Integer> map = new HashMap<>();
        map.getOrDefault('k',0);
    }

    public static int findPeak(int[] array, int low, int high) {
        if (low >= high) {
            return low;
        }
        int mid = (low + high) / 2;
        if (array[mid] <= array[mid + 1]) {
            return findPeak(array, mid + 1, high);
        } else {
            return findPeak(array, low, mid);
        }
    }

    public static int findRotateValue(int[] array, int low, int high) {
        if (low >= high) return -1;
        int mid = (low + high) / 2;
        if (array[low] <= array[mid]) {
            if (array[mid] <= array[mid + 1]) {
                return findRotateValue(array, mid, high);
            } else {
                return mid;
            }
        } else {
            if (array[mid] >= array[mid - 1]) {
                return findRotateValue(array, low, mid);
            } else {
                return mid - 1;
            }
        }
    }

    public static int binarySearch(int[] array, int target, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (target == array[mid]) return mid;
        if (array[mid] < target) {
            return binarySearch(array, target, mid + 1, high);
        }
        return binarySearch(array, target, low, mid - 1);
    }

    public static int findRange(int[] array, int target, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (array[mid] == target) {
            if (mid < high && array[mid] == array[mid + 1]) {
                return findRange(array, target, mid + 1, high);
            }
            return mid;
        }
        if (array[mid] > target) {
            return findRange(array, target, low, mid - 1);
        }
        return findRange(array, target, mid + 1, high);
    }
}
