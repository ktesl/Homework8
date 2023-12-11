package homework18;

import homework18.pages.CheckoutPage;
import homework18.pages.InventoryPage;
import homework18.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginLogoutPomTest extends BaseTest {

    @Test
    public void LoginLogoutTest() {
        String inventoryTitle = login()
                .setUserName("standard_user")
                .setPassword("secret_sauce")
                .submit()
                .getInventoryContainer();
        Assert.assertEquals(inventoryTitle, "Products");
    }

    @Test
    public void BuyProductTest() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        String inventoryLogin = login()
                .setUserName("standard_user")
                .setPassword("secret_sauce")
                .submit()
                .addProductWithMaxPriceToCart()
                .checkAddToCart();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CheckoutPage checkOut = checkout()
                .setFirstName("Kate")
                .setLastName("Smith")
                .setPostalCode("98765")
                .continueBtn()
                .getCartOverview();
        Assert.assertEquals(
                checkoutPage.summaryPrice.getText().replace("Item total: $", ""),
                inventoryPage.getProductWithMaxPrices().getText().replace("$", "")
        );
        checkoutPage.finishBtn();
    }
}

