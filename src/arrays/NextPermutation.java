package arrays;

import java.util.ArrayList;
import java.util.List;

public class NextPermutation {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(0);
        array.add(2);
        List<List<Integer>> list = new ArrayList<>();
        findAllPossiblePermutations(array, new ArrayList<>(), list);
        list.forEach(System.out::println);
    }

    private static void findAllPossiblePermutations(List<Integer> unProcessed, List<Integer> processed, List<List<Integer>> list) {
        if (unProcessed.size() == 0) {
            list.add(processed);
            return;
        }
        for (int i = 0; i < unProcessed.size(); i++) {
            Integer digit = unProcessed.get(i);
            List<Integer> newUnProcessed = new ArrayList<>();

        }
    }
}
