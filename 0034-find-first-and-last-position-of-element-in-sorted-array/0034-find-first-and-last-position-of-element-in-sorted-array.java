class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        int length = nums.length;
        int firstIndex = binarySearch(nums,0,length-1,target,true);
        if(firstIndex==-1) return result;
        int secondIndex = binarySearch(nums,0,length-1,target,false);
        result[0] = firstIndex;
        result[1] = secondIndex;
        return result;
    }
    private int binarySearch(int[] array,int low,int high,int target,boolean isFirst){
        int index = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(array[mid]==target){
                index = mid;
                if(isFirst) high = mid-1;
                else low = mid+1;
            }else if(array[mid]<target) low = mid+1;
            else high = mid-1;
        }
        return index;
    }
}
// 1,2,3,3,3,3,4,5
//target 3;