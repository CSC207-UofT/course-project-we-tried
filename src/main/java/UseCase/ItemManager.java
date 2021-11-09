package UseCase;

import Entities.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemManager {
    private static Map<String, Item> imap = new HashMap<String, Item>();
    private static Locker L;
    private static Freezer F;
    private static Refrigerator R;


    /**
     * A new ItemManager, with a preset series of containers.
     */
    public ItemManager(){
        Map<String, Boolean> lmap = new HashMap<>(3);
        lmap.put("L01", false);
        lmap.put("L02", false);
        lmap.put("L03", false);
        Map<String, Boolean> fmap = new HashMap<>(1);
        fmap.put("f01", false);
        Map<String, Boolean> rmap = new HashMap<>(2);
        rmap.put("r01", false);
        rmap.put("r02", false);
        L = new Locker(3, lmap);
        F = new Freezer(1, fmap);
        R = new Refrigerator(2,rmap);
    }

    /*A customized series of containers*/
    public ItemManager(List<String> series){
    }

    public Item createItem(String id, List<String> info, String storageRequirement){
        Item i1 = new Item(id, info, storageRequirement);
        imap.put(id, i1);
        return i1;
    }

    public static Container findContainer(Item i){
        if (i.getStorageRequirement().equals("L")){
            return L;
        } else if (i.getStorageRequirement().equals("F")){
            return F;
        } else if (i.getStorageRequirement().equals("R")){
            return R;
        } else {return null;}
    }

    public boolean addItem(String id, String currentUser) {
        Item i1 = imap.get(id);
        if (findContainer(i1) != null) {
            String location = findContainer(i1).nextVacantLocation();
            if (location == null) {
                return false;
            } else {
                findContainer(i1).modifyContainer(location);
                i1.setLocation(location);
                i1.setProcessor(currentUser);
                return true;
            }
        } else {return false;}
    }

    public String removeItem(String id){
        String location;
        location = imap.get(id).getLocation();
        imap.remove(id);
        return location;
    }

    public String searchItem(String id){
        if(imap.get(id) == null){
            return null;
        }
        return imap.get(id).getInfo();
    }

    public Map<String, Item> getItemMap(){
        return imap;
    }

    public int getStorageTime(){
        // TODO: find a way to express the storage time and set a standard(free storage).
        return 0;
    }

    public void setFee(String id, int fee){
        Item i1 = imap.get(id);
        // TODO: add the condition about storage time(check whether the fee should be set; if not, return false)
        i1.setFee(fee);
    }

    public boolean checkFee(String id){
        Item i1 = imap.get(id);
        return i1.isFee();
    }

}
