package string;

import java.util.ArrayList;
import java.util.List;

public class SubString {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String str = "12";
//        usingRecursion("", str, list);
        permutations(str.toCharArray(), 0, list);
        list.forEach(ele -> {
            System.out.print(ele + " ");
        });
    }

    public static void usingRecursion(String processed, String unProcessed, List<String> list) {
        if (unProcessed.isEmpty()) {
            list.add(processed);
            return;
        }
        char ch = unProcessed.charAt(0);
        usingRecursion(ch + processed, unProcessed.substring(1), list);
        usingRecursion(processed, unProcessed.substring(1), list);
    }

    public static void usingLoop(String string, List<String> list) {
        int length = string.length();
        for (int i = 0; i < length; i++) {
            for (int j = i; j <= length; j++) {
                list.add(string.substring(i, j));
            }
        }
    }

    public static void permutations(char[] processed, int index, List<String> list) {
        if (processed.length == index) {
            list.add(new String(processed));
            return;
        }
        for (int i = index; i < processed.length; i++) {
            swap(processed, i, index);
            permutations(processed, index + 1, list);
            swap(processed, i, index);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
