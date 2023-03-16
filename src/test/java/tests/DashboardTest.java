package tests;

import helpers.FileUtils;
import helpers.Globals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.DashboardPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.VerifyPage;
import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DashboardTest extends BaseTest {
    protected static String fileName;

    @Test
    public void downloadTxt() throws InterruptedException, MessagingException, IOException {
        fileName = "sample.txt";
        FileUtils.removeFile(fileName);
        Assertions.assertTrue(!FileUtils.isFilePresented(fileName));
        LoginPage loginPage = new HomePage(BaseTest.driver).openLoginPage();
        VerifyPage verifyPage = loginPage.login(Globals.USER.gmailEmail);
        emailOfUser.setAllMessagesAsRead();
        DashboardPage dashboardPage = verifyPage.login(Globals.USER.password, emailOfUser.getCode());
        dashboardPage.downloadTxt();
        FileUtils.waitUntilDownloadingIsFinished(5);
        Assertions.assertTrue(FileUtils.getFile(fileName) != null);
    }

    @Test
    public void downloadCsv() throws InterruptedException, MessagingException, IOException {
        fileName = "sample.csv";
        FileUtils.removeFile(fileName);
        Assertions.assertTrue(!FileUtils.isFilePresented(fileName));
        LoginPage loginPage = new HomePage(BaseTest.driver).openLoginPage();
        VerifyPage verifyPage = loginPage.login(Globals.USER.gmailEmail);
        emailOfUser.setAllMessagesAsRead();
        DashboardPage dashboardPage = verifyPage.login(Globals.USER.password, emailOfUser.getCode());
        dashboardPage.downloadCsv();
        FileUtils.waitUntilDownloadingIsFinished(5);
        Assertions.assertTrue(FileUtils.getFile(fileName) != null);
    }

    @Test
    public void getDate() throws InterruptedException, MessagingException, IOException {
        LoginPage loginPage = new HomePage(BaseTest.driver).openLoginPage();
        VerifyPage verifyPage = loginPage.login(Globals.USER.gmailEmail);
        emailOfUser.setAllMessagesAsRead();
        DashboardPage dashboardPage = verifyPage.login(Globals.USER.password, emailOfUser.getCode());

        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        String date = dateObj.format(formatter);

        Assertions.assertEquals(date, dashboardPage.getTimeFromIframe(), "date should be: " + date);
    }

    @Test
    public void logout() throws InterruptedException, MessagingException, IOException {
        LoginPage loginPage = new HomePage(BaseTest.driver).openLoginPage();
        VerifyPage verifyPage = loginPage.login(Globals.USER.gmailEmail);
        emailOfUser.setAllMessagesAsRead();
        DashboardPage dashboardPage = verifyPage.login(Globals.USER.password, emailOfUser.getCode());
        HomePage homePage = dashboardPage.logout();
        Assertions.assertEquals("Home page", homePage.getPageTitle());
    }

}
