package string;

public class ReverseWordsInAString_151 {
    public static void main(String[] args) {
        String s = " the   sky is blue";
        String result = reverseWords(s);
        System.out.println(result);
    }

    private static String reverseWords(String s) {
        s = s.trim();
        StringBuilder result = new StringBuilder();
        System.out.println(s);
        int high = s.length()-1;
        int low = s.length()-1;
        while (high >= 0) {
            if (s.charAt(low) != ' ') {
                low--;
            } else {
                String res = s.substring(low, high);
                System.out.println(res);
                while (s.charAt(low) == ' ') {
                    low--;
                }
                high = low;
            }
        }
        return "";
    }
}
