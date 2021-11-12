package Controller;
import UseCase.UserManager;
public class LoginController {
    private UserManager uman = new UserManager();
    private static String currentUser = "";


    public LoginController(){
    }

    public boolean userLogin(String username, String pw){
        // login
        if(uman.lookupUser(username) == null){
            return false;
        }
        currentUser = uman.RecordUser(username).getUsername();
        return uman.pwVerify(username, pw);
    }


    public boolean userRegister(String username, String pw){
        // lookup username; if already exists, return false.
        // else call Usermanager.register
        if(uman.lookupUser(username) == null){
            uman.userRegister(username,pw);
            return true;
        }
        return false;
    }

    public boolean userLogout(){
        // set current user as ""
        return true;
    }
}
