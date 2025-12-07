package Neetcode_150;

public class BestTimeToBuyStock {
    public static void main(String[] args) {
        int[] prices = {8, 9, 10, 1, 2, 3, 4, 23, 5, 34, 7, 9};
        int profit = maxProfit2(prices);
        System.out.println(profit);
    }

    private static int maxProfit1(int[] prices) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[low] > prices[i]) {
                low = i;
                high = i;
            }
            if (prices[high] < prices[i]) {
                high = i;
            }
        }
        return prices[high] - prices[low];
    }

    private static int maxProfit2(int[] prices) {
        int profit = 0;
        int low = 0;
        int high = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[high]) {
                System.out.println(low + " " + high);
                low = i;
            }
            if (prices[i] < prices[low]) {
                low = i;
                high = i;
            }
            if (prices[i] > prices[high]) {
                high = i;
            }
        }
        System.out.println(prices[low] + " " + prices[high]);
        return profit;
    }
}