package helpers;

import enums.Browser;
import enums.Environment;


public class ProjectSystemProperties {

    public static Browser getBrowser() {
        String browser = System.getProperty("browser");

        if (browser == null || browser.equalsIgnoreCase("chrome")) return Browser.CHROME;
        else if (browser.equalsIgnoreCase("chromeHeadless")) return Browser.CHROME_HEADLESS;
        else throw new RuntimeException("Can't parse browser value: " + browser);
    }

    public static Environment getEnvironment() {
        String environment = System.getProperty("environment");

        if (environment == null || environment.equalsIgnoreCase("local")) return Environment.LOCAL;
        else if (environment.equalsIgnoreCase("prod")) return Environment.PROD;
        else throw new RuntimeException("Can't parse browser value: " + environment);
    }

    public static long getWait() {
        String wait = System.getProperty("wait");
        if (wait != null) return Long.parseLong(wait);
        return 10;
    }

}
