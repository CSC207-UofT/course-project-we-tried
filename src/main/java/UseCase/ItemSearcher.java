package UseCase;

import Entities.Item;

import java.util.List;
import java.util.Map;

public class ItemSearcher {


    public List<String> search(String id, Map<String, Item> imap) {
        if (imap.get(id) == null) {
            return null;
        }
        return imap.get(id).getInfo();
    }

}
