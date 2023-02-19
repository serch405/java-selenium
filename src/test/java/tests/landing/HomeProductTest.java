package tests.landing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.landing.HomeProductPage;
import pageobject.landing.LandingPage;
import tests.BaseTestForNotAuthorized;


public class HomeProductTest extends BaseTestForNotAuthorized {

    @Test
    public void smoke() {
        HomeProductPage homeProductPage = new LandingPage(BaseTestForNotAuthorized.driver).openHomeProductPage();
        Assertions.assertEquals("Emsisoft Anti-Malware Home", homeProductPage.getProductName());
        Assertions.assertEquals("2023.1.0.11768", homeProductPage.getProductVersion());
        Assertions.assertEquals("01/03/2023", homeProductPage.getProductReleasedDate());
        Assertions.assertTrue(homeProductPage.verifyIfNavigationMenuWorks());
    }

}
