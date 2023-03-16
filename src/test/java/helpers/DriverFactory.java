package helpers;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import enums.Browser;


public class DriverFactory {
    public static WebDriver createDriver(Browser browser) {
        Map<String, Object> chromePrefs = new HashMap<String, Object>();
        ChromeOptions chromeOptions = new ChromeOptions();

        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                chromePrefs.put("download.default_directory", Globals.DOWNLOAD_FOLDER.getPath());
                chromePrefs.put("safebrowsing.enabled", true);
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                chromeOptions.addArguments("--window-size=1920,1080");
                chromeOptions.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(chromeOptions);
            case CHROME_HEADLESS:
                WebDriverManager.chromedriver().setup();
                chromePrefs.put("download.default_directory", Globals.DOWNLOAD_FOLDER.getPath());
                chromePrefs.put("safebrowsing.enabled", true);
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--window-size=1920,1080");
                chromeOptions.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(chromeOptions);
        }
        return null;
    }

}
