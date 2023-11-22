package homework9;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {

    public static boolean validatePhoneNumber(String phoneNumber) {

        String regex = "\\+38\\(0[0-9]{2}\\)[0-9]{7}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your phone number in format: +38(0хх)ххххххх where x - number from 0 till 9");
        String userPhoneNumber = scanner.nextLine();

        if (validatePhoneNumber(userPhoneNumber)) {
            System.out.println("Your phone number is in correct format");
        } else {
            System.out.println("Your phone number is not in correct format");
        }
    }
}
