package pageobject;

import org.openqa.selenium.WebDriver;

public class Base {
     public static WebDriver driver;

    protected Base(WebDriver driver) {
        this.driver = driver;
    }

}
