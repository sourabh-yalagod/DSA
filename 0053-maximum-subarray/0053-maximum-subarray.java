class Solution {
    public int maxSubArray(int[] nums) {
        long sum = Integer.MIN_VALUE;
        int innerSum = 0;
        for(int num:nums){
            innerSum+=num;
            sum = Math.max(sum,innerSum);
            if(innerSum < 0) innerSum = 0;
        }       
        return (int)sum;
    }
}