class Solution {
    public int maxProduct(int[] nums) {
        int prod = Integer.MIN_VALUE;
        int left = 1;
        int right = 1;
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(left==0) left=1;
            if(right==0) right=1;
            left = nums[i]*left;
            right = nums[len-i-1]*right;
            prod = Math.max(prod,Math.max(left,right));
        }
        return prod;
    }
}