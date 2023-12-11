package homework18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    @FindBy(id = "user-name")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public LoginPage setUserName(String userName){
        setText(userNameField, userName);
        return this;
    }

    public LoginPage setPassword(String password){
        setText(passwordField, password);
        return this;
    }
    public InventoryPage submit(){
        clickButton(loginButton);
        return new InventoryPage(driver);
    }

    public void login(String userName, String password){
        setUserName(userName);
        setPassword(password);
        submit();
    }

}
