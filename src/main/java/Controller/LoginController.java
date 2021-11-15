package Controller;
import UseCase.UserManager;
import java.io.*;
import java.util.Objects;

public class LoginController {

    private UserManager uman = new UserManager();
    private static String currentUser = "";

    public LoginController(){
    }

    /**
     * Construct LoginController with exists UserManager.
     * @param userManager UserManager class which contains registered User id & password.
     *
     */
    public LoginController(UserManager userManager){this.uman = userManager;}

    /**
     * Check if username and password matches each other.
     * @param username The input username.
     * @param pw The input password.
     * @return Return true if the username matches password, false if it doesn't.
     */
    public boolean userLogin(String username, String pw){
        // login
        if(uman.lookupUser(username) == null){
            return false;
        }
        else if (uman.pwVerify(username, pw)){
            currentUser = username;
            uman.RecordUser(username);
            return true;
        }
        return false;
    }


    /**
     * Register a new user with valid username and password.
     * @param username New valid username.
     * @param pw New valid password.
     * @return Return True if register is successful.
     */
    public boolean userRegister(String username, String pw) throws IOException {
        // lookup username; if already exists, return false.
        // else call Usermanager.register
        if(uman.lookupUser(username) == null){
            uman.userRegister(username,pw);
            FileOutputStream fos = new FileOutputStream("user.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.uman);
            return true;
        }
        return false;
    }

    /**
     * Logout the current user.
     */
    public boolean userLogout(){
        // set current user as ""
        if(Objects.equals(currentUser, "")){
            return false;
        }
        currentUser = "";
        uman.RecordUser("");
        return true;
    }

    public UserManager getUman(){
        return uman;
    }

    public String getCurrentUser(){
        return currentUser;
    }
}
