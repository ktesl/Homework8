package homework18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutStepTwoPage extends BasePage {
    @FindBy(id = "first-name")
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

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    String urlCheckoutStepTwo = "https://www.saucedemo.com/checkout-step-two.html";


    public CheckoutStepTwoPage setFirstName(String firstName) {
        setText(firstNameField, firstName);
        return this;
    }

    public CheckoutStepTwoPage setLastName(String lastName) {
        setText(lastNameField, lastName);
        return this;
    }

    public CheckoutStepTwoPage setPostalCode(String postalCode) {
        setText(postalCodeField, postalCode);
        return this;
    }

    public CheckoutStepTwoPage continueBtn() {
        clickButton(continueBtn);
        return new CheckoutStepTwoPage(driver);
    }

    public CheckoutStepTwoPage getCartOverview() {
        wait.until(ExpectedConditions.urlToBe(urlCheckoutStepTwo));
        return this;
    }

    public void finishBtn() {
        clickButton(finishBtn);
        wait.until(ExpectedConditions.urlToBe(CheckoutCompletePage.urlCheckoutComplete));
        new CheckoutStepTwoPage(driver);
    }
}
