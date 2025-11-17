package two_pointer;

public class ProductWithoutSelf {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int num = productOfArray(array, 2);
        System.out.println(num);
    }

    private static int productOfArray(int[] array, int target) {
        int[] prefix = new int[array.length];
        int[] suffix = new int[array.length];

        suffix[array.length - 1] = 1;
        for (int i = array.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * array[i + 1];
        }

        prefix[0] = 1;
        for (int i = 1; i < array.length; i++) {
            prefix[i] = prefix[i - 1] * array[i - 1];
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return prefix[i] * suffix[i];
            }
        }
        return 0;
    }
}
