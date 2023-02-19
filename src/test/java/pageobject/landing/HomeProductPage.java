package pageobject.landing;

import helpers.WebDriverActions;
import org.openqa.selenium.By;


public class HomeProductPage extends BasePageForLanding {
    private By altLink = By.xpath("//a[contains(text(), 'Alternative installation options')]");
    private By productName = By.cssSelector("h1.Hero__heading");
    private By productInfo = By.cssSelector("p.Hero__version");
//    navigation menu items
    private By scanAndCleanNavigationMenuItem = By.cssSelector(".section-menu li:nth-child(1)");
    private By layeredProtectionNavigationMenuItem = By.cssSelector(".section-menu li:nth-child(2)");
    private By antiPhishingNavigationMenuItem = By.cssSelector(".section-menu li:nth-child(3)");
    private By antiRansomwareNavigationMenuItem = By.cssSelector(".section-menu li:nth-child(4)");
    private By emergencyKitNavigationMenuItem = By.cssSelector(".section-menu li:nth-child(5)");
    private By managementConsoleNavigationMenuItem = By.cssSelector(".section-menu li:nth-child(6)");
//    headers
    private By scanAndCleanHeader = By.cssSelector(".scan-and-clean h2");
    private By layeredProtectionHeader = By.cssSelector(".layered-protection h2");
    private By antiPhishingHeader = By.cssSelector(".anti-phishing h2");
    private By antiRansomwareHeader = By.cssSelector(".anti-ransomware h2");
    private By emergencyKitHeader = By.cssSelector(".emergency-kit h2");
    private By managementConsoleHeader = By.cssSelector(".cloud-management h2");

    public HomeProductPage() {
        super(driver);
    }

    public HomeProductDownloadPage openEamDownloadPage() {
        driver.findElement(altLink).click();
        return new HomeProductDownloadPage();
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

    public void clickMenuItem(By by) {
        driver.findElement(by).click();
    }

    public Boolean isMenuItemShownAsActive(By by) {
        return WebDriverActions.waitUntilElementAttributeContains(driver, by, "class", "active");
    }

    public Boolean isHeaderDisplayed(By by) {
        return WebDriverActions.waitUntilElementIsVisible(driver, by);
    }

    public Boolean verifyIfNavigationMenuWorks() {
        this.clickMenuItem(scanAndCleanNavigationMenuItem);

        if (!this.isMenuItemShownAsActive(scanAndCleanNavigationMenuItem)) {
            return false;
        }
        if (!this.isHeaderDisplayed(scanAndCleanHeader)) {
            return false;
        }
        this.clickMenuItem(layeredProtectionNavigationMenuItem);

        if (!this.isMenuItemShownAsActive(layeredProtectionNavigationMenuItem)) {
            return false;
        }
        if (!this.isHeaderDisplayed(layeredProtectionHeader)) {
            return false;
        }
        this.clickMenuItem(antiPhishingNavigationMenuItem);

        if (!this.isMenuItemShownAsActive(antiPhishingNavigationMenuItem)) {
            return false;
        }
        if (!this.isHeaderDisplayed(antiPhishingHeader)) {
            return false;
        }
        this.clickMenuItem(antiRansomwareNavigationMenuItem);

        if (!this.isMenuItemShownAsActive(antiRansomwareNavigationMenuItem)) {
            return false;
        }
        if (!this.isHeaderDisplayed(antiRansomwareHeader)) {
            return false;
        }
        this.clickMenuItem(emergencyKitNavigationMenuItem);

        if (!this.isMenuItemShownAsActive(emergencyKitNavigationMenuItem)) {
            return false;
        }
        if (!this.isHeaderDisplayed(emergencyKitHeader)) {
            return false;
        }
        this.clickMenuItem(managementConsoleNavigationMenuItem);

        if (!this.isMenuItemShownAsActive(managementConsoleNavigationMenuItem)) {
            return false;
        }
        if (!this.isHeaderDisplayed(managementConsoleHeader)) {
            return false;
        }
        return true;
    }

}
