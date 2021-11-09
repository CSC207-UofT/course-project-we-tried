package UseCase;

import Entities.*;

import java.util.List;
import java.util.Map;

public class ItemStorer {
    String location = "";
    Map<String, Item> imap;


    public void createItem(Map imap, String id, List<String> info, String storageRequirement) {
        Item i1 = new Item(id, info, storageRequirement);
        imap.put(id, i1);
    }


    public String add(String id, String currentUser) {
        Item i1 = imap.get(id);
        if (findContainer(i1) != null) {
            location = findContainer(i1).nextVacantLocation();
            if (location == null) {
                return null;
            } else {
                findContainer(i1).modifyContainer(location);
                i1.setLocation(location);
                i1.setProcessor(currentUser);
                return location;
            }
        } else {
            return null;
        }
    }

    public static Container findContainer(Item i, Locker L, Freezer F, Refrigerator R){
        if (i.getStorageRequirement().equals("L")){
            return L;
        } else if (i.getStorageRequirement().equals("F")){
            return F;
        } else if (i.getStorageRequirement().equals("R")){
            return R;
        } else {return null;}
    }


}
