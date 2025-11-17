package two_pointer;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {12, 3, 4, 23, 45, 36, 867, 23, 8, 96, 5, 65};
        reverseArray(array, 0, array.length - 1);
        reverseArray(array, 0, 2 - 1);
        reverseArray(array, 2, array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]+" ");
        }
    }

    private static int[] reverseArray(int[] array, int low, int high) {
        while (low < high) {
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            low++;
            high--;
        }
        return array;
    }

    private static int[] rotate(int[] array, int key) {

        return array;
    }
}
