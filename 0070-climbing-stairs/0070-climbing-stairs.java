class Solution {
    public int climbStairs(int n){
        int[] dp = new int[n+1];
        return climbStairsWithDp(n,dp);
    }
    private int climbStairsWithDp(int n,int[] dp){
        if(n<=1) return 1;
        if(dp[n]>0) return dp[n];
        dp[n]= climbStairsWithDp(n-1,dp) + climbStairsWithDp(n-2,dp);        
        return dp[n];
    }
}