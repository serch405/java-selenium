package helpers;

import enums.Browser;
import enums.Environment;
import java.io.File;

public class Globals {
    public static final File DOWNLOAD_FOLDER = new File(System.getProperty("user.home") + "/Downloads");
    public static final Browser BROWSER = ProjectSystemProperties.getBrowser();
    public static final Environment ENVIRONMENT = ProjectSystemProperties.getEnvironment();
    public static final long WAIT = ProjectSystemProperties.getWait();
    public static ProjectEnvironmentProperties projectEnvironmentProperties = new ProjectEnvironmentProperties();
    public static final String MY_URL = projectEnvironmentProperties.getMyUrl();
    public static final String GMAIL_HOST = projectEnvironmentProperties.getGmailHost();
    public static final Integer GMAIL_PORT = projectEnvironmentProperties.getGmailPort();
    public static final UserModel USER_WITH_NOT_EMPTY_WS = projectEnvironmentProperties.getUserWithNotEmptyWS();
    public static final UserModel USER_WITHOUT_WS = projectEnvironmentProperties.getUserWithoutWS();;
    public static final UserModel USER_WITH_EMPTY_WS = projectEnvironmentProperties.getUserWithEmptyWS();

}
