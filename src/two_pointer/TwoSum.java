package two_pointer;

public class TwoSum {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 7, 8, 9, 12, 34, 456, 890};
        int sum = 17;
        int low = 0, high = array.length - 1;
        while (low <= high) {
            if ((array[low] + array[high]) == sum) {
                System.out.println(low + " " + high);
                return;
            }
            if ((array[low] + array[high]) > sum) {
                high--;
            } else {
                low++;
            }
        }
        System.out.println(-1);
    }
}
