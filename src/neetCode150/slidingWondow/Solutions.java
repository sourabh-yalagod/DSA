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
}
