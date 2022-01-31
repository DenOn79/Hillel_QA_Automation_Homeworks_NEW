package selenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DynamicLoadedPage {
    private final SelenideElement exampleLink = $(By.linkText("Example 1: Element on page that is hidden"));

    public void clickExampleLink() {
        exampleLink.shouldBe(Condition.visible).shouldBe(Condition.enabled).click();

    }
}
