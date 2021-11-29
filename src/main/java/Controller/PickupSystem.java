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

    /**
     * An empty constructor.
     */
    public PickupSystem(){}

    /**
     * Construct a new PickupSystem with existing ItemManager.
     * @param iman An existing ItemManager.
     */
    public PickupSystem(ItemManager iman) {
        this.iman = iman;
    }

    /**
     * Pick an item and save the new file to local.
     * @param id The item id.
     */
    public void pickup(String id) throws IOException {
        // this will interact with the UI layer
        iman.removeItem(id);
        FileOutputStream fos = new FileOutputStream("xyz.txt");
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
        String currentUser = uman.RecordUser(name);
        String str = iman.addItem(id, info, storageRequirement, currentUser);
        FileOutputStream fos = new FileOutputStream("xyz.txt");
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

}
