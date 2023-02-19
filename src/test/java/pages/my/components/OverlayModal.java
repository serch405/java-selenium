package pages.my.components;

import helpers.SeleniumAddition;
import org.openqa.selenium.By;
import pages.Base;
import pages.my.DashboardPage;


public class OverlayModal extends Base {
    public By overlayModal = By.cssSelector("div.dx-popup-wrapper div.dx-popup-normal");
    public By closeIcon = By.cssSelector("div.dx-popup-wrapper div.dx-popup-normal div.dx-toolbar i.dx-icon-close");
    public By createWorkspaceTitle = By.cssSelector("div.ws-create-form__title");
    public By addDeviceTitle = By.id("install-headline");

    public OverlayModal() {
        super(driver);
    }

    public Boolean waitUntilOverlayModalAppear() {
        return SeleniumAddition.waitUntilElementIsVisible(driver, this.overlayModal);
    }

    public Boolean waitUntilOverlayModalDisappear() {
        return SeleniumAddition.waitUntilElementIsInvisible(driver, this.overlayModal);
    }

    public Boolean isOverlayModalShown() {
        return SeleniumAddition.waitUntilElementIsVisible(driver, this.overlayModal);
    }

    public Boolean isCloseIconShown() {
        return SeleniumAddition.waitUntilElementIsVisible(driver, this.closeIcon);
    }

    public Boolean isCloseIconClickable() {
        return SeleniumAddition.waitUntilElementIsClickable(driver, this.closeIcon);
    }

    public DashboardPage close() {
        driver.findElement(closeIcon).click();
        return new DashboardPage(driver);
    }

    public String getTitle() {

        if (SeleniumAddition.waitUntilElementIsVisible(driver, this.createWorkspaceTitle)) {
            return driver.findElement(this.createWorkspaceTitle).getText();
        }

        if (SeleniumAddition.waitUntilElementIsVisible(driver, this.addDeviceTitle)) {
            return driver.findElement(this.addDeviceTitle).getText();
        }
        return null;
    }

}
