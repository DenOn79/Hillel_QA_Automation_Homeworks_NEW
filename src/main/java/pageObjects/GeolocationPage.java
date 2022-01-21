package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GeolocationPage extends BasePage {

    @FindBy(xpath = "//button[@onclick = 'getLocation()']")
    private WebElement buttonWhereAmI;

    private final By byLatitudeValue = By.xpath ("//div[@id = 'lat-value']");

    private final By byLongitudeValue = By.xpath ("//div[@id = 'long-value']");

    public GeolocationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public GeolocationPage clickWhereButton() {
        clickButton(buttonWhereAmI);
        return this;
    }

    public GeolocationPage getLatValue() {
        System.out.println("Latitude: " + webDriverWait.until(ExpectedConditions.presenceOfElementLocated(byLatitudeValue)).getText());
        return this;
    }

    public GeolocationPage getLongValue() {
        System.out.println("Longitude: " + webDriverWait.until(ExpectedConditions.presenceOfElementLocated(byLongitudeValue)).getText());
        return this;
    }
}
