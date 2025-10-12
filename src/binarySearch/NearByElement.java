package binarySearch;

import java.util.Arrays;

public class NearByElement {
    public static void main(String[] args) {
        int[] array = {12, 23, 34, 45, 56, 67, 78, 88, 99};
        int[] nums2 = {12, 34, 56, 67};
        String string = "box";
        char ch = findSmallestCharacterLargerThenTarget(string, 'a', 0, string.length() - 1);
        int target = 33;
        int smallestGreaterElement = findSmallestGreaterElement(array, target, 0, array.length - 1);
        int greatestSmallerElement = findGreatestSmallerElement(array, target, 0, array.length - 1);
//        System.out.println(smallestGreaterElement + " " + greatestSmallerElement);
        int[] arr = nextGreaterElement(nums2, array);
        System.out.println(arr);
    }

    private static int findGreatestSmallerElement(int[] array, int target, int low, int high) {
        if (low > high) return array[high % array.length];
        int mid = (low + high) / 2;
        if (array[mid] < target) return findGreatestSmallerElement(array, target, mid + 1, high);
        return findGreatestSmallerElement(array, target, low, mid - 1);
    }

    private static int findSmallestGreaterElement(int[] array, int target, int low, int high) {
        if (low > high) return array[low % array.length];
        int mid = (low + high) / 2;
        if (array[mid] < target) return findSmallestGreaterElement(array, target, mid + 1, high);
        return findSmallestGreaterElement(array, target, low, mid - 1);
    }

    private static char findSmallestCharacterLargerThenTarget(String letters, char target, int low, int high) {
        if (low > high) return letters.charAt(low % letters.length());
        int mid = (low + high) / 2;
        if ((int) letters.charAt(mid) < (int) target) {
            return findSmallestCharacterLargerThenTarget(letters, target, mid + 1, high);
        }
        return findSmallestCharacterLargerThenTarget(letters, target, low, mid - 1);
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    if (j == nums2.length - 1) {
                        ans[index] = -1;
                        index++;
                        continue;
                    }
                    ans[index] = nums2[j + 1];
                    index++;
                }
            }
        }
        return ans;
    }
}
// [ 'c','r','t','w' ]
