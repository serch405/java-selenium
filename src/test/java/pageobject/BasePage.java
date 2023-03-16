package pageobject;

import org.openqa.selenium.WebDriver;


public class BasePage {
    public static WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}
