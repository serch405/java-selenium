package pageobject;

import org.openqa.selenium.WebDriver;

public class BasePage extends Base {

    protected BasePage(WebDriver driver) {
        super(driver);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}
