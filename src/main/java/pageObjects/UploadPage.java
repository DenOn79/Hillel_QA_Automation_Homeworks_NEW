package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.File;


public class UploadPage extends BasePage {
    @FindBy(css = "input[type = 'file']")
    private WebElement chooseFileButton;

    @FindBy(xpath = "//input[@type = 'submit']")
    private WebElement submitButton;

    public UploadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public UploadPage selectFileToUpload(File fileToUpload) {
        chooseFileButton.sendKeys(String.valueOf(fileToUpload));
        return this;
    }

    public UploadPage submitUpload() {
        clickButton(submitButton);
        return this;
    }
}
