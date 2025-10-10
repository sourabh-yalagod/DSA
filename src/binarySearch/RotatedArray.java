package binarySearch;

public class RotatedArray {
    public static void main(String[] args) {
        int[] array = {14, 15, 16, 17, 21, 2, 8, 9, 10, 11, 12};
        int target = 14;
        int element = rotatedBinarySearch(array, 0, array.length - 1);
        int result;
        if (element == -1) {
            result = binarySearch(array, target, 0, array.length - 1);
        } else {
            result = binarySearch(array, target, 0, element);
            if (result == -1) {
                result = binarySearch(array, target, element, array.length - 1);
            }
        }
        System.out.println(result);
    }

    private static int rotatedBinarySearch(int[] array, int low, int high) {
        if (low == high) return low;
        int mid = (low + high) / 2;
        if (array[low] < array[mid]) return rotatedBinarySearch(array, mid, high);
        return rotatedBinarySearch(array, low, mid);
    }

    public static int binarySearch(int[] array, int target, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (array[mid] == target) return mid;
        if (array[mid] > target)
            return binarySearch(array, target, low, mid - 1);
        return binarySearch(array, target, mid + 1, high);
    }


}

//[14,15,16,17,2,8,9,10]