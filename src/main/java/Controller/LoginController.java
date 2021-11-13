package Controller;
import UseCase.ItemManager;
import UseCase.UserManager;
import java.util.List;
import java.util.Objects;

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
        else if (uman.pwVerify(username, pw)){
            currentUser = username;
            return true;
        }
        return false;
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
        if(Objects.equals(currentUser, "")){
            return false;
        }
        currentUser = "";

        return true;
    }

    public void set_uman_current_empty(){

    }

    public UserManager getUman(){
        return uman;
    }
}
