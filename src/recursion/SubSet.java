package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        System.out.println(allPossibleSubset("", "abc"));
    }

    public static List<String> allPossibleSubset(String processed, String unProcessed) {
        List<String> list = new ArrayList<>();
        if (unProcessed.isEmpty()) {
            list.add(processed);
            return list;
        }
        char ch = unProcessed.charAt(0);
        List<String> list1 = allPossibleSubset(processed, unProcessed.substring(1));
        List<String> list2 = allPossibleSubset(processed + ch, unProcessed.substring(1));
        list.addAll(list1);
        list.addAll(list2);
        return list;
    }
}
