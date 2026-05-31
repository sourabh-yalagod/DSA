class Solution {
    public int arrangeCoins(int n) {
        int count = 0;
        int coins = 1;
        while(n>0 && n>=coins){
            count++;
            n-=coins++;
        }
        return count;
    }
}