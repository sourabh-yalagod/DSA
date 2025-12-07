package Neetcode_150;

import java.util.Stack;

public class EncodeDecode {
    public static void main(String[] args) {
        String[] str = {"hey#2", "this", "is", "Sourabh"};
//        System.out.println(decode(encode(str)));
        String str2 = "3[c2[a]]]";
        System.out.println(decode2(str2));
    }

    public static String decode(String str) {
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((i + 1) < str.length() && str.charAt(i) == '#' && Character.isDigit(str.charAt(i + 1))) {
                flag = true;
                count = Integer.parseInt(String.valueOf(str.charAt(i + 1)));
                i += 1;
                result.append(" ");
                continue;
            }
            result.append(str.charAt(i));
        }
        return result.toString().trim();
    }

    public static String encode(String[] str) {
        StringBuilder result = new StringBuilder();
        for (String st : str) {
            String word = "#".concat(Integer.toString(st.length()).concat(st));
            result.append(word);
        }
        return result.toString();
    }

    public static String decode2(String string) {
        Stack<Character> stack = new Stack<>();
        String result = new String("");
        StringBuilder subString = new StringBuilder();
        String temp = "";
        int count = 0;
        for (int i = string.length() - 1; i >= 0; i--) {
            if (Character.isDigit(string.charAt(i))) {
                count = string.charAt(i) - '0';
                while (!stack.isEmpty()) {
                    char value = stack.pop();
                    if (value == '[') continue;
                    if (value == ']') break;
                    temp += String.valueOf(value);
                }
                while (count != 0) {
                    subString.append(temp);
                    temp="";
                    count--;
                }
                result = subString.toString().concat(result);
                subString.delete(0, subString.length());
            } else stack.push(string.charAt(i));
        }
        while (!stack.isEmpty()) {
            char value = stack.pop();
            if (!Character.isAlphabetic(value)) continue;
            result = String.valueOf(value).concat(result);
        }
        return result;
    }
}
