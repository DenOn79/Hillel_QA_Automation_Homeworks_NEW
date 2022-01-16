package homework13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop {

    @Test(description = "Drag and drop element. Check the title in drop target.")
    public void dragAndDrop() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");

        WebElement dragMe = driver.findElement(By.xpath("//div[@id = 'draggable']"));
        WebElement dropTarget = driver.findElement(By.xpath("//div[@id = 'droppable']"));

        Actions action = new Actions(driver);

        action.dragAndDrop(dragMe, dropTarget).perform();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'ui-widget-header ui-droppable ui-state-highlight']/p")));

        WebElement droppedTitle = driver.findElement(By.xpath("//div[@class = 'ui-widget-header ui-droppable ui-state-highlight']/p"));

        Assert.assertEquals(droppedTitle.getText(), "Dropped!");

    }
}
