package helpers;

public class UserModel {
    public String gmailEmail;
    public String gmailAppPassword;
    public String password;
    public String username;

    public UserModel(String gmailEmail, String gmailAppPassword, String password, String username) {
        this.gmailEmail = gmailEmail;
        this.gmailAppPassword = gmailAppPassword;
        this.password = password;
        this.username = username;
    }

}
