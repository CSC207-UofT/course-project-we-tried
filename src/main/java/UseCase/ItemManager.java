package UseCase;

import Entities.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemManager {
    private Map<String, Item> imap = new HashMap<String, Item>();

    public void addItem(Item i){ // given string id, find Item and add to a vacant location
        // TODO: Check container capacity
        // TODO: Modify container map
        // TODO: Set the location of i
        imap.put(i.getId(), i);
    }

    public String removeItem(String id){
        String location;
        location = this.imap.get(id).getLocation();
        this.imap.remove(id);
        return location;
    }

    public String searchItem(String id){
        if(this.imap.get(id) == null){
            return null;
        }
        return this.imap.get(id).toString();
    }

    public int getStorageTime(){
        return 0;
    }

}
