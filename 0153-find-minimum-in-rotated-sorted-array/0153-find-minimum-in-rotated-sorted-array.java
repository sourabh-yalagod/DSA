class Solution {
    public int findMin(int[] array) {
        if (array.length == 0) return -1;
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if(array[high] > array[mid]) high = mid; 
            else low = mid+1;
        }
        return array[low];
    }
}