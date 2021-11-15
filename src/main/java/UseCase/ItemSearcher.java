package UseCase;
import java.io.*;
import Entities.Item;

import java.util.List;
import java.util.Map;

public class ItemSearcher implements Serializable{

    /**
     * This class is responsible for searching an item that have been placed in the container.
     */

    public List<String> search(String id, Map<String, Item> imap) {
        if (imap.get(id) == null) {
            return null;
        }
        return imap.get(id).getInfo();
    }

}
