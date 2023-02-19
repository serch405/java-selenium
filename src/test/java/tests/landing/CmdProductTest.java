package tests.landing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.landing.CmdProductPage;
import pageobject.landing.LandingPage;
import tests.BaseTestForNotAuthorized;


public class CmdProductTest extends BaseTestForNotAuthorized {

    @Test
    public void smoke() {
        CmdProductPage cmdProductPage = new LandingPage(BaseTestForNotAuthorized.driver).openCmdProductPage();
        Assertions.assertEquals("Emsisoft Commandline Scanner", cmdProductPage.getProductName());
        Assertions.assertEquals("2022.12.0.11730", cmdProductPage.getProductVersion());
        Assertions.assertEquals("12/01/2022", cmdProductPage.getProductReleasedDate());
    }

}
