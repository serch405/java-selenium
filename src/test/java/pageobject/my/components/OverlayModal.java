package pageobject.my.components;

import helpers.WebDriverActions;
import org.openqa.selenium.By;
import pageobject.Base;
import pageobject.my.DashboardPage;


public class OverlayModal extends Base {
    public By overlayModal = By.cssSelector("div.dx-popup-wrapper div.dx-popup-normal");
    public By closeIcon = By.cssSelector("div.dx-popup-wrapper div.dx-popup-normal div.dx-toolbar i.dx-icon-close");
    public By createWorkspaceTitle = By.cssSelector("div.ws-create-form__title");
    public By addDeviceTitle = By.id("install-headline");

    public OverlayModal() {
        super(driver);
    }

    public Boolean waitUntilOverlayModalAppear() {
        return WebDriverActions.waitUntilElementIsVisible(driver, this.overlayModal);
    }

    public Boolean waitUntilOverlayModalDisappear() {
        return WebDriverActions.waitUntilElementIsInvisible(driver, this.overlayModal);
    }

    public Boolean isOverlayModalShown() {
        return WebDriverActions.waitUntilElementIsVisible(driver, this.overlayModal);
    }

    public Boolean isCloseIconShown() {
        return WebDriverActions.waitUntilElementIsVisible(driver, this.closeIcon);
    }

    public Boolean isCloseIconClickable() {
        return WebDriverActions.waitUntilElementIsClickable(driver, this.closeIcon);
    }

    public DashboardPage close() {
        driver.findElement(closeIcon).click();
        return new DashboardPage(driver);
    }

    public String getTitle() {

        if (WebDriverActions.waitUntilElementIsVisible(driver, this.createWorkspaceTitle)) {
            return driver.findElement(this.createWorkspaceTitle).getText();
        }

        if (WebDriverActions.waitUntilElementIsVisible(driver, this.addDeviceTitle)) {
            return driver.findElement(this.addDeviceTitle).getText();
        }
        return null;
    }

}
