package homework9;

public class Task1 {

    public static String recursion(String text) {
        if (text == null || text.length() <= 1) {
            return text;
        }
        return recursion(text.substring(1)) + text.charAt(0);
    }

    public static void main(String[] args) {
        String originalString = "Java, World!";
        String reversedString = recursion(originalString);

        System.out.println("Original string: " + originalString);
        System.out.println("Reversed string: " + reversedString);

    }
}