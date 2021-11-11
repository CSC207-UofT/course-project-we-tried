package UseCase;

import Entities.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemManager {
    private static final Map<String, Item> imap = new HashMap<String, Item>();
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
        Locker l = new Locker(3, lmap);
        Freezer f = new Freezer(1, fmap);
        Refrigerator r = new Refrigerator(2, rmap);

        storer.setup(imap, l, f, r);
    }



    public Map<String, Item> getItemMap() {
        return imap;
    }

    public String addItem(String id, List<String> info, String storageRequirement, String currentUser) {
        storer.create(id, info, storageRequirement);
        // timer.RecordStart();
        return storer.add(id,currentUser);
    }

    public String removeItem(String id) {
        if(searcher.search(id,imap)!=null){
        //checkFee(id);
        return picker.remove(id,imap);}
        else{return null;}
    }

    public List<String> searchItem(String id){
        // checkFee(id);
        return searcher.search(id, imap);
    }

    public void checkFee(String id){
        timer.CalculateFee();
    }

}
