class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[index]!=nums[i]){
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }
}
// 1,2,3,4,5