package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.addAll(Arrays.asList(1, 2, 3));
        List<Integer> processed = new ArrayList<>();
        getAllPossiblePermutations(array, processed);
    }

    private static void getAllPossiblePermutations(List<Integer> unProcessed, List<Integer> processed) {
        if (unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        for (int i = 0; i < unProcessed.size(); i++) {
            List<Integer> newProcessed = new ArrayList<>(processed);
            newProcessed.add(unProcessed.get(i));
            List<Integer> rest = new ArrayList<>(unProcessed);
            rest.remove(i);
            getAllPossiblePermutations(rest, newProcessed);
        }
    }
}
