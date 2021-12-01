package UseCase;

import Entities.*;

import java.io.*;
import java.util.Map;

public class ItemPicker implements Serializable{
    /**
     * This class is responsible for picking up an item.
     */
    String location = "";
    Map<String, Item> Imap;
    Container c;
    Locker L;
    Freezer F;
    Refrigerator R;

    /**
     * A helper method, to find the suitable container for an item.
     * @param i the given item.
     */
    public void findContainer(Item i){
        if (i.getStorageRequirement().equals("L")){
            c = L;
        } else if (i.getStorageRequirement().equals("F")){
            c = F;
        } else if (i.getStorageRequirement().equals("R")){
            c = R;
        } else {
            c = null;}
    }

    /**
     * A helper method to set up this picker for operation, with a series of containers.
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
     * Remove an item with id.
     * @param id the identification number of the item to be removed.
     * @return return the location of the item; if the item is not found, return null.
     */
    public String remove(String id){
        Item i1 = Imap.get(id);
        if(i1 == null){
            return null;
        }
        findContainer(i1);
        location = i1.getLocation();
        if (c != null) {
            try {
                c.modifyContainerRemove(location);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Imap.remove(id);
            return location;
        }
            return null;
    }
}
