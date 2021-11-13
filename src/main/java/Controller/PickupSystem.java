package Controller;

import UseCase.*;

import java.util.List;
public class PickupSystem {
    private final ItemManager iman;
    private final UserManager uman = new UserManager();

    public PickupSystem(){
        ItemStorer storer = new ItemStorer();
        ItemPicker picker = new ItemPicker();
        ItemSearcher searcher = new ItemSearcher();
        ItemTimer timer = new ItemTimer();
        this.iman = new ItemManager(storer, searcher, picker, timer);
    }

    public void pickup(String id){
        // this will interact with the UI layer
        iman.removeItem(id);
        }

    public String storeItem(String id, List<String> info, String storageRequirement, String name) {
        // this will interact with the UI layer
        String currentUser = uman.RecordUser(name).getUsername();
        return iman.addItem(id, info, storageRequirement, currentUser);
    }

    public List<String> search(String id){

        return iman.searchItem(id);
        }

    public ItemManager getIman() {
        return iman;
    }
    public UserManager getUman(){
        return uman;
    }

    //        if(iman.getvancancy() == false){
//            return false;
//        }
//        else{
//            Item i = iman.createItem(String id, List<String> info, String storageRequirement);
//            iman.addItem(i);
//            return true;

        }
