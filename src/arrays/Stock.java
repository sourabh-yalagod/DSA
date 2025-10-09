package arrays;

public class Stock {
    public static void main(String[] args) {
        int[] prices = {1, 3, 5, 6, 9, 7};
        int profit = calculateMaxProfit(prices);
        System.out.println(profit);
    }

    public static int calculateMaxProfit(int[] prices) {
        int low = 0, high = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[low]) {
                high = i;
                low = i;
            }
            if (prices[i] > prices[high]) {
                high = i;
            }
        }
        return prices[high] - prices[low];
    }
}
