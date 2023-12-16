package homework21;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public static void login(String username, String password) {
        $("#user-name").setValue(username);
        $("#password").setValue(password);
        $("#login-button").click();
    }
}
