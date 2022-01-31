package selenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class DynamicLoadedPage_1 {
    private final SelenideElement startButton = $(By.xpath("//div[@id = 'start']/button"));
    private final SelenideElement finishText = $(By.xpath("//div[@id = 'finish']/h4"));

    public void clickStartButton() {
        startButton.shouldBe(Condition.visible).shouldBe(Condition.enabled).click();
    }

    public String getFinishText() {
        return finishText.shouldBe(Condition.visible, Duration.ofSeconds(15)).getText();
    }
}

