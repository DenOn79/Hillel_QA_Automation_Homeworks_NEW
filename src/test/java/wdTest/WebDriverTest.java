package wdTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebDriverTest {
    @Test
    public void wdTest() {
        System.setProperty("webdriver.chrome.driver" , "/home/den/IdeaProjects/Hillel_QA_Automation_Homeworks_NEW/Hillel_QA_Automation_Homeworks_NEW/src/test/resources/bin/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        driver.quit();
    }
}
