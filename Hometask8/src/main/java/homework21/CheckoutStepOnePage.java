package homework21;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutStepOnePage {
    static SelenideElement title = $(".title");
    static final String checkoutTitle = "Checkout: Your Information";
    static SelenideElement continueBtn = $("#continue");

    public static void fillCheckoutInformation() {
        $("#first-name").setValue("Kate");
        $("#last-name").setValue("Smith");
        $("#postal-code").setValue("98765");
    }

    public static void clickContinueBtn() {
        continueBtn.click();
    }

    public static void checkCheckoutTitle() {
        title.shouldHave(text(checkoutTitle));
    }
}
