package Controller;

import UseCase.ItemManager;
import UseCase.UserManager;

public class PickupSystem {
    private UserManager uman = new UserManager();
    private ItemManager iman = new ItemManager();
    private String currentUser = "";

    public static boolean userLogin(String username, String pw){
        // login
        return true;
    }

    public static boolean userRegister(String username, String pw){
        // lookup username; if already exists, return false.
        // else call Usermanager.register
        return true;
    }

    public boolean userLogout(){
        // set current user as ""
        return true;
    }

    public void run(){
        // this will interact with the UI layer
        iman.removeItem("12345");
    }

}
