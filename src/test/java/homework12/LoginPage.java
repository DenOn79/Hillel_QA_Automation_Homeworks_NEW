package homework12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage {
    @Test(description = "Input correct credentials and login.")
    public void loginCorrect() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameInput = driver.findElement(By.xpath("//input[@name = 'username']"));
        usernameInput.sendKeys("tomsmith");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name = 'password']"));
        passwordInput.sendKeys("SuperSecretPassword!");
        WebElement button = driver.findElement(By.xpath("//button[@class = 'radius']"));
        button.click();
        WebElement message = driver.findElement(By.xpath("//h4[@class = 'subheader']"));

        Assert.assertEquals(message.getText(), "Welcome to the Secure Area. When you are done click logout below.");

        driver.quit();
    }

    @Test(description = "Input incorrect credentials and check that login failed")
    public void loginIncorrect() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameInput = driver.findElement(By.xpath("//input[@name = 'username']"));
        usernameInput.clear();
        usernameInput.sendKeys("jojojo");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name = 'password']"));
        passwordInput.clear();
        passwordInput.sendKeys("12345");
        WebElement button = driver.findElement(By.xpath("//button[@class = 'radius']"));
        button.click();
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class = 'flash error']"));

        String errorMessageStr = errorMessage.getText();

        Assert.assertEquals(errorMessageStr.replace("×", "").trim(), "Your username is invalid!");

        driver.quit();
    }
}
