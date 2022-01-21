package homework15;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.SecurePage;

public class LoginTestPO extends BaseTest {

    @Test(description = "Input correct credentials and login.")
    public void loginTest() {

        MainPage mainPage = new MainPage(driver);
        SecurePage securePage = openApp().goToLoginPage()
                .setUsername("tomsmith")
                .setPassword("SuperSecretPassword!")
                .clickLoginButton();
        String alertText = securePage.getAlertText();

        securePage.logout();

        Assert.assertTrue(alertText.contains("You logged into a secure area!"));
    }

}
