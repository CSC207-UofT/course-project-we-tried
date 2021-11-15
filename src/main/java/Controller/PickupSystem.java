package Controller;
import java.io.*;
import UseCase.*;

import java.util.List;
public class PickupSystem {
    ItemStorer storer = new ItemStorer();
    ItemPicker picker = new ItemPicker();
    ItemSearcher searcher = new ItemSearcher();
    ItemTimer timer = new ItemTimer();
    private ItemManager iman = new ItemManager(storer, searcher, picker, timer);
    private final UserManager uman = new UserManager();

    public PickupSystem(){}

    public PickupSystem(ItemManager iman) throws IOException, ClassNotFoundException {
        this.iman = iman;
    }

    public void pickup(String id) throws IOException {
        // this will interact with the UI layer
        iman.removeItem(id);
        FileOutputStream fos = new FileOutputStream("xyz.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.iman);
        }

    public String storeItem(String id, List<String> info, String storageRequirement, String name) throws IOException, ClassNotFoundException {
        // this will interact with the UI layer
        String currentUser = uman.RecordUser(name);
        String str = iman.addItem(id, info, storageRequirement, currentUser);
        FileOutputStream fos = new FileOutputStream("xyz.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.iman);
        return str;
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
