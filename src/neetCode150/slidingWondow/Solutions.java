package neetCode150.slidingWondow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solutions {
    public static void main(String[] args) {
        int[] array = {3, 3, 5, 0, 0, 3, 1, 4};
    }
    private static int bestTimeToBuyStock1(int[] prices) {
        int maxProfit = 0;
        int low = 0;
        int high = prices.length - 1;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[low]) {
                low = i;
                high = i;
            }
            if (prices[i] > prices[high]) {
                high = i;
            }
            maxProfit = Math.max(maxProfit, prices[high] - prices[low]);
        }
        return maxProfit;
    }
    private static int bestTimeToBuyStock2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }

    private static int bestTimeToBuyStock3(int[] prices) {
        List<List<Integer>> list = new ArrayList<>();
        int low = 0;
        int high = 0;
        int[] maxProfit = {0, 0};
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= prices[low]) {
                if (low != 0 || high != 0) {
                    list.add(List.of(low, high));
                }
                low = i;
                high = i;
            }
            if (prices[i] > prices[high]) {
                high = i;
            }
        }
        list.add(List.of(low, high));
        list.forEach(arr -> {
            int profit = prices[arr.get(1)] - prices[arr.get(0)];
            if (maxProfit[0] < profit) {
                maxProfit[1] = maxProfit[0];
                maxProfit[0] = profit;
            } else if (maxProfit[1] < profit) {
                maxProfit[1] = profit;
            }
        });
        return maxProfit[0] + maxProfit[1];
    }
}
