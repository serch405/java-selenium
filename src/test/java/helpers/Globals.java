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
    public static final String URL = projectEnvironmentProperties.getUrl();
    public static final String GMAIL_HOST = projectEnvironmentProperties.getGmailHost();
    public static final Integer GMAIL_PORT = projectEnvironmentProperties.getGmailPort();
    public static final UserModel USER = projectEnvironmentProperties.getUser();

}
