package UseCase;

import Entities.*;

import java.util.List;
import java.util.Map;

public class ItemStorer {
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

    public void create(String id, List<String> info, String storageRequirement) {
        Item i1 = new Item(id, info, storageRequirement);
        Imap.put(id, i1);
    }


    public String add(String id, String currentUser) {
        Item i1 = Imap.get(id);
        findContainer(i1);
        if (c != null) {
            location = c.nextVacantLocation();
            if (location == null) {
                return null;
            } else {
                c.modifyContainer(location);
                i1.setLocation(location);
                i1.setProcessor(currentUser);
                return location;
            }
        } else {
            return null;
        }
    }


}
