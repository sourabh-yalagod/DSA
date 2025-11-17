package two_pointer;

public class MaximumSubarray_53 {
    public static void main(String[] args) {
        int[] array = {5, 4, -100, 7, 8};
        int sum = maxSubArray(array);
        System.out.println(sum);
    }

    private static int maxSubArray(int[] array) {
        int sum = array[0];
        int currentSum = array[0];
        for (int i = 1; i < array.length; i++) {
            currentSum = Math.max(array[i], currentSum + array[i]);
            sum = Math.max(sum, currentSum);
        }
        return sum;
    }

}
