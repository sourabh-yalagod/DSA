class Solution {
    public void rotate(int[] array, int k) {
        int low = 0;
        int high = array.length-1;
        k = k%(high+1);
        reverse(array,low,high);
        reverse(array,0,k-1);
        reverse(array,k,high);
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
//1,2,3,4,5,6,7

//7,6,5,4,3,2,1
//5,6,7,4,3,2,1

//5,6,7,1,2,3,4 