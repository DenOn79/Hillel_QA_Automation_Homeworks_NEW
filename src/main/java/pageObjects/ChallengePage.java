package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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

}



