package Controller;

import UseCase.ItemManager;
import UseCase.UserManager;
import java.util.List;
public class PickupSystem {
    private UserManager uman = new UserManager();
    private ItemManager iman = new ItemManager();
    private static String currentUser = "";

    public PickupSystem(){
    }

    public void pickup(String id){
        // this will interact with the UI layer
        iman.removeItem(id);
        }

    public boolean storeItem(String id, List<String> info, String storageRequirement) {
        // this will interact with the UI layer
        iman.createItem(id,info,storageRequirement);
        return iman.addItem(id, currentUser);
    }

    public List<String> search(String id){
        return iman.searchItem(id);
        }

        


//        if(iman.getvancancy() == false){
//            return false;
//        }
//        else{
//            Item i = iman.createItem(String id, List<String> info, String storageRequirement);
//            iman.addItem(i);
//            return true;

        }
