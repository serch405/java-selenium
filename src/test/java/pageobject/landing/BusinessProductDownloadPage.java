package pageobject.landing;

import org.openqa.selenium.By;

public class BusinessProductDownloadPage extends BasePageForLanding {
    private By altInstallationOptionsLink = By.xpath("//a[contains(text(), 'Web installer')]");

    public BusinessProductDownloadPage() {
        super(driver);
    }

    public void download() {
        driver.findElement(altInstallationOptionsLink).click();
    }

}
