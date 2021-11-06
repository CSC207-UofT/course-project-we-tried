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

    public boolean userRegister(String username, String pw){
        // lookup username; if already exists, return false.
        // else call Usermanager.register
        if(uman.lookupUser(username,pw) == false){ uman.register();

        }
        return false;
    }

    public boolean userLogout(){
        // set current user as ""
        return true;
    }

    public boolean pickup(String id){
        // this will interact with the UI layer
        if(iman.searchItem(id) == null){
            return false;
        }
        else{
        iman.removeItem(id);
        return true;
        }
    }

    public boolean storeItem(Item i){
        // this will interact with the UI layer

        if(iman.getvancancy() == false){
            return false;
        }
        else{
            iman.addItem(i);
            return true;

        }
    }

}
