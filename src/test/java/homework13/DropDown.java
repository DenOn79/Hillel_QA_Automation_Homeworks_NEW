package homework13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDown {
    @Test(description = "Open dropdown list and select item. Check that the needed item is selected.")
    public void openDropdown() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://crossbrowsertesting.github.io/hover-menu.html");

        WebElement dropdown = driver.findElement(By.xpath("//span[@class = 'caret']"));
        WebElement secondaryDropdown = driver.findElement(By.xpath("//span[@class = 'glyphicon glyphicon-triangle-right']"));
        WebElement secondaryAction = driver.findElement(By.xpath("//a[@onclick = 'handleSecondaryAction()']"));
        WebElement secondaryTitle = driver.findElement(By.xpath("//div[@class = 'jumbotron secondary-clicked']/h1"));

        Actions action = new Actions(driver);

        action.moveToElement(dropdown).perform();
        action.moveToElement(secondaryDropdown).perform();
        action.moveToElement(secondaryAction).click().perform();

        Thread.sleep(1000);

        Assert.assertEquals(secondaryTitle.getText(), "Secondary Page");

        driver.quit();
    }
}
