package Neetcode_150;

import java.util.*;

public class Anagrams {
    public static void main(String[] args) {
        String str1 = "abcc11";
        String str2 = "cbac11";
//        System.out.println(isValid(str1, str2));

        String[] strings = {"abc", "bca", "cba", "bc", "cb", "a"};
        List<String> result = groupAnagrams(strings);
        result.forEach(ele -> {
            System.out.println(ele.toString());
        });
    }

    private static boolean isValid(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            int count = 1;
            if (map.containsKey(str1.charAt(i))) {
                count += map.get(str1.charAt(i));
            }
            map.put(str1.charAt(i), count);
        }
        for (int i = 0; i < str2.length(); i++) {
            if (!map.containsKey(str2.charAt(i))) {
                return false;
            }
            int count = map.get(str2.charAt(i));
            if (count == 1) {
                map.remove(str2.charAt(i));
            } else {
                map.put(str2.charAt(i), count - 1);
            }
        }
        return map.isEmpty();
    }

    private static List<String> groupAnagrams(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            char[] chars = strings[i].toCharArray();
            Arrays.sort(chars);
            String str = Arrays.toString(chars);
            if (map.containsKey(str)) {
                List<String> innerList = map.get(str);
                innerList.add(strings[i]);
                map.put(str, innerList);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(strings[i]);
                map.put(str, newList);
            }
        }
        return Arrays.asList(map.values().toString());
    }

}
