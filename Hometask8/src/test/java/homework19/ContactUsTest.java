package homework19;

import homework18.utils.BaseTest;
import homework19.pages.ContactUsPage;
import homework19.pages.MainPage;
import org.testng.annotations.Test;

import java.util.Properties;


public class ContactUsTest extends BaseTest {
    @Test
    public void contactUsTest() {
        MainPage mainPage = new MainPage(driver);
        driver.get(mainPage.mainPageUrl);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        Properties properties = new ConfigLoaderTest().getProperties();
        mainPage.getContactUs(driver);
        contactUsPage.setInputName(properties.getProperty("name"));
        contactUsPage.setInputEmail(properties.getProperty("email", "234@fd.fd"));
        contactUsPage.setInputSubject(properties.getProperty("subject", "123"));
        contactUsPage.setInputMessage(properties.getProperty("message", "765"));
        contactUsPage.submitBtn.submit();
        contactUsPage.acceptAlert();
    }
}

