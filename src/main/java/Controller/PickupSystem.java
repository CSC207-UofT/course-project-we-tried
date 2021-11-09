package Controller;

import UseCase.ItemManager;
import UseCase.UserManager;

public class PickupSystem {
    private UserManager uman = new UserManager();
    private ItemManager iman = new ItemManager();
    private static String currentUser = "";

    public PickupSystem{

    }

    public boolean userLogin(String username, String pw){
        // login
        if(uman.lookupUser(username,pw) == false){
            return false;
        }
        return true;
    }

    public boolean userRegister(String username, String pw){
        // lookup username; if already exists, return false.
        // else call Usermanager.register
        if(uman.lookupUser(username,pw) == false){
            uman.register();
            return true;
        }
        return false;
    }

    public boolean userLogout(){
        // set current user as ""
        return true;
    }

    public void pickup(String id){
        // this will interact with the UI layer
        iman.removeItem(id);
        }
    }

    public boolean storeItem(String id, List<String> info, String storageRequirement){
        // this will interact with the UI layer
        iman.createItem(String id, List<String> info, String storageRequirement);
        if(iman.addItem(id,currentUser)==false){
            return false;
        }
        return true;

    public String search(String id) {
        if(iman.searchItem(id) == null){
            return null;
        return iman.searchItem(id)
        }

        


//        if(iman.getvancancy() == false){
//            return false;
//        }
//        else{
//            Item i = iman.createItem(String id, List<String> info, String storageRequirement);
//            iman.addItem(i);
//            return true;

        }
    }

}
