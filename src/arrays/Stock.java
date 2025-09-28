package arrays;

public class Stock {
    public static int maxProfit(int[] prices) {
        int lowPrice = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[lowPrice]) {
                lowPrice = i;
            } else {
                profit = Math.max(profit, prices[i] - prices[lowPrice]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 0, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
