package homework19;

import homework18.utils.BaseTest;
import homework19.pages.ContactUsPage;
import homework19.pages.MainPage;
import org.testng.annotations.Test;


public class ContactUsTest extends BaseTest {
    @Test
    public void contactUsTest() {
        MainPage mainPage = new MainPage(driver);
        driver.get(mainPage.mainPageUrl);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        mainPage.getContactUs();
        contactUsPage.setInputName();
        contactUsPage.setInputEmail();
        contactUsPage.setInputSubject();
        contactUsPage.setInputMessage();
        contactUsPage.submitBtn.click();
        contactUsPage.acceptAlert();
    }
}

