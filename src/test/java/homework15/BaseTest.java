package homework15;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.internal.annotations.ITest;
import pageObjects.MainPage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();


            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory", new File("target/download").getAbsolutePath());
            options.setExperimentalOption("prefs", prefs);

            this.driver = new ChromeDriver(options);
        }

        if (browser.equals("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("browserVersion", "98.0");
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", false
            ));
            try {
                driver = new RemoteWebDriver(
                        URI.create("http://localhost:4444/wd/hub").toURL(),
                        capabilities
                );

            } catch (MalformedURLException m) {
              m.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown() {
        if (this.driver !=null) {
            this.driver.quit();
        }
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        if (!result.isSuccess()) {
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                saveScreenshot(Files.readAllBytes(screenshot.toPath()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public MainPage openApp() {
        driver.get("https://the-internet.herokuapp.com/");
        return new MainPage(driver);
    }

    @Attachment(value = "Page screenshot", type = "img/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

}
