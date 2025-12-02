package Neetcode_150;

import java.util.ArrayList;
import java.util.List;

public class Palandrom {
    public static void main(String[] args) {
        String str = "0hey this;;;  si ht yeh0";
        boolean result = isValid(str);
        System.out.println(result);
    }

    private static boolean isValid(String str) {
        str = str.toLowerCase().trim();
        List<Character> chars = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isAlphabet(str.charAt(i))) {
                chars.add(str.charAt(i));
            }
        }
        int left = 0;
        int right = chars.size() - 1;
        while (left < right) {
            if (!chars.get(left).equals(chars.get(right))) return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean isAlphabet(char character) {
        if (((int) character >= 97 && (int) character <= 122) || character >= '0' && character <= '9') {
            return true;
        }
        return false;
    }
}
