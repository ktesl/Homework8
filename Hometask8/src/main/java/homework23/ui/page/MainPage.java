package homework23.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.NoSuchElementException;

public class MainPage extends BasePage{
    public String mainPageUrl = "https://bookcart.azurewebsites.net/";
    public String inputSearch = "//input[@type='search']";
    public String searchSlayer = "//span[@class='mat-option-text']";
    public String addToCartAlert = "//div[@class='mat-simple-snackbar-action ng-star-inserted']//button";
    public String addToCartBtn = "button.mat-focus-indicator.mat-raised-button.mat-button-base.mat-primary";
    public String loginBtn = "button.mat-focus-indicator.mat-button.mat-button-base.ng-star-inserted";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void setInputSearch(String search) {
        driver.findElement(By.xpath(inputSearch)).sendKeys(search);
    }

    public void clickSearchSlayer() {
        driver.findElement(By.xpath(searchSlayer)).click();
    }

    public void getAddToCartAlert() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(addToCartAlert))));
        driver.findElement(By.xpath(addToCartAlert)).click();
    }

    public void clickAddToCartBtn() {
        driver.findElement(By.cssSelector(addToCartBtn)).click();
    }

    public void login() {
        driver.findElement(By.cssSelector(loginBtn)).click();
    }

    public void getLoginPage() {
        driver.findElement(By.cssSelector(loginBtn)).click();
    }

    public void getShoppingCartPage() {
        List<WebElement> cartButton = driver.findElements(By.cssSelector("button.mat-focus-indicator.mat-icon-button.mat-button-base"));
        for (WebElement btn : cartButton) {
            List<WebElement> spanElements = btn.findElements(By.id("mat-badge-content-0"));

            if (!spanElements.isEmpty()) {
                btn.click();
                return;
            }
        }

        throw new NoSuchElementException("Element not found");
    }
}
