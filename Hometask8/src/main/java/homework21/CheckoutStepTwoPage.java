package homework21;

import com.codeborne.selenide.ElementsCollection;

public class CheckoutStepTwoPage {
    public static Double calculateTotalSum(ElementsCollection items) {
        Double sum = 0.00;

        for (int i = 0; i < items.size(); i++) {
            sum += Double.parseDouble(items.get(i).getText().replace("$", ""));
        }
        return sum;
    }
}
