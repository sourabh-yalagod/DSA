package binarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {99, 10, 12};
        int target = 10;
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

    public static int binarySearch(int[] array, int target, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (array[mid] == target) return mid;
        if (array[mid] > target)
            return binarySearch(array, target, low, mid - 1);
        return binarySearch(array, target, mid + 1, high);
    }

    public static int rotatedBinarySearch(int[] array, int low, int high) {
        if (low > high) return -1;
        if (array[0] < array[array.length - 1]) return -1;
        int mid = (low + high) / 2;
        if (array[mid - 1] > array[mid]) return mid;
        if (array[mid + 1] < array[mid]) return mid + 1;
        if (array[high] > array[mid]) {
            return rotatedBinarySearch(array, low, mid);
        }
        return rotatedBinarySearch(array, mid, high);
    }
}

//[14,15,16,17,2,8,9,10]