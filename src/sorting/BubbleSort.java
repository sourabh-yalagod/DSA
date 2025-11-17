package sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {12, 343, 45, 23, 0, 9, 34, 6, 5, 7, 8};
        int[] sortedArray = bubbleSort(array);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(" " + sortedArray[i]);
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
}
