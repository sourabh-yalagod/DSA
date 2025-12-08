package Neetcode_150;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        String str = "abcde";
        List<String> list = new ArrayList<>();
        subStrings("", str, list);
        list.forEach(ele -> {
            System.out.print(ele + " ");
        });
    }

    private static void permutations(String processed, String unProcessed, List<String> list) {
        if (unProcessed.isEmpty()) {
            list.add(processed);
            return;
        }
        for (int i = 0; i < unProcessed.length(); i++) {
            char ch = unProcessed.charAt(i);
            String remaining = unProcessed.substring(0, i) + unProcessed.substring(i + 1);
            permutations(ch + processed, remaining, list);
        }
    }

    private static void generateParenthesis(String processed, int open, int close, List<String> list) {
        if (open == 0 && close == 0) {
            list.add(processed);
            return;
        }
        if (open > 0)
            generateParenthesis(processed + "(", open - 1, close, list);
        if (open < close)
            generateParenthesis(processed + ")", open, close - 1, list);
    }

    private static void subStrings(String processed, String unProcessed, List<String> list) {
        if (unProcessed.isEmpty()) {
            list.add(processed);
            return;
        }
        char ch = unProcessed.charAt(0);
        subStrings(processed, unProcessed.substring(1), list);
        subStrings(ch + processed, unProcessed.substring(1), list);
    }
}
