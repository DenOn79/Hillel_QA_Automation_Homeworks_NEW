package homework12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Geolocation {
    @Test(description = "Click button to get geolocations and output them.")
    public void getLocation() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/geolocation");

        driver.findElement(By.xpath("//button[@onclick = 'getLocation()']")).click();
        Thread.sleep(1000);

        String latitude = driver.findElement(By.xpath("//div[@id = 'lat-value']")).getText();
        String longitude = driver.findElement(By.xpath("//div[@id = 'long-value']")).getText();

        System.out.println("Latitude: " + latitude);
        System.out.println("Longitude: " + longitude);

        driver.quit();
    }
}
