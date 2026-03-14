class Solution {
    public void rotate(int[] array, int k) {
        int n = array.length;
        k = k % n;  // handle cases like k > n

        reverse(array, 0, n - 1);
        reverse(array, 0, k - 1);
        reverse(array, k, n - 1);
    }

    private static void reverse(int[] array, int low, int high) {
        while (low < high) {
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            low++;
            high--;
        }
    }
}
