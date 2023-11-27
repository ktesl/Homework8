package homework17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class CssLocatorsTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testDemo() {
        String url = "https://www.saucedemo.com/";
        driver.get(url);

        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.click();
        String username = "standard_user";
        Actions actions = new Actions(driver);
        actions.sendKeys(usernameInput, username)
                .build()
                .perform();

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        String password = "secret_sauce";
        actions.sendKeys(passwordInput, password)
                .build()
                .perform();

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        String originalWindow = driver.getWindowHandle();

        assert driver.getWindowHandles().size() == 1;

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");

        WebElement linkedinBtn = driver.findElement(By.cssSelector("a[href*=\'linkedin\']"));
        linkedinBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        wait.until(ExpectedConditions.titleContains("LinkedIn"));

        driver.close();
        driver.switchTo().window(originalWindow);

        WebElement menuBtn = driver.findElement(By.id("react-burger-menu-btn"));
        menuBtn.click();

        WebElement logoutBtn = driver.findElement(By.cssSelector("#logout_sidebar_link"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        logoutBtn.click();
        wait.until(ExpectedConditions.urlToBe(url));
    }
}
