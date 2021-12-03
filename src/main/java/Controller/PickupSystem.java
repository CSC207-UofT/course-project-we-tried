package Controller;
import java.io.*;
import UseCase.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PickupSystem {
    ItemStorer storer = new ItemStorer();
    ItemPicker picker = new ItemPicker();
    ItemSearcher searcher = new ItemSearcher();
    ItemTimer timer = new ItemTimer();
    private ItemManager iman = new ItemManager(storer, searcher, picker, timer);
    private final UserManager uman = new UserManager();
    private Map<String, String> item_location = new HashMap<>();
    /**
     * An empty constructor.
     */
    public PickupSystem() throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\delivery file\\xyz.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.iman);
    }

    /**
     * Construct a new PickupSystem with existing ItemManager.
     * @param iman An existing ItemManager.
     */
    public PickupSystem(ItemManager iman) throws IOException {
        this.iman = iman;
    }

    /**
     * Pick an item and save the new file to local.
     * @param id The item id.
     */
    public void pickup(String id) throws IOException {
        // this will interact with the UI layer
        if (iman.searchItem(id) != null){
            String loca = iman.removeItem(id);
            item_location.remove(loca);
        }
        FileOutputStream fos = new FileOutputStream("D:\\delivery file\\xyz.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.iman);
        }

    /**
     * Store a new item to the current map and save ItemManager to the file.
     * @param id Item id.
     * @param info Item info.
     * @param storageRequirement Item's storage requirement.
     * @param name current user's name.
     * @return return Item's information.
     */
    public String storeItem(String id, List<String> info, String storageRequirement, String name) throws IOException, ClassNotFoundException {
        // this will interact with the UI layer
        String str = iman.addItem(id, info, storageRequirement, name);
        if (str != null){
            uman.record_item_processor(name, id);
            item_location.put(str,id);
        }
        FileOutputStream fos = new FileOutputStream("D:\\delivery file\\xyz.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.iman);
        return str;
    }

    /**
     * Search item's information.
     * @param id Item's id.
     * @return return the item's information.
     */
    public List<String> search(String id){
        return iman.searchItem(id);
        }

    public ItemManager getIman() {
        return iman;
    }
    public UserManager getUman(){
        return uman;
    }

    /**
     * Get user processed items' ids.
     * @param username The input username.
     * @return Return the ArrayList contains all items' ids processed by this user.
     */
    public ArrayList<String> get_processor_item(String username){
        return uman.getUserImap(username);
    }
}
