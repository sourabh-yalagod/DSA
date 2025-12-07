package Neetcode_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinmumWindowSubstring {
    public static void main(String[] args) {
        String str1 = "abecaerpiopd";
        String str2 = "abc";
//        List<String> result = subStrings(str1);
        String result = minWindowSubString(str1, str2);
        System.out.println(result);
    }

    private static String minWindowSubString(String str1, String str2) {
        int need = str2.length();
        int have = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            map2.put(str2.charAt(i), i);
        }
        for (int i = 0; i < str1.length(); i++) {
            if (map2.containsKey(str1.charAt(i))) {
                map1.putIfAbsent(str1.charAt(i), 0);
                map1.put(str1.charAt(i), map1.get(str1.charAt(i)) + 1);
            }
        }
        if (map1.size() < str2.length()) return "";

        int left = 0;
        int right = str1.length() - 1;

        String result = str1;
        // abecaerpiopd
        while (left < right) {
            while (!map1.containsKey(str1.charAt(left))) left++;
            while (!map1.containsKey(str1.charAt(right))) right--;
            break;
        }
        System.out.println(left + " " + right);
        return result;
    }

    public static List<String> subStrings(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                list.add(str.substring(i, j) + " ");
            }
        }
        return list;
    }
}
