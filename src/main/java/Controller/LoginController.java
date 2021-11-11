package Controller;
import UseCase.ItemManager;
import UseCase.UserManager;
import java.util.List;
public class LoginController {
    private UserManager uman = new UserManager();
    private ItemManager iman = new ItemManager();
    private static String currentUser = "";


    public LoginController(){
    }

    public boolean userLogin(String username, String pw){
        // login
        if(uman.lookupUser(username) == null){
            return false;
        }
        currentUser = username;
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

        currentUser = ""

        return true;
    }
}
