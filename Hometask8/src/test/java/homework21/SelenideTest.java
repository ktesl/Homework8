package homework21;

import com.codeborne.selenide.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class SelenideTest {
    final String productsInCartSelector = ".inventory_item_price";
    final String summarySelector = ".summary_subtotal_label";
    final String completeTextSelector = ".complete-header";
    final String completeText = "Thank you for your order!";

    @BeforeTest
    public void setup() {
        Configuration.baseUrl = "https://www.saucedemo.com/";
        Configuration.browserSize = "1440x1100";
    }

    public SelenideElement getElement(String selector) {
        return $(selector);
    }

    public String getElementText(String selector) {
        return this.getElement(selector).getText();
    }

    @Test
    public void buyProductsTestSelenide() {
        open("");
        LoginPage.login();
        InventoryPage.checkInventoryTitle();
        InventoryPage.selectAndAddProductsToCart();
        InventoryPage.clickCartButton();
        InventoryPage.checkCartTitle();
        InventoryPage.clickCheckoutBtn();
        CheckoutStepOnePage.checkCheckoutTitle();
        CheckoutStepOnePage.fillCheckoutInformation();
        CheckoutStepOnePage.clickContinueBtn();
        CheckoutStepTwoPage.checkOverviewTitle();
        ElementsCollection productsInCart = $$(productsInCartSelector);
        Double sumOfProducts = CheckoutStepTwoPage.calculateTotalSum(productsInCart);
        Double totalSum = Double.parseDouble(this.getElementText(summarySelector).replace("Item total: $", "")
        );
        assertEquals(totalSum, sumOfProducts);
        CheckoutStepTwoPage.clickFinishBtn();
        assertEquals(this.getElementText(completeTextSelector), completeText);
    }

}



