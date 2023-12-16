package homework21;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class InventoryPage {
    static String filterSelector = ".select_container";
    static String descSelector = "//option[@value='hilo']";
    static String pricebarSelector = ".pricebar";
    public static void selectAndAddProductsToCart(int numberOfProducts) {
        $(filterSelector).shouldBe(visible).click();
        $x(descSelector).shouldBe(visible).click();
        ElementsCollection products = $$(pricebarSelector).first(numberOfProducts);

        for (int i = 0; i < products.size(); i++) {
            products.get(i).click();
        }
    }
}
