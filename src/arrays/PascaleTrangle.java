package arrays;

import java.util.ArrayList;
import java.util.List;

public class PascaleTrangle {
    public static void main(String[] args) {
        int n = 100;
        List<List<Integer>> tringle = constructPascalTrangle(n);
        tringle.forEach(System.out::println);
    }

    private static List<List<Integer>> constructPascalTrangle(int n) {
        List<List<Integer>> tringle = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        tringle.add(firstRow);
        for (int i = 1; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> previousRow = tringle.get(i - 1);
            for (int j = 1; j < previousRow.size(); j++) {
                row.add(previousRow.get(j) + previousRow.get(j - 1));
            }
            row.add(1);
            tringle.add(row);
        }
        return tringle;
    }
}
