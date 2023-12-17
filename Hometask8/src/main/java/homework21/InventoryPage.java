package homework21;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class InventoryPage {
    static final String inventoryPageTitle = "Products";
    static final String cartTitle = "Your Cart";
    static int selectedItem = 2;

    static SelenideElement title = $(".title");
    static String filterSelector = ".select_container";
    static String descSelector = "//option[@value='hilo']";
    static SelenideElement cartBtnSelector = $(".shopping_cart_link");
    static SelenideElement checkoutBtnId = $("#checkout");
    static String pricebarSelector = ".pricebar";

    public static void selectAndAddProductsToCart() {
        $(filterSelector).shouldBe(visible).click();
        $x(descSelector).shouldBe(visible).click();
        ElementsCollection products = $$(pricebarSelector).first(selectedItem);

        for (int i = 0; i < products.size(); i++) {
            products.get(i).click();
        }
    }

    public static void clickCartButton() {
        cartBtnSelector.shouldBe(visible).click();
    }

    public static void clickCheckoutBtn() {
        checkoutBtnId.click();
    }

    public static void checkInventoryTitle() {
        title.shouldHave(text(inventoryPageTitle));
    }

    public static void checkCartTitle() {
        title.shouldHave(text(cartTitle));
    }
}
