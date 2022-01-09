package homework13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Username {
    @Test(description = "Output username of each user.")
    public void printUsername() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);

        for(int i = 1; i <=3; i++) {

            WebElement avatar = driver.findElement(By.xpath("//div[@class = 'figure']["+i+"]"));
            action.moveToElement(avatar).perform();
            Thread.sleep(1000);
            String username = driver.findElement(By.xpath("//a[@href = '/users/"+i+"']/../h5")).getText();
            System.out.println(username);

        }

        driver.quit();
    }
}
