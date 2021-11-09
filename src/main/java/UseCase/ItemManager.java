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
    private final ItemStorer storer;
    private final ItemSearcher searcher;
    private final ItemPicker picker;
    private final ItemTimer timer;

    /**
     * A new ItemManager, with a preset series of containers.
     * This is the "Facade" class.
     */
    public ItemManager(ItemStorer storer, ItemSearcher searcher, ItemPicker picker, ItemTimer timer) {
        this.storer = storer;
        this.searcher = searcher;
        this.picker = picker;
        this.timer = timer;

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
        R = new Refrigerator(2, rmap);

        storer.setup(imap, L,F,R);
    }

    /*A customized series of containers*/
    public ItemManager(List<String> series) {
    }

    public Map<String, Item> getItemMap() {
        return imap;
    }

    public String addItem(String id, List<String> info, String storageRequirement, String currentUser) {
        storer.create(id, info, storageRequirement);
        storer.add(id,currentUser);
        // timer.RecordStart();
    }

    public String removeItem(String id) {
        //searcher.search();
        //checkFee(id);
        return picker.remove(id,imap);
    }

    public List<String> searchItem(String id){
        // checkFee(id);
        return searcher.search(id, imap);
    }

    public void checkFee(String id){
        timer.CalculateFee();
    }

}
