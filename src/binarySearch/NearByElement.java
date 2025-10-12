package binarySearch;

import java.util.Arrays;

public class NearByElement {
    public static void main(String[] args) {
        int[] array = {12, 23, 34, 45, 56, 67, 78, 88, 99};
        String string = "box";
        char ch = findSmallestCharacterLargerThenTarget(string, 'a', 0, string.length() - 1);
        int target = 33;
        int smallestGreaterElement = findSmallestGreaterElement(array, target, 0, array.length - 1);
        int greatestSmallerElement = findGreatestSmallerElement(array, target, 0, array.length - 1);
//        System.out.println(smallestGreaterElement + " " + greatestSmallerElement);
        System.out.println(ch);
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

}
// [ 'c','r','t','w' ]
