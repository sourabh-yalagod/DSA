package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BalancedStringSplit {
    public static void main(String[] args) {
        System.out.println(balancedStringSplit("LLRRLR"));
    }

    public static int balancedStringSplit(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                map.put(s.charAt(i), map.getOrDefault('L', 0) + 1);
                if (Objects.equals(map.get('L'), map.get('R'))) {
                    count++;
                    map.clear();
                }
            } else {
                map.put(s.charAt(i), map.getOrDefault('R', 0) + 1);
                if (Objects.equals(map.get('L'), map.get('R'))) {
                    count++;
                    map.clear();
                }
            }
        }
        return count;
    }
}