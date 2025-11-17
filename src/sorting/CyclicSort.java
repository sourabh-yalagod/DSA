package sorting;

public class CyclicSort {
    public static void main(String[] args) {
        int[] array = {0, 9, 6, 7, 8, 1, 2, 3, 4, 5};
        int[] sortedArray = cyclicSort(array);
//        factors(10);
        System.out.println(fibonacci(4));
    }

    private static int[] cyclicSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (value != i) {
                int temp = array[value];
                array[value] = value;
                array[i] = temp;
            }
        }
        return array;
    }


    //  factors of numbers
    public static void factors(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        }
        return factorial(num - 1) * num;
    }

    public static int fibonacci(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        int value = fibonacci(num - 1) + fibonacci(num - 2);
        return value;
    }
}
