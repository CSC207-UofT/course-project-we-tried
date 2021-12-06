package UseCase;
import Entities.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ItemStorer implements Serializable{
    /**
     * This class is responsible for storing an item.
     */
    String location = "";
    Map<String, Item> Imap;
    Container c;
    Locker L;
    Freezer F;
    Refrigerator R;

    /**
     * A helper method to set up this storer for operation, with a series of containers.
     * @param imap The map of items, mapping id to item.
     * @param l the Locker.
     * @param f the Freezer.
     * @param r the Refrigerator.
     */
    public void setup(Map<String, Item> imap, Locker l, Freezer f, Refrigerator r){
        Imap = imap;
        L = l;
        F = f;
        R = r;
    }

    /**
     * A helper method, to find the suitable container for an item.
     * @param i the given item.
     */
    public void findContainer(Item i){
        switch (i.getStorageRequirement()) {
            case "L" -> c = L;
            case "F" -> c = F;
            case "R" -> c = R;
            default -> c = null;
        }
    }


    /**
     * Create an item, with its info, and its storage requirement.
     * @param id the identification number of this item.
     * @param info the information attached to this item.
     * @param storageRequirement one of the strings "L/F/R". This identifies which container it needs
     * @return return item if the item is successfully created and put in the map; return null if the item already exists.
     */
    public Item create(String id, List<String> info, String storageRequirement) {
        Item i1 = new Item(id, info, storageRequirement);
        if(Imap.containsKey(id)){
            return null;
        }
        else{
        Imap.put(id, i1);
        return i1;
        }
    }

    /**
     *
     * @param id Add an item with its id.
     * @param currentUser the user's username, of whom that adds this item.
     * @return return the location where the item is stored; if the item cannot be stored, return null.
     */
    public String add(String id, String currentUser) throws IOException {
        Item i1 = Imap.get(id);
        if(i1 == null){
            return null;
        }
        findContainer(i1);
        if (c != null) {
            location = c.nextVacantLocation();
            if (location == null) {
                Imap.remove(id);
                return null;
            } else {
                c.modifyContainerAdd(location);
                i1.setLocation(location);
                i1.setProcessor(currentUser);
                return location;
            }
        } else {
            Imap.remove(id);
            return null;
        }
    }


}
