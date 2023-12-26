package homework20;

import homework20.utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import java.time.Duration;

public class DownloadFileTest extends BaseTest {
    @Test
    public void downloadFileTest() {
        driver.get("https://the-internet.herokuapp.com/download");

        String fileName = "csv file.csv";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chromeDriverFile =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(fileName)));
        chromeDriverFile.click();

        Assert.assertTrue(waitFileDownloaded(DOWNLOAD_FOLDER_PATH, fileName, 10));

        Assert.assertTrue(hasCorrectExtension(DOWNLOAD_FOLDER_PATH + "/" + fileName, ".zip"));
    }

    public boolean hasCorrectExtension(String filePath, String extension) {
        File file = new File(filePath);
        String fileName = file.getName();
        return fileName.endsWith(extension);
    }

    public boolean waitFileDownloaded(String directory, String fileName, int timeoutInSec) {
        for (int i = 0; i < timeoutInSec; i++) {
            File file = new File(directory + "/" + fileName);
            if (file.exists() & file.length() > 0) return true;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

}
