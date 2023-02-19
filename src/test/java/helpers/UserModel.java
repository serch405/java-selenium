package helpers;

public class UserModel {
    public String gmailEmail;
    public String gmailAppPassword;
    public String myPassword;
    public String myUsername;
    public String myWorkspace;

    public UserModel(String gmailEmail, String gmailAppPassword, String myPassword, String myUsername, String myWorkspace) {
        this.gmailEmail = gmailEmail;
        this.gmailAppPassword = gmailAppPassword;
        this.myPassword = myPassword;
        this.myUsername=myUsername;
        this.myWorkspace=myWorkspace;
    }

}
