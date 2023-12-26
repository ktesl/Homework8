package homework23.ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    @FindBy(id = "mat-input-0")
    WebElement usernameInput;

    @FindBy(id = "mat-input-1")
    WebElement passwordInput;

    @FindBy(css = "button.mat-focus-indicator.mat-raised-button.mat-button-base.mat-primary")
    WebElement loginButton;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setInputUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void setInputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void getLoginPage() {
        loginButton.click();
    }
}
