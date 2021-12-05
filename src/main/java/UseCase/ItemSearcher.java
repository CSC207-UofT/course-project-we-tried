package UseCase;
import Entities.Item;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ItemSearcher implements Serializable{

    /**
     * Search for an item with id.
     * @param id the identification number of the item to be searched.
     * @param imap the map of items, mapping id to item.
     * @return return the information of the item fund, in a list; if the item is not fund, return null.
     */
    public List<String> search(String id, Map<String, Item> imap) {
        if (imap.get(id) == null) {
            return null;
        }
        return imap.get(id).getInfo();
    }

}
