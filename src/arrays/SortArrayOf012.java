package arrays;

public class SortArrayOf012 {
    public static void main(String[] args) {
        int[] array = {2,0, 1, 2, 0, 1, 2, 0, 2, 0, 0};
        int[] sortedArray = SortArrayOf012(array);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(" " + sortedArray[i]);
        }
    }

    public static int[] SortArrayOf012(int[] array) {
        int low = 0, mid = 0, high = array.length - 1;
        int temp;
        while (mid <= high) {
            if (array[mid] == 0) {
                temp = array[mid];
                array[mid] = array[low];
                array[low] = temp;
                low++;
                mid++;
            } else if (array[mid] == 1) mid++;
            else {
                temp = array[mid];
                array[mid] = array[high];
                array[high] = temp;
                high--;
            }
        }
        return array;
    }
}
