package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Go to Login Page")
    public LoginPage goToLoginPage() {
        driver.findElement(By.linkText("Form Authentication")).click();
        return new LoginPage(driver);
    }

    @Step("Go to Challenge Page")
    public ChallengePage goToChallengePage() {
        driver.findElement(By.linkText("Challenging DOM")).click();
        return new ChallengePage(driver);
    }

    @Step("Go to Geolocation Page")
    public GeolocationPage goToGeolocationPage() {
        driver.findElement(By.linkText("Geolocation")).click();
        return new GeolocationPage(driver);
    }

    @Step("Go to Download Page")
    public DownloadPage goToDownloadPage() {
        driver.findElement(By.linkText("File Download")).click();
        return new DownloadPage(driver);
    }

    @Step("Go to Upload Page")
    public UploadPage goToUploadPage() {
        driver.findElement(By.linkText("File Upload")).click();
        return new UploadPage(driver);
    }
}
