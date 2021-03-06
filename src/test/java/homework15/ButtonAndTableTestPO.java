package homework15;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.MainPage;
import pageObjects.ChallengePage;

public class ButtonAndTableTestPO extends BaseTest {

    @Test(description = "Click buttons and output from the table.")
    public void locatorTest() {

        MainPage mainPage = new MainPage(driver);
        ChallengePage challengePage = openApp().goToChallengePage()
                .clickButton()
                .clickButtonAlert()
                .clickButtonSuccess()
                .outputTableElements();

    }

}
