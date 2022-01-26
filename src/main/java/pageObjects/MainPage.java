package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPage() {
        driver.findElement(By.linkText("Form Authentication")).click();
        return new LoginPage(driver);
    }

    public ChallengePage goToChallengePage() {
        driver.findElement(By.linkText("Challenging DOM")).click();
        return new ChallengePage(driver);
    }

    public GeolocationPage goToGeolocationPage() {
        driver.findElement(By.linkText("Geolocation")).click();
        return new GeolocationPage(driver);
    }

    public DownloadPage goToDownloadPage() {
        driver.findElement(By.linkText("File Download")).click();
        return new DownloadPage(driver);
    }

    public UploadPage goToUploadPage() {
        driver.findElement(By.linkText("File Upload")).click();
        return new UploadPage(driver);
    }
}