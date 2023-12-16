package homework21;

import com.codeborne.selenide.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class SelenideTest {
    final String userName = "standard_user";
    final String password = "secret_sauce";
    final String inventoryPageTitle = "Products";
    final String title = ".title";
    final String cartBtnSelector = ".shopping_cart_link";
    final String cartTitle = "Your Cart";
    final String checkoutBtnId = "#checkout";
    final String checkoutTitle = "Checkout: Your Information";
    final int selectedItem = 2;
    final String[] checkoutData = {"Kate", "Smith", "98765"};
    final String overviewTitle = "Checkout: Overview";
    final String productsInCartSelector = ".inventory_item_price";
    final String summarySelector = ".summary_subtotal_label";
    final String finishBtnId = "#finish";
    final String completeTextSelector = ".complete-header";
    final String completeText = "Thank you for your order!";
    @BeforeTest
    public void setup() {
        Configuration.baseUrl = "https://www.saucedemo.com/";
        Configuration.browserSize = "1440x1100";
    }

    public SelenideElement getElement(String selector){
        return $(selector);
    }

    public String getElementText(String selector){
        return this.getElement(selector).getText();
    }

    @Test
    public void buyProductsTestSelenide() {
        open("");
        LoginPage.login(userName, password);

        assertEquals(this.getElementText(title), inventoryPageTitle);
        InventoryPage.selectAndAddProductsToCart(selectedItem);
        SelenideElement cartBtn = this.getElement(cartBtnSelector);
        cartBtn.shouldBe(visible).click();

        assertEquals(this.getElementText(title), cartTitle);
        SelenideElement checkoutBtn =this.getElement(checkoutBtnId);
        checkoutBtn.click();

        assertEquals(this.getElementText(title), checkoutTitle);
        CheckoutStepOnePage.fillCheckoutInformation(checkoutData);
        assertEquals(this.getElementText(title), overviewTitle);

        ElementsCollection productsInCart = $$(productsInCartSelector);

        Double sumOfProducts = CheckoutStepTwoPage.calculateTotalSum(productsInCart);
        Double totalSum = Double.parseDouble(this.getElementText(summarySelector).replace("Item total: $", "")
        );
        assertEquals(totalSum, sumOfProducts);

        SelenideElement finishBtn = this.getElement(finishBtnId);
        finishBtn.click();
        assertEquals(this.getElementText(completeTextSelector), completeText);
    }

}



