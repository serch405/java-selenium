package tests.landing;

import helpers.DownloadFolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.landing.HomeProductPage;
import pages.landing.LandingPage;
import tests.BaseTestForNotAuthorized;


public class DownloadTest extends BaseTestForNotAuthorized {
    protected static String installerName;

    @Test
    public void homeProductWeb() throws InterruptedException {
        installerName = "EmsisoftAntiMalwareWebSetup.exe";
        DownloadFolder.removeFile(installerName);
        Assertions.assertTrue(!DownloadFolder.isFilePresented(installerName));
        LandingPage landingPage = new LandingPage(BaseTestForNotAuthorized.driver);
        HomeProductPage emsiHomePage = landingPage.openHomeProductPage();
        new LandingPage(BaseTestForNotAuthorized.driver).openHomeProductPage().openEamDownloadPage().download();
        DownloadFolder.waitUntilDownloadingIsFinished(5);
        Assertions.assertTrue(DownloadFolder.getFile(installerName) != null);
    }

    @Test
    public void businessProductWeb() throws InterruptedException {
        installerName = "EmsisoftAntiMalwareWebSetup.exe";
        DownloadFolder.removeFile(installerName);
        Assertions.assertTrue(!DownloadFolder.isFilePresented(installerName));
        new LandingPage(BaseTestForNotAuthorized.driver).openBusinessProductPage().openEbsDownloadPage().download();
        DownloadFolder.waitUntilDownloadingIsFinished(5);
        Assertions.assertTrue(DownloadFolder.getFile(installerName) != null);
    }

    @Test
    public void cmdProductExe() throws InterruptedException {
        installerName = "EmsisoftCommandlineScanner64.exe";
        DownloadFolder.removeFile(installerName);
        Assertions.assertTrue(!DownloadFolder.isFilePresented(installerName));
        new LandingPage(BaseTestForNotAuthorized.driver).openCmdProductPage().download();
        DownloadFolder.waitUntilDownloadingIsFinished(100);
        Assertions.assertTrue(DownloadFolder.getFile(installerName) != null);
    }

}
