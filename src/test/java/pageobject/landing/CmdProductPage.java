package pageobject.landing;

import org.openqa.selenium.By;


public class CmdProductPage extends BasePageForLanding {
    private By xDayFreeTrialLink = By.xpath("//a[contains(text(), '30-Day Free Trial')]");
    private By productName = By.cssSelector("h1.Hero__heading");
    private By productInfo = By.cssSelector("p.Hero__version");

    public CmdProductPage() {
        super(driver);
    }

    public void download() {
        driver.findElement(xDayFreeTrialLink).click();
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public String getProductVersion() {
        return driver.findElement(productInfo).getText().trim().toLowerCase().split("\\s+")[1];
    }

    public String getProductReleasedDate() {
        return driver.findElement(productInfo).getText().trim().toLowerCase().split("\\s+")[4];
    }

}
