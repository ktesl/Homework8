package homework23.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage{
    public String nameInput = "//input[@formcontrolname='name']";
    public String address1Input = "//input[@formcontrolname='addressLine1']";
    public String address2Input = "//input[@formcontrolname='addressLine2']";
    public String pincodeInput = "//input[@formcontrolname='pincode']";
    public String stateInput = "//input[@formcontrolname='state']";
    public String submitBtn = "//button[@type='submit']";

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setNameInput(String name) {
        WebElement nameInput = driver.findElement(By.xpath(this.nameInput));
        nameInput.sendKeys(name);
    }

    public void setAddress1Input(String address1) {
        WebElement address1Input = driver.findElement(By.xpath(this.address1Input));
        address1Input.sendKeys(address1);
    }

    public void setAddress2Input(String address2) {
        WebElement address2Input = driver.findElement(By.xpath(this.address2Input));
        address2Input.sendKeys(address2);
    }

    public void setPincodeInput(String pincode) {
        WebElement pincodeInput = driver.findElement(By.xpath(this.pincodeInput));
        pincodeInput.sendKeys(pincode);
    }

    public void setStateInput(String state) {
        WebElement stateInput = driver.findElement(By.xpath(this.stateInput));
        stateInput.sendKeys(state);
    }

    public void clickSubmitBtn() {
        driver.findElement(By.xpath(submitBtn)).click();
    }
}
