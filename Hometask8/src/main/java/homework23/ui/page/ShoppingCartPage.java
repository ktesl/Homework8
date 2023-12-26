package homework23.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    @FindBy(css = ".mat-card-content.mat-elevation-z2")
    List<WebElement> cartItem;
    public String bookSearch = "Slayer";
    public String itemQuantity = "//div[@class='div-quantity']";
    public String checkoutBtn = "//button[@class='mat-focus-indicator mat-elevation-z4 mat-raised-button mat-button-base mat-warn']";

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void getCartItems() {
        for (WebElement item : cartItem) {
            WebElement itemTitle = item.findElement(By.linkText(bookSearch));
            WebElement itemQuantity = item.findElement(By.xpath(this.itemQuantity));
            itemTitle.getText();
            wait.until(ExpectedConditions.textToBePresentInElement(itemTitle, "Slayer"));
            itemQuantity.getText();
            wait.until(ExpectedConditions.textToBePresentInElement(itemQuantity, "1"));
        }
    }

    public void getCheckoutPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkoutBtn))).click();
    }
}
