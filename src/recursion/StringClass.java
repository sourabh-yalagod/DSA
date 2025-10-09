package recursion;

public class StringClass {
    public static void main(String[] args) {
        String string = skipApple("Sappleourabh");
        System.out.println(string);
    }

    public static String removeAs(String unProcessed) {
        // Base case: if no more characters to process
        if (unProcessed.isEmpty()) return "";
        char ch = unProcessed.charAt(0);
        if (ch == 'a') {
            return removeAs(unProcessed.substring(1));
        }
        return ch + removeAs(unProcessed.substring(1));
    }

    public static String skipApple(String string) {
        if (string.isEmpty()) return "";
        if (string.startsWith("apple")) {
            return skipApple(string.substring(5));
        }
        return string.charAt(0) + skipApple(string.substring(1));
    }
}
