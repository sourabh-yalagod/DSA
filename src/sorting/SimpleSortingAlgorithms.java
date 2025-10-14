package sorting;

public class SimpleSortingAlgorithms {
    public static void main(String[] args) {
        int[] array = {12, 23, 0, 4121, 2, 1, 0};
        int[] sortedArray = bubbleSort(array);
//        int[] sortedArray = selectionSort(array);
//        int[] sortedArray = insertionSort(array);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.println(array[i]);
        }
    }
    private static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
    private static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }
    private static int[] selectionSort(int[] array) {
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
