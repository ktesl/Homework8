package homework9;

public class Task3 {

    public static String remove(String initialString, String charactersToRemove) {
        if (initialString == null || charactersToRemove == null) {
            return initialString;
        }

        String regex = "[" + charactersToRemove + "]";

        return initialString.replaceAll(regex, "");
    }

    public static void main(String... args) {
        String initialString = "abcd4efabc123deabcdaaa";
        String charactersToRemove = "ad3";
        String modifiedString = remove(initialString, charactersToRemove);

        System.out.println("Initial string: " + initialString);
        System.out.println("Modified string: " + modifiedString);
    }
}
