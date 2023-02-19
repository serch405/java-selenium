package tests.my;

import helpers.Globals;
import org.junit.jupiter.api.*;
import pageobject.landing.LandingPage;
import pageobject.my.DashboardPage;
import pageobject.my.LoginPage;
import tests.BaseTestForNotAuthorized;
import javax.mail.MessagingException;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest extends BaseTestForNotAuthorized {

    @Test
    public void loginFailedCredentials() {
        LoginPage loginPage = new LandingPage(BaseTestForNotAuthorized.driver).openLoginPage();
        loginPage.loginFailedCredentials(Globals.USER_WITH_NOT_EMPTY_WS);

        Assertions.assertTrue(loginPage.waitUntilToastMessageAppear());
        Assertions.assertTrue(loginPage.getToastMessageText().
                        contains("The email address or password you entered is not valid. Please try again."),
                loginPage.getToastMessageText());
    }

    @Test
    public void loginFailedCode() {
        LoginPage loginPage = new LandingPage(BaseTestForNotAuthorized.driver).openLoginPage();
        loginPage.loginFailedCode(Globals.USER_WITH_NOT_EMPTY_WS);

        Assertions.assertTrue(loginPage.waitUntilToastMessageAppear());
        Assertions.assertTrue(loginPage.getToastMessageText().contains("Invalid security code."),
                loginPage.getToastMessageText());
    }

    @Test
    @Order(1)
    public void loginByUserWithoutWS() throws MessagingException, InterruptedException {
        LoginPage loginPage = new LandingPage(BaseTestForNotAuthorized.driver).openLoginPage();
        DashboardPage dashboardPage = loginPage.login(Globals.USER_WITHOUT_WS,
                BaseTestForNotAuthorized.emailOfUserWithoutWS);

        Assertions.assertTrue(dashboardPage.overlayModal.waitUntilOverlayModalAppear());
        Assertions.assertEquals("Name your workspace", dashboardPage.overlayModal.getTitle());
        Assertions.assertFalse(dashboardPage.overlayModal.isCloseIconShown());
    }

    @Test
    @Order(2)
    public void loginByUserWithEmptyWS() throws MessagingException, InterruptedException {
        LoginPage loginPage = new LandingPage(BaseTestForNotAuthorized.driver).openLoginPage();
        DashboardPage dashboardPage = loginPage.login(Globals.USER_WITH_EMPTY_WS,
                BaseTestForNotAuthorized.emailOfUserWithEmptyWS);

        Assertions.assertTrue(dashboardPage.overlayModal.waitUntilOverlayModalAppear());
        Assertions.assertEquals("Download & install protection", dashboardPage.overlayModal.getTitle());
        Assertions.assertTrue(dashboardPage.overlayModal.isCloseIconClickable());
        dashboardPage.overlayModal.close();

        Assertions.assertTrue(dashboardPage.overlayModal.waitUntilOverlayModalDisappear());
        Assertions.assertTrue(
                dashboardPage.userMenu.getUsername().toLowerCase().contains(Globals.USER_WITH_EMPTY_WS.myUsername),
                dashboardPage.userMenu.getUsername().toLowerCase());
        Assertions.assertTrue(
                dashboardPage.getWorkspaceName().toLowerCase().contains(Globals.USER_WITH_EMPTY_WS.myWorkspace),
                dashboardPage.getWorkspaceName().toLowerCase());
        Assertions.assertTrue(dashboardPage.isAddDeviceBtnShown());
    }

    @Test
    @Order(3)
    public void loginByUserWithNotEmptyWS() throws MessagingException, InterruptedException {
        LoginPage loginPage = new LandingPage(BaseTestForNotAuthorized.driver).openLoginPage();
        DashboardPage dashboardPage = loginPage.login(
                Globals.USER_WITH_NOT_EMPTY_WS,
                BaseTestForNotAuthorized.emailOfUserWithNotEmptyWS);

        Assertions.assertFalse(dashboardPage.overlayModal.isOverlayModalShown());
        Assertions.assertTrue(dashboardPage.userMenu.getUsername().toLowerCase().contains(Globals.USER_WITH_NOT_EMPTY_WS.myUsername),
                dashboardPage.userMenu.getUsername().toLowerCase());
        Assertions.assertTrue(dashboardPage.getWorkspaceName().toLowerCase().contains(Globals.USER_WITH_NOT_EMPTY_WS.myWorkspace),
                dashboardPage.userMenu.getUsername().toLowerCase());
        Assertions.assertTrue(dashboardPage.isAddDeviceBtnShown());
    }

}
