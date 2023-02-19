package pageobject.my;

import helpers.WebDriverActions;
import org.openqa.selenium.WebDriver;
import pageobject.my.components.Breadcrumb;
import pageobject.my.components.OverlayModal;
import pageobject.my.components.Sidebar;
import pageobject.my.components.UserMenu;


public class BasePageForMyAuthorized extends BasePageForMy {
    public OverlayModal overlayModal;
    public Sidebar sidebar;
    public UserMenu userMenu;
    public Breadcrumb breadcrumb;

    public BasePageForMyAuthorized(WebDriver driver) {
        super(driver);
        this.overlayModal = new OverlayModal();
        this.sidebar = new Sidebar();
        this.userMenu = new UserMenu();
        this.breadcrumb = new Breadcrumb();
        this.waitUntilPageIsLoaded();
    }

    protected void waitUntilPageIsLoaded() {
        WebDriverActions.waitUntilElementIsVisible(driver, sidebar.workspacesItem);
        WebDriverActions.waitUntilElementIsVisible(driver, userMenu.username);
    }

}
