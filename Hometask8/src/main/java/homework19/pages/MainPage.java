package homework19.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    public String mainPageUrl = "https://automationexercise.com/";
    static String contactUsUrl = "https://automationexercise.com/contact_us";
    @FindBy(css = "a[href='/contact_us']")
    WebElement contactUsLink;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void getContactUs() {
        contactUsLink.click();
        wait.until(ExpectedConditions.urlToBe(contactUsUrl));
    }
}
