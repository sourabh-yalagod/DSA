package two_pointer;

public class FindGCD {
    public static void main(String[] args) {
        int[] array = {2, 5, 6, 9, 10};
        System.out.println(findGCD(array));
    }

    public static int findGCD(int[] nums) {
        int low = nums[0], high = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (low > nums[i]) {
                low = nums[i];
            }
            if (high < nums[i]) {
                high = nums[i];
            }
        }
        return computeGCD(low, high);
    }

    private static int computeGCD(int low, int high) {
        if (low == 0) return high;
        return computeGCD(high % low, low);
    }
}
