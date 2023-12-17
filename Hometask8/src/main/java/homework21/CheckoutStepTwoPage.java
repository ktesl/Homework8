package homework21;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutStepTwoPage {
    static SelenideElement finishBtnId = $("#finish");
    static SelenideElement title = $(".title");
    static final String overviewTitle = "Checkout: Overview";

    public static Double calculateTotalSum(ElementsCollection items) {
        Double sum = 0.00;

        for (int i = 0; i < items.size(); i++) {
            sum += Double.parseDouble(items.get(i).getText().replace("$", ""));
        }
        return sum;
    }

    public static void clickFinishBtn() {
        finishBtnId.click();
    }

    public static void checkOverviewTitle() {
        title.shouldHave(text(overviewTitle));
    }


}
