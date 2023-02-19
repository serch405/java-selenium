package pages.my;

import helpers.SeleniumAddition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BasePageForMy extends BasePage {
    private By toastMessage = By.className("dx-overlay-content");

    public BasePageForMy(WebDriver driver) {
        super(driver);
    }

    public Boolean waitUntilToastMessageAppear() {
        return SeleniumAddition.waitUntilElementIsVisible(driver, toastMessage);
    }

    public String getToastMessageText() {
        return driver.findElement(toastMessage).getText();
    }

}
