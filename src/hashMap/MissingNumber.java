package hashMap;

public class MissingNumber {
    public static void main(String[] args) {
        int[] array = {3, 0, 1};
        int digit = missingNumber(array);
        System.out.println(digit);
    }

    public static int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i <= nums.length; i++) {
            xor = xor ^ i;
        }
        for (int num : nums) {
            xor = xor ^ num;
        }
        return xor;
    }
}
