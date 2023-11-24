package homework16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ExceptionsWaitsTest {
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
    public void hiddenElementTest() {
        String url = "https://the-internet.herokuapp.com/dynamic_loading/1";
        driver.get(url);

        WebElement startBtn = driver.findElement(By.xpath("//button[text()='Start']"));
        startBtn.click();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

        Assert.assertEquals(text.getText(), "Hello World!");
    }

    @Test
    public void renderedElementTest() {
        String url = "https://the-internet.herokuapp.com/dynamic_loading/2";
        driver.get(url);

        WebElement startBtn = driver.findElement(By.xpath("//button[text()='Start']"));
        startBtn.click();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement text = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));

        Assert.assertEquals(text.getText(), "Hello World!");
    }

    @Test
    public void clickBtnTest() throws InterruptedException {
        String url = "https://www.selenium.dev/selenium/web/dynamic.html";
        int clicksCount = 0;
        int iterations = 3;
        driver.get(url);

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addBoxBtn = driver.findElement(By.id("adder"));
        for (int i = 0; i < iterations; i++) {
            addBoxBtn.click();
            clicksCount++;

            List<WebElement> redboxes = wait.until(ExpectedConditions.numberOfElementsToBe(By.className("redbox"), clicksCount));
        }

        WebElement inputBtn = driver.findElement(By.id("reveal"));
        for (int i = 0; i < iterations; i++) {
            inputBtn.click();

            List<WebElement> inputs = wait.until(ExpectedConditions.numberOfElementsToBe(By.id("revealed"), 1));
        }
    }
}
