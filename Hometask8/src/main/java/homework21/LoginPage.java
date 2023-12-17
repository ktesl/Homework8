package homework21;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    static final String userName = "standard_user";
    static final String password = "secret_sauce";

    public static void login() {
        $("#user-name").setValue(userName);
        $("#password").setValue(password);
        $("#login-button").click();
    }
}
