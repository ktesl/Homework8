package homework9;

public class Task2 {

    public static String remove(String mainString, String removableString) {
        if (mainString == null || removableString == null) {
            return mainString;
        }

        return mainString.replace(removableString, "");
    }

    public static void main(String... args) {
        String mainString = "This is the test string";
        String removableString = "st";
        String newString = remove(mainString, removableString);

        System.out.println("The main string is: " + mainString);
        System.out.println("The new string is: " + newString);
    }
}
