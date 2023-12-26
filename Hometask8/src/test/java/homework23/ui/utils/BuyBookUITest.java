package homework23.ui.utils;

import homework23.ui.page.*;
import org.testng.annotations.Test;

import java.util.Properties;

public class BuyBookUITest extends BaseTest {


    @Test
    public void buyBookTest() {
        MainPage mainPage = new MainPage(driver);
        driver.get(mainPage.mainPageUrl);
        Properties properties = new ConfigLoaderTest().getProperties();
        mainPage.setInputSearch(properties.getProperty("search"));
        mainPage.clickSearchSlayer();
        mainPage.clickAddToCartBtn();
        mainPage.getLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setInputUsername(properties.getProperty("username"));
        loginPage.setInputPassword(properties.getProperty("password"));
        loginPage.getLoginPage();
        mainPage.getAddToCartAlert();
        mainPage.getShoppingCartPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.getCartItems();
        shoppingCartPage.getCheckoutPage();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setNameInput(properties.getProperty("name"));
        checkoutPage.setAddress1Input(properties.getProperty("addressLine1"));
        checkoutPage.setAddress2Input(properties.getProperty("addressLine2"));
        checkoutPage.setPincodeInput(properties.getProperty("pincode"));
        checkoutPage.setStateInput(properties.getProperty("state"));
        checkoutPage.clickSubmitBtn();
    }
}
