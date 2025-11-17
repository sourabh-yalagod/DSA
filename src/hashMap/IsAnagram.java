package hashMap;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public static void main(String[] args) {
        String s = "cabc";
        String t = "abcc";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                Integer value = map.get(t.charAt(i));
                if (value == 1) {
                    map.remove(t.charAt(i));
                    continue;
                }
                map.put(t.charAt(i), value - 1);
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
}