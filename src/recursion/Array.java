package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {
    public static void main(StringClass[] args) {
        List<Integer> array = new ArrayList<>();
        array.addAll(Arrays.asList(12, 0, 23, 23, 23, 34, 45, 56));
        List<Integer> sorted = getIndexTargetByElements(array, 23, 0);
        System.out.println(sorted);
    }

    private static boolean findIsArraySorted(int[] array, int index) {
        if (index == array.length - 1) {
            return true;
        }
        if (array[index] > array[index + 1]) return false;
        return findIsArraySorted(array, index + 1);
    }

    // pass the reference of list and add the values to list and return list based on condition
    public static List<Integer> getIndexOfTargetElements(List<Integer> array, int target, int index, List<Integer> list) {
        if (index == array.size() - 1) {
            return list;
        }
        if (array.get(index) == target) {
            list.add(index);
        }
        return getIndexOfTargetElements(array, target, index + 1, list);
    }

    // create new list internally everytime and add the values to the list of previous functions
    public static List<Integer> getIndexTargetByElements(List<Integer> array, int target, int index) {
        List<Integer> list = new ArrayList<>();
        if (index == array.size() - 1) {
            return list;
        }
        if (array.get(index) == target) {
            list.add(index);
        }
        List<Integer> returnedList = getIndexTargetByElements(array, target, index + 1);
        list.addAll(returnedList);
        return list;
    }
}
