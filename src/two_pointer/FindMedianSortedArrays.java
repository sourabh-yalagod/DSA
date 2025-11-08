package two_pointer;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] array1 = {1, 2};
        int[] array2 = {3, 4};
        double median = findMedianSortedArrays(array1, array2);
        System.out.println(median);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        int[] mergedArray = new int[size];
        int firstArrayIndex = 0, secondArrayIndex = 0;
        double median = 0.0;
        int i = 0;
        while (firstArrayIndex < nums1.length && secondArrayIndex < nums2.length) {
            if (nums1[firstArrayIndex] < nums2[secondArrayIndex]) {
                mergedArray[i] = nums1[firstArrayIndex++];
            } else {
                mergedArray[i] = nums2[secondArrayIndex++];
            }
            i++;
        }
        while (firstArrayIndex < nums1.length) {
            mergedArray[i] = nums1[firstArrayIndex++];
            i++;
        }
        while (secondArrayIndex < nums2.length) {
            mergedArray[i] = nums2[secondArrayIndex++];
            i++;
        }
        System.out.println(mergedArray[(size / 2)-1] + " | " + mergedArray[size / 2]);
        if (size % 2 == 1) {
            median = mergedArray[size / 2];
        } else {
            median = (mergedArray[size / 2] + mergedArray[(size / 2) + 1]) / 2.0;
        }
        return median;
    }
}

//[1,2,3,4]
//[5,6,7,8]
