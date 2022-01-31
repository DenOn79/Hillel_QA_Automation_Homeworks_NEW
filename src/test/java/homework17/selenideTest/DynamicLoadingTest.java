package homework17.selenideTest;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenidePages.DynamicLoadedPage;
import selenidePages.DynamicLoadedPage_1;

import static com.codeborne.selenide.Selenide.open;

public class DynamicLoadingTest {
    @Test
    public void dynamicLoading() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";

        open("/dynamic_loading");

        DynamicLoadedPage example1Link = new DynamicLoadedPage();
        example1Link.clickExampleLink();

        DynamicLoadedPage_1 dynLoadPage_1 = new DynamicLoadedPage_1();
        dynLoadPage_1.clickStartButton();

        DynamicLoadedPage_1 finishText = new DynamicLoadedPage_1();
        String finishSign = finishText.getFinishText();
        System.out.println(finishSign);

        Assert.assertEquals(finishSign, "Hello World!");
    }

}
