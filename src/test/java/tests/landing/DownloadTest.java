package tests.landing;

import helpers.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.landing.HomeProductPage;
import pageobject.landing.LandingPage;
import tests.BaseTestForNotAuthorized;


public class DownloadTest extends BaseTestForNotAuthorized {
    protected static String installerName;

    @Test
    public void homeProductWeb() throws InterruptedException {
        installerName = "EmsisoftAntiMalwareWebSetup.exe";
        FileUtils.removeFile(installerName);
        Assertions.assertTrue(!FileUtils.isFilePresented(installerName));
        LandingPage landingPage = new LandingPage(BaseTestForNotAuthorized.driver);
        HomeProductPage emsiHomePage = landingPage.openHomeProductPage();
        new LandingPage(BaseTestForNotAuthorized.driver).openHomeProductPage().openEamDownloadPage().download();
        FileUtils.waitUntilDownloadingIsFinished(5);
        Assertions.assertTrue(FileUtils.getFile(installerName) != null);
    }

    @Test
    public void businessProductWeb() throws InterruptedException {
        installerName = "EmsisoftAntiMalwareWebSetup.exe";
        FileUtils.removeFile(installerName);
        Assertions.assertTrue(!FileUtils.isFilePresented(installerName));
        new LandingPage(BaseTestForNotAuthorized.driver).openBusinessProductPage().openEbsDownloadPage().download();
        FileUtils.waitUntilDownloadingIsFinished(5);
        Assertions.assertTrue(FileUtils.getFile(installerName) != null);
    }

    @Test
    public void cmdProductExe() throws InterruptedException {
        installerName = "EmsisoftCommandlineScanner64.exe";
        FileUtils.removeFile(installerName);
        Assertions.assertTrue(!FileUtils.isFilePresented(installerName));
        new LandingPage(BaseTestForNotAuthorized.driver).openCmdProductPage().download();
        FileUtils.waitUntilDownloadingIsFinished(100);
        Assertions.assertTrue(FileUtils.getFile(installerName) != null);
    }

}
