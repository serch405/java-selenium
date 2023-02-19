package tests.my;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.my.LoginPage;
import tests.BaseTest;
import tests.BaseTestForAuthorized;


public class LogoutTest extends BaseTestForAuthorized {

    @Test
    public void logout() {
        BaseTest.logger.debug("logout");
        dashboardPage.userMenu.openUserDropdownMenu();
        Assertions.assertTrue(dashboardPage.userMenu.waitUntilDropdownMenuIsShown());
        LoginPage loginPage = dashboardPage.userMenu.logout();
        Assertions.assertTrue(loginPage.isLoginButtonShown());
    }

}
