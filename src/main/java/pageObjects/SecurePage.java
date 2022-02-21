package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SecurePage extends BasePage {

    private final By byAlertText = By.cssSelector(".flash.success");

    public SecurePage(WebDriver driver) {
        super(driver);
    }

    public String getAlertText() {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(byAlertText)).getText();
    }

    @Step("Click logout and return to Home page")
    public LoginPage logout() {
        this.driver.findElement(By.cssSelector(".button.secondary.radius")).click();
        return new LoginPage(driver);
    }
}
