package UseCase;
import java.io.*;
import Entities.*;

import java.util.List;
import java.util.Map;

public class ItemStorer implements Serializable{
    String location = "";
    Map<String, Item> Imap;
    Container c;
    static Locker L;
    static Freezer F;
    static Refrigerator R;

    public void setup(Map<String, Item> imap, Locker l, Freezer f, Refrigerator r){
        Imap = imap;
        L = l;
        F = f;
        R = r;
    }

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

    public boolean create(String id, List<String> info, String storageRequirement) {
        Item i1 = new Item(id, info, storageRequirement);
        if(Imap.containsKey(id)){
            return false;
        }
        else{
        Imap.put(id, i1);
        return true;
        }
    }

    public String add(String id, String currentUser) throws IOException {
        Item i1 = Imap.get(id);
        findContainer(i1);
        if (c != null) {
            location = c.nextVacantLocation();
            if (location == null) {
                Imap.remove(id);
                return null;
            } else {
                c.modifyContainer(location);
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
