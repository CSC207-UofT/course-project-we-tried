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

    public void setup(Map<String, Item> imap, Locker l, Freezer f, Refrigerator r){
        Imap = imap;
        L = l;
        F = f;
        R = r;
    }

    public String remove(String id){
        Item i1 = Imap.get(id);
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
