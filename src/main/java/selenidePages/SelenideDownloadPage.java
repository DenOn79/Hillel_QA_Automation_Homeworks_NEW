package selenidePages;

import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;

public class SelenideDownloadPage {

    public File downloadFile(String fileName) {
        try {
            return $(By.linkText(fileName)).download();
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}
