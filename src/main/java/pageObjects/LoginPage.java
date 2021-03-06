package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@class = 'radius']")
    private WebElement loginButton;

    @FindBy(css = ".flash.error")
    private WebElement errorAlertText;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Enter username")
    public LoginPage setUsername(String username) {
        userNameInput.sendKeys(username);
        return this;
    }

    @Step("Enter password")
    public LoginPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Click login button")
    public SecurePage clickLoginButton() {
         clickButton(loginButton);
         return new SecurePage(driver);
    }

    public String getErrorMessage() {
        return errorAlertText.getText();
    }
}
