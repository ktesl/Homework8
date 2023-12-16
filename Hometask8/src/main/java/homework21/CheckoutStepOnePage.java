package homework21;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutStepOnePage {
    static String[] selectors = {"#first-name", "#last-name", "#postal-code"};
    public static void fillCheckoutInformation(String[] data) {
        for(int i = 0; i < data.length; i++) {
            $(selectors[i]).setValue(data[i]);
        }

        $("#continue").click();
    }
}
