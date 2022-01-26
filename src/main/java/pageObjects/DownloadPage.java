package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownloadPage extends BasePage {
    @FindBy(linkText = "some-file.txt")
    private WebElement fileLink;

    public DownloadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public DownloadPage downloadFile() {
        clickButton(fileLink);
        return this;
    }
}

