package tests.landing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.landing.BusinessProductPage;
import pages.landing.LandingPage;
import tests.BaseTestForNotAuthorized;


public class BusinessProductTest extends BaseTestForNotAuthorized {

    @Test
    public void smoke() {
        BusinessProductPage businessProductPage = new LandingPage(BaseTestForNotAuthorized.driver).
                openBusinessProductPage();
        Assertions.assertEquals("Emsisoft Business Security", businessProductPage.getProductName());
        Assertions.assertEquals("2023.1.0.11768", businessProductPage.getProductVersion());
        Assertions.assertEquals("01/03/2023", businessProductPage.getProductReleasedDate());
        Assertions.assertTrue(businessProductPage.verifyIfNavigationMenuWorks());
    }

}
