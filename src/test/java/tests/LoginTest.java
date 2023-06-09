package tests;

import helpers.Globals;
import org.junit.jupiter.api.*;
import pageobject.DashboardPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.VerifyPage;
import javax.mail.MessagingException;
import java.io.IOException;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest extends BaseTest {

    @Test
    public void loginWithWrongEmail() {
        LoginPage loginPage = new HomePage(BaseTest.driver).openLoginPage();
        loginPage.loginFailed("xa@xe.xi");
        Assertions.assertEquals("User with such email doesn't exist", loginPage.getMessageText().trim());
    }


    @Order(2)
    @Test
    public void loginWithWrongPassword() throws MessagingException, IOException, InterruptedException {
        LoginPage loginPage = new HomePage(BaseTest.driver).openLoginPage();
        VerifyPage verifyPage = loginPage.login(Globals.USER.gmailEmail);
        BaseTest.emailOfUser.setAllMessagesAsRead();
        verifyPage.loginFailed("Password", BaseTest.emailOfUser.getCode());
        Assertions.assertEquals("Invalid password or code", verifyPage.getMessageText().trim());
    }

    @Test
    public void loginWithWrongCode() throws MessagingException, IOException, InterruptedException {
        LoginPage loginPage = new HomePage(BaseTest.driver).openLoginPage();
        VerifyPage verifyPage = loginPage.login(Globals.USER.gmailEmail);
        verifyPage.loginFailed(Globals.USER.password, "Code");
        Assertions.assertEquals("Invalid password or code", verifyPage.getMessageText().trim());
    }

    @Order(1)
    @Test
    public void login() throws MessagingException, InterruptedException, IOException {
        LoginPage loginPage = new HomePage(BaseTest.driver).openLoginPage();
        VerifyPage verifyPage = loginPage.login(Globals.USER.gmailEmail);
        BaseTest.emailOfUser.setAllMessagesAsRead();
        DashboardPage dashboardPage = verifyPage.login(Globals.USER.password, BaseTest.emailOfUser.getCode());
        Assertions.assertTrue(dashboardPage.getPageTitle().contains("Dashboard"), dashboardPage.getPageTitle());
    }

}
