package pageobject.my.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.Base;
import java.util.List;


public class Breadcrumb extends Base {
    public By breadcrumbItems = By.cssSelector("ul.breadcrumb li");

    public Breadcrumb() {
        super(driver);
    }

    private List<WebElement> getItems() {
        return driver.findElements(breadcrumbItems);
    }

    private WebElement getItemByIndex(int index) {
        return this.getItems().get(index);
    }

    public String getItemTextByIndex(int index) {
        return this.getItemByIndex(index).getText();
    }

    public boolean isItemActive(String itemText) throws Exception {

        for (WebElement e : this.getItems()) {
            if (e.getText().contains(itemText)) {
                return e.getAttribute("class").contains("active");
            }
        }
        throw new Exception("There is no item with such name in breadcrumb: " + itemText);
    }

}
