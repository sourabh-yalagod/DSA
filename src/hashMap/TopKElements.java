package hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKElements {
    public static void main(String[] args) {
        int[] array = {1, 2, 32,32, 32, 2, 3, 3};
        int k = 2;
        int[] eles = topKElement(array, k);
    }

    private static int[] topKElement(int[] array, int k) {
        int[] result = new int[k];
        int count=k;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int value = map.get(array[i]);
                map.put(array[i], value + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        System.out.println(map);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = map.values().size() - 1; i >= 0; i++) {
            if(map.containsValue(i)){

            }
        }
        return result;
    }
}
