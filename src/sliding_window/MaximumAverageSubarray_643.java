package sliding_window;

public class MaximumAverageSubarray_643 {
    public static void main(String[] args) {
        int[] array = {1, 12, -5, -6, 50, 3};
        int k = 4;
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += array[i];
        }
        for (int i = k; i < array.length; i++)   {
            int innerMax = max;
            innerMax -= array[i - k];
            innerMax += array[i];
            max = Math.max(innerMax, max);
        }
        return;
    }
}
