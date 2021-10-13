package UseCase;

import Entities.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemManager {
    private Map<String, Item> imap = new HashMap<String, Item>();

    public String addItem(String id){ // given string id, find Item and add to a vacant location

        return null;
    }

    public boolean removeItem(){
        return true;
    }

    public Item searchItem(String id){
        // return null if we can't find the item
        return this.imap.get(id);
    }

    public int getStorageTime(){
        return 0;
    }

}
