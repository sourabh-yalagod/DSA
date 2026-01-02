package binarySearch;

public class Solutions {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 6, 10, 11};
        System.out.println(binarySearch(array,11));
    }

    private static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) return mid;
            else if (array[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
