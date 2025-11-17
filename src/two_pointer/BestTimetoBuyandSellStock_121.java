package two_pointer;

public class BestTimetoBuyandSellStock_121 {
    public static void main(String[] args) {
        int[] prices = {1, 6, 0, 1, 2, 3, 8, 1};
        System.out.println(maxProfit2(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int low = 0, high = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[low] > prices[i]) {
                low = i;
                high = i;
            }
            if (prices[high] < prices[i]) {
                high = i;
                profit = Math.max(profit, prices[high] - prices[low]);
            }
        }
        return profit;
    }

    public static int maxProfit2(int[] prices) {
        int profit = 0;
        int low = 0, high = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[high] > prices[i]) {
                System.out.println(low + " " + high);
                profit += prices[high] - prices[low];
                high = i;
                low = i;
            }
            if (prices[low] >= prices[i]) {
                low = i;
            }
            if (prices[high] <= prices[i]) {
                high = i;
            }
        }
        return profit;
    }
}
