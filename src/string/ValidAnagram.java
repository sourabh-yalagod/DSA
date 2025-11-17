package string;

import java.util.*;

public class ValidAnagram {
    public static void main(String[] args) {
        String string1 = "caaatt";
        String string2 = "acttaa";
        boolean isValidAnagram = checkValidAnagram(string1, string2);
        System.out.println(isValidAnagram);

//
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagrams(words);
        list.forEach(word -> {
            System.out.print(word + " ");
        });
    }

    private static boolean checkValidAnagram(String string1, String string2) {
        if (string1.length() != string2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        int lengthOfString = string1.length();
        for (int i = 0; i < lengthOfString; i++) {
            if (map.containsKey(string1.charAt(i))) {
                int count = map.get(string1.charAt(i));
                map.put(string1.charAt(i), count + 1);
            } else {
                map.put(string1.charAt(i), 1);
            }
        }
        for (int i = 0; i < lengthOfString; i++) {
            if (map.containsKey(string2.charAt(i))) {
                int count = map.get(string2.charAt(i));
                System.out.println(count);
                if (count == 1) {
                    map.remove(string2.charAt(i));
                } else {
                    map.put(string2.charAt(i), count - 1);
                }
            } else {
                return false;
            }
        }
        System.out.println(map);
        return map.isEmpty();
    }

    private static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String mapKey = new String(chars);
            map.computeIfAbsent(mapKey, (k) -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
