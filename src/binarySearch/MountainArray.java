package binarySearch;

public class MountainArray {
    public static void main(String[] args) {
        int[] array = {9, 6, 3};
        int peak = findPeakInMountainArray(array, 0, array.length - 1);
        System.out.println(peak);
    }

    public static int findPeakInMountainArray(int[] array, int low, int high) {
        if (low == high) return low;
        int mid = (low + high) / 2;
        if (array[mid] < array[mid + 1])
            return findPeakInMountainArray(array, mid + 1, high);
        return findPeakInMountainArray(array, low, mid);
    }
}
// [1,2,3,6,45,34,23,12]
