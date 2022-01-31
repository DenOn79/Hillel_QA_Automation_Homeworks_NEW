package selenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class SelenideUploadPage {
    public final SelenideElement chooseFile = $("#file-upload");
    public final SelenideElement submitUploadingFile = $("#file-submit");

    public void uploadFile(File fileName) {
        chooseFile.shouldBe(Condition.visible).uploadFile(fileName);
        submitUploadingFile.shouldBe(Condition.visible).click();
    }
}
