package pageobject;

import helpers.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DashboardPage extends BasePage {
    By txtLink = By.xpath("//a[contains(text(), 'sample.txt')]");
    By csvLink = By.xpath("//a[contains(text(), 'sample.csv')]");
    By iFrame = By.tagName("iframe");
    By logoutBtn = By.id("logout");

    public DashboardPage(WebDriver driver) {
        super(driver);
        WebDriverActions.waitUntilElementIsVisible(driver, this.logoutBtn);
    }

    public void downloadTxt() {
        driver.findElement(txtLink).click();
    }

    public void downloadCsv() {
        driver.findElement(csvLink).click();
    }

    public String getTimeFromIframe() {
        driver.switchTo().frame(driver.findElement(iFrame));
        return driver.findElement(By.tagName("p")).getText().split(":")[1].trim();
    }

    public HomePage logout() {
        driver.findElement(logoutBtn).click();
        return new HomePage(driver);
    }

}
