package string;

public class SubString {
    public static void main(String[] args) {
        String s = "abcd";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < s.length(); j++) {
                String sub = s.substring(i, j);
                System.out.print(sub+" ");
            }
        }
    }
}
