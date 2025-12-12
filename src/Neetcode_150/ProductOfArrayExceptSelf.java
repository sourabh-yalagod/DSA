package Neetcode_150;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] array = {1, 2, 0, 9};
        int[] products = productOfArrayExceptSelf(array);

    }

    private static int[] productOfArrayExceptSelf(int[] array) {
        int[] products = new int[array.length];
        int[] leftToRight = new int[array.length];
        int[] rightToLeft = new int[array.length];
        for (int i = 1; i < array.length; i++) {
            leftToRight[i] = leftToRight[i - 1] * array[i - 1];
        }
        for (int i = array.length - 1; i >= 1; i--) {
            rightToLeft[i] = rightToLeft[i - 1] * array[i - 1];
        }
        for (int i = 0; i < array.length; i++) {
            products[i] = leftToRight[i] * rightToLeft[i];
            System.out.println(products[i]);
        }
        return products;
    }
}
