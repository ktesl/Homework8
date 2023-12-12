package homework18;

import homework18.pages.CheckoutStepTwoPage;
import homework18.pages.InventoryPage;
import homework18.utils.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginLogoutPomTest extends BaseTest {

    @Test
    public void loginLogoutTest() {
        String inventoryTitle = login()
                .setUserName("standard_user")
                .setPassword("secret_sauce")
                .submit()
                .getInventoryContainer();
        Assert.assertEquals(inventoryTitle, "Products");
    }

    @Test
    public void buyProductTest() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        login()
                .setUserName("standard_user")
                .setPassword("secret_sauce")
                .submit()
                .addProductWithMaxPriceToCart()
                .checkAddToCart();
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkout()
                .setFirstName("Kate")
                .setLastName("Smith")
                .setPostalCode("98765")
                .continueBtn()
                .getCartOverview();
        WebElement checkoutStepTwoPageText = checkoutStepTwoPage.summaryPrice;
        WebElement maxPricesText = inventoryPage.getProductWithMaxPrices();
        Assert.assertEquals(
                inventoryPage.replace(checkoutStepTwoPageText, "Item total: $"),
                inventoryPage.replace(maxPricesText, "$")
        );
        checkoutStepTwoPage.finishBtn();
    }
}

