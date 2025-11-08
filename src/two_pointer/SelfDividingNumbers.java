package two_pointer;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public static void main(String[] args) {
        int left = 1, right = 22;
        System.out.println(selfDividingNumbers(left, right));
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        boolean isSelfDividing = true;
        int index = left;
        while (index <= right) {
            isSelfDividing = true;
            if (index == 0) {
                index++;
                continue;
            }
            Integer value = index;
            while (value > 0) {
                int dig = value % 10;
                if (dig == 0 || index % dig != 0) {
                    isSelfDividing = false;
                    break;
                }
                value /= 10;
            }
            if (isSelfDividing) {
                list.add(index);
            }
            index++;
        }
        return list;
    }
}
