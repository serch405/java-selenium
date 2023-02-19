package pageobject.my.components;

import helpers.WebDriverActions;
import org.openqa.selenium.By;
import pageobject.Base;
import pageobject.my.LoginPage;


public class UserMenu extends Base {
    public By username = By.cssSelector("a#user-name");
    public By userDropdownMenu = By.cssSelector("ul.user-dropdown-menu");
    public By userDropdownMenu_logout = By.cssSelector("ul.user-dropdown-menu #user-logout");

    public UserMenu() {
        super(driver);
    }

    public String getUsername() {
        return driver.findElement(username).getText();
    }

    public void openUserDropdownMenu() {
        driver.findElement(username).click();
    }

    public Boolean waitUntilDropdownMenuIsShown() {
        return WebDriverActions.waitUntilElementIsVisible(driver, this.userDropdownMenu);
    }

    public LoginPage logout() {
        driver.findElement(userDropdownMenu_logout).click();
        return new LoginPage();
    }

}
