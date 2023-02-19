package pages.my;

import helpers.SeleniumAddition;
import org.openqa.selenium.WebDriver;
import pages.my.components.Breadcrumb;
import pages.my.components.OverlayModal;
import pages.my.components.Sidebar;
import pages.my.components.UserMenu;


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
        SeleniumAddition.waitUntilElementIsVisible(driver, sidebar.workspacesItem);
        SeleniumAddition.waitUntilElementIsVisible(driver, userMenu.username);
    }

}
