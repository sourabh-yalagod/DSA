package arrays;

public class Stock {
    public static int maxProfit(int[] prices) {
        int low = 0, high = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[low]) {
                low = i;
                high = i;
            }
            if (prices[i] > prices[high]) {
                high = i;
            }
        }
        return prices[high] - prices[low];
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 8, 4};
        System.out.println(maxProfit(prices));
    }
}
