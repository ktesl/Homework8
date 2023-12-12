package homework18.utils;

import homework18.pages.CheckoutStepTwoPage;
import homework18.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public LoginPage login() {
        driver.get("https://www.saucedemo.com/");
        return new LoginPage(driver);
    }

    public CheckoutStepTwoPage checkout() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        return new CheckoutStepTwoPage(driver);
    }
}
