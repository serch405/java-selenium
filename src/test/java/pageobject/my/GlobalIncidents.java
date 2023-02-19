package pageobject.my;

import org.openqa.selenium.WebDriver;

public class GlobalIncidents extends BasePageForMyAuthorized {

    public GlobalIncidents(WebDriver driver) {
        super(driver);
    }

    public String getBreadcrumbItemByIndex(int index) {
        return this.breadcrumb.getItemTextByIndex(index);
    }

    public Boolean isBreadcrumbItemActive(String itemTex) throws Exception {
        return this.breadcrumb.isItemActive(itemTex);
    }

}
