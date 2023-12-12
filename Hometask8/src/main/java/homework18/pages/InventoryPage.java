package homework18.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class InventoryPage extends BasePage {
    @FindBy(className = "title")
    WebElement title;
    @FindBy(css = "div[class='inventory_item_price']")
    List<WebElement> itemPrice;

    @FindBy(className = "shopping_cart_link")
    WebElement cartLink;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    String urlCart = "https://www.saucedemo.com/cart.html";
    static String urlCheckoutStepOne = "https://www.saucedemo.com/checkout-step-one.html";

    public String getInventoryContainer() {
        return String.valueOf(title.getText());
    }

    public String replace(WebElement element, String target) {
        return element.getText().replace(target, "");
    }

    public WebElement getProductWithMaxPrices() {

        return itemPrice.stream()
                .max((priceElement1, priceElement2) ->
                        Double.compare(
                                Double.parseDouble(this.replace(priceElement1, "$")),
                                Double.parseDouble(this.replace(priceElement2, "$"))
                        ))
                .orElse(null);
    }

    public InventoryPage addProductWithMaxPriceToCart() {
        WebElement maxPriceElement = this.getProductWithMaxPrices();

        if (maxPriceElement != null) {
            WebElement addToCartButton = maxPriceElement.findElement(By.xpath("./following-sibling::button[@class='btn btn_primary btn_small btn_inventory ']"));
            addToCartButton.click();
        }
        return this;
    }

    public void checkAddToCart() {
        cartLink.click();
        wait.until(ExpectedConditions.urlToBe(urlCart));
        checkoutButton.click();
        wait.until(ExpectedConditions.urlToBe(urlCheckoutStepOne));
    }
}
