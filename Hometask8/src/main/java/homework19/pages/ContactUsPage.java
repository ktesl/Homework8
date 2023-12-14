package homework19.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

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

    public Properties getProperties() {
        File file = new File("C:\\Hillel\\my_project\\Homework8\\Hometask8\\src\\test\\resources\\homework19.properties");

        Properties properties = new Properties();
        try {
            properties.load(new FileReader(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public String getName() {
        return this.getProperties().getProperty("name", "dot");
    }

    public String getEmail() {
        return this.getProperties().getProperty("email");
    }

    public String getSubject() {
        return this.getProperties().getProperty("subject");
    }

    public String getMessage() {
        return this.getProperties().getProperty("message");
    }

    public void setInputName() {
        nameInput.sendKeys(this.getName());
    }

    public void setInputEmail() {
        emailInput.sendKeys(this.getEmail());
    }

    public void setInputSubject() {
        subjectInput.sendKeys(this.getSubject());
    }

    public void setInputMessage() {
        messageInput.sendKeys(this.getMessage());
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".status.alert.alert-success")));
    }
}
