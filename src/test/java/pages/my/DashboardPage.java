package pages.my;

import helpers.SeleniumAddition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DashboardPage extends BasePageForMyAuthorized {
    By workspaceName = By.cssSelector("ul.breadcrumb li:nth-child(1)");
    By addDeviceBtn = By.cssSelector("div.add-device #download-install-protection");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String getWorkspaceName() {
        return driver.findElement(workspaceName).getText();
    }

    public Boolean isAddDeviceBtnShown() {
        return SeleniumAddition.waitUntilElementIsVisible(driver, addDeviceBtn);
    }

}
