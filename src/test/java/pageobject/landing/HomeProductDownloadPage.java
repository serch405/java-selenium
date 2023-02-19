package pageobject.landing;

import org.openqa.selenium.By;


public class HomeProductDownloadPage extends BasePageForLanding {
    private By altInstallationOptionsLink = By.xpath("//a[contains(text(), 'Web installer')]");

    public HomeProductDownloadPage() {
        super(driver);
    }

    public void download() {
        driver.findElement(altInstallationOptionsLink).click();
    }

}
