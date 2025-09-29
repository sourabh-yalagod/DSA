package arrays;

public class SortAnArrayof012 {
    public static int[] sortArray(int[] array) {
        int zeros = 0, ones = 0, twos = array.length - 1, temp;
        while (ones < twos) {
            if (array[ones] == 0) {
                temp = array[ones];
                array[ones] = array[zeros];
                array[zeros] = temp;
                ones++;
                zeros++;
            } else if (array[ones] == 1) ones++;
            else{
                temp = array[ones];
                array[ones] = array[twos];
                array[twos] = temp;
                twos--;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 1, 0, 0, 1, 2, 0};
        sortArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
