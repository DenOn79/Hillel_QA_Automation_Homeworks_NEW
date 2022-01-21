package homework15;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.MainPage;
import pageObjects.GeolocationPage;

public class GeolocationTest extends BaseTest {

    @Test(description = "Click button to get geolocations and output them.")
    public void getLocation() {

        MainPage mainPage = new MainPage(driver);
        GeolocationPage geolocationPage = openApp().goToGeolocationPage()
                .clickWhereButton()
                .getLatValue()
                .getLongValue();

    }
}
