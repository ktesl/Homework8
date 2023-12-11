package homework18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {
    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstNameField;

    @FindBy(id = "last-name")
    WebElement lastNameField;

    @FindBy(id = "postal-code")
    WebElement postalCodeField;

    @FindBy(id = "continue")
    WebElement continueBtn;

    @FindBy(className = "summary_subtotal_label")
    public WebElement summaryPrice;

    @FindBy(id = "finish")
    public WebElement finishBtn;

    @FindBy(id = "inventory_item_price")
    WebElement inventoryItemPrice;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    String urlCheckoutStepTwo = "https://www.saucedemo.com/checkout-step-two.html";
    String urlCheckoutComplete = "https://www.saucedemo.com/checkout-complete.html";

    public CheckoutPage setFirstName(String firstName) {
        setText(firstNameField, firstName);
        return this;
    }

    public CheckoutPage setLastName(String lastName) {
        setText(lastNameField, lastName);
        return this;
    }

    public CheckoutPage setPostalCode(String postalCode) {
        setText(postalCodeField, postalCode);
        return this;
    }

    public CheckoutPage continueBtn() {
        clickButton(continueBtn);
        return new CheckoutPage(driver);
    }

    public CheckoutPage checkout(String firstName, String lastName, String postalCode) {
        wait.until(ExpectedConditions.urlToBe(InventoryPage.urlCheckoutStepOne));
        setFirstName(firstName);
        setLastName(lastName);
        setPostalCode(postalCode);
        continueBtn();
        return this;
    }

    public CheckoutPage getCartOverview() {
        wait.until(ExpectedConditions.urlToBe(urlCheckoutStepTwo));
        WebElement itemPrice = inventoryItemPrice;
        return this;
    }

    public void finishBtn() {
        clickButton(finishBtn);
        wait.until(ExpectedConditions.urlToBe(urlCheckoutComplete));
        new CheckoutPage(driver);
    }
}
