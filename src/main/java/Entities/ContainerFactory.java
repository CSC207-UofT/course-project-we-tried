package Entities;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ContainerFactory {
    public static final int FREEZER_SIZE = 6;
    public static final int REFRIGERATOR_SIZE = 12;
    public static final int LOCKER_SIZE = 15;

    /**
     * Get different container by different input type.
     * @param type the needed container type.
     * @return return a Freezer container if the type is "Freezer",return a Refrigerator container if the
     * type is "Refrigerator", return a Locker container if the type is "Locker"; return null if type is not
     * any of above three.
     */
    public Container getContainer(String type) throws IOException {
        if (type.equalsIgnoreCase("Freezer")){
            Map<String, Boolean> fmap = new LinkedHashMap<>(FREEZER_SIZE);
            for(int x = 1; x <= FREEZER_SIZE; x=x+1){
                 String loc = "F"+"0" + x;
                 fmap.put(loc, false);}
            return new Freezer(FREEZER_SIZE, fmap);
        }

        if (type.equalsIgnoreCase("Refrigerator")){
            Map<String, Boolean> rmap = new LinkedHashMap<>(REFRIGERATOR_SIZE);
            for(int x = 1; x <= REFRIGERATOR_SIZE; x=x+1){
                String loc;
                if(x <= 9){
                    loc = "R"+"0" + x;
                }else{
                    loc = "R"+x;
                }
                rmap.put(loc, false);}
            return new Refrigerator(REFRIGERATOR_SIZE, rmap);
        }

        if (type.equalsIgnoreCase("Locker")) {
            Map<String, Boolean> lmap = new LinkedHashMap<>(LOCKER_SIZE);
            for (int x = 1; x <= LOCKER_SIZE; x = x + 1) {
                String loc;
                if (x <= 9) {
                    loc = "L" + "0" + x;
                } else {
                    loc = "L" + x;
                }
                lmap.put(loc, false);
            }
            return new Locker(LOCKER_SIZE, lmap);
        }

        return null;
    }
}
