package homework19.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    public String mainPageUrl = "https://automationexercise.com/";
    @FindBy(css = "a[href='/contact_us']")
    WebElement contactUsLink;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ContactUsPage getContactUs(WebDriver driver) {
        contactUsLink.click();
        return new ContactUsPage(driver);
    }
}
