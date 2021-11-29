package UseCase;

import Entities.Item;

import java.io.Serializable;
import java.util.*;

public class ItemTimer implements Serializable {
    /**
     * A map, recording the id of an item and a list of dates; the first date is when the item is stored.
     * The second date is when the free storage expires.
     */
    private Map<String, List<Calendar>> timer_map = new HashMap<String, List<Calendar>>();

    /**
     * Record the current time when item i is added and automatically calculate when the free storage time ends.
     * @param i the item that is just added.
     */
    public void RecordStart(Item i) {
        String id = i.getId();
        Calendar c_start = Calendar.getInstance();
        List<Calendar> t_list = new ArrayList<Calendar>();
        t_list.add(0,c_start);

        int freeStorageTime = 2; // usual free storage time = 2 days
        if(i.getStorageRequirement().equals("F")){
            freeStorageTime = 1;} // for item requiring freezer the free storage time = 1 day

        Calendar c_fee = Calendar.getInstance();
        c_fee.add(Calendar.DATE, freeStorageTime);
        t_list.add(1,c_fee);

        timer_map.put(id,t_list);
    }

    /**
     * When the item is picked up, remove it from timer system.
     * @param id the identification number of the item.
     */
    public void RecordEnd(String id){
        timer_map.remove(id);
    }

    /**
     * Any time when the method is called, calculate the storage fee of the item with id.
     * @param id the identification number of the item.
     * @return return the amount of current storage fee.
     */
    public int CalculateFee(String id){
        Calendar c_current = Calendar.getInstance();
        List<Calendar> t_list = timer_map.get(id);
        Calendar c_fee = t_list.get(1);
        if(c_current.before(c_fee)){
            return 0;
        } else {
            return 10; // the fine of exceeding free storage time is set to be $ 10.
        }
    }

    /**
     * Get the list of dates for id and convert it into a list of string.
     * @param id the identification number of the item.
     * @return return a list of string representation of the dates.
     */
    public List<String> getTimeListString(String id){
        List<Calendar> t_list = timer_map.get(id);
        if (t_list == null){return null;}
        List<String> s_list = new ArrayList<>();
        for (Calendar t: t_list){
            String s = t.get(Calendar.YEAR) + "/" + t.get(Calendar.MONTH)+1 + "/" + t.get(Calendar.DATE);
            s_list.add(s);
        }
        return s_list;
    }

    public Map<String, List<Calendar>> getTimer_map() {
        return timer_map;
    }

}
