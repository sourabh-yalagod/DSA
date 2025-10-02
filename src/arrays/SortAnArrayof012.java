package arrays;

public class SortAnArrayof012 {
    public static int[] sortArray(int[] array) {
        int low = 0, mid = 0, high = array.length - 1;
        int temp;
        while (mid <= high) {
            if (array[mid] == 0) {
                temp = array[low];
                array[low] = array[mid];
                array[mid] = temp;
                low++;
            } else if (array[mid] == 1) {
                mid++;
            } else {
                temp = array[high];
                array[high] = array[mid];
                array[mid] = temp;
                high--;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 1,1,0,0, 0, 0, 1, 2, 0};
        sortArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
