package DSA_100;

import java.util.ArrayList;
import java.util.List;

public class Solutions {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        generateParenthesis(3, 3, "", result);
        System.out.println(result);
    }


    private static void generateParenthesis(int open, int close,
                                            String para,
                                            List<String> result) {

        if (open == 0 && close == 0) {
            result.add(para);
            return;
        }

        if (open > 0) {
            generateParenthesis(open - 1, close,
                    para + "(", result);
        }

        if (close > open) {   // IMPORTANT CONDITION
            generateParenthesis(open, close - 1,
                    para + ")", result);
        }
    }
}
