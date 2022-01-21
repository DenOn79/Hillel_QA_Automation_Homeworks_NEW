package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class ChallengePage extends BasePage {

    @FindBy(xpath = "//a[@class = 'button']")
    private WebElement justButton;

    @FindBy(xpath = "//a[@class = 'button alert']")
    private WebElement buttonAlert;

    @FindBy(xpath = "//a[@class = 'button success']")
    private WebElement buttonSuccess;


    public ChallengePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ChallengePage clickButton() {
        clickButton(justButton);
        return this;
    }

    public ChallengePage clickButtonAlert() {
        clickButton(buttonAlert);
        return this;
    }

    public ChallengePage clickButtonSuccess() {
        clickButton(buttonSuccess);
        return this;
    }

    public ChallengePage outputTableElements() {
        for (int i = 1; i <= 10; i++) {
            String element = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[4]")).getText();
            System.out.println(element);
        }
        return this;
    }

}



