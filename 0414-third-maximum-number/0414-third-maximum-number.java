class Solution {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for(int num:nums){
            if (num == first || num == second || num == third) continue;
            if(first<num){
                third = second;
                second = first;
                first = num;
            }
            if(first>num && num>second){
                third = second;
                second = num;
            }
            if(second>num && num>third){
                third = num;
            }
        }
        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }
}