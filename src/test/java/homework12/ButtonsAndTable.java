package homework12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ButtonsAndTable {
    @Test (description = "Click buttons and output from the table")
    public void locatorTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/challenging_dom");

        driver.findElement(By.xpath("//a[@class = 'button']")).click();
        driver.findElement(By.xpath("//a[@class = 'button alert']")).click();
        driver.findElement(By.xpath("//a[@class = 'button success']")).click();


        for (int i = 1; i <= 10; i++) {
            String element = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[4]")).getText();
            System.out.println(element);
        }

        driver.quit();
    }
}
