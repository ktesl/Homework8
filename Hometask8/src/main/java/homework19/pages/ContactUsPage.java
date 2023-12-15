package homework19.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactUsPage extends BasePage {
    @FindBy(name = "name")
    WebElement nameInput;

    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(name = "subject")
    WebElement subjectInput;

    @FindBy(name = "message")
    WebElement messageInput;

    @FindBy(name = "submit")
    public
    WebElement submitBtn;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setInputName(String name) {
        nameInput.sendKeys(name);
    }

    public void setInputEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void setInputSubject(String subject) {
        subjectInput.sendKeys(subject);
    }

    public void setInputMessage(String message) {
        messageInput.sendKeys(message);
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".status.alert.alert-success")));
    }
}
