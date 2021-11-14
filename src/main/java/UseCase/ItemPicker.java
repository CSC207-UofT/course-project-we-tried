package UseCase;

import Entities.Item;
import java.io.*;
import java.util.Map;

public class ItemPicker implements Serializable{
    /**
     * This class is responsible for picking up an item.
     */
    String location = "";

    public String remove(String id, Map<String, Item> imap) {
        location = imap.get(id).getLocation();
        imap.remove(id);
        return location;
    }
}
