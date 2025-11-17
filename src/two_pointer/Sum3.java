package two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 2, -1, -4};
//        sorted -4,-1,-1,0,1,2
        List<List<Integer>> list = threeSum(array);
        for (List<Integer> arr : list) {
            System.out.println(arr);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                if (low == i || high == i) break;
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    List<Integer> innerList = new ArrayList<>();
                    innerList.addAll(List.of(nums[low], nums[i], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    list.add(innerList);
                    low++;
                    high--;
                    break;
                }
                else if (sum > 0) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return list;
    }
}
