package Entities;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Containerfacotry {
    public Container get_container(String type) throws IOException {
        if (type.equalsIgnoreCase("Freezer")){
            Map<String, Boolean> fmap = new LinkedHashMap<>(1);
            fmap.put("f01", false);
            return new Freezer(1, fmap);
        }
        if (type.equalsIgnoreCase("Refrigerator")){
            Map<String, Boolean> rmap = new LinkedHashMap<>(2);
            rmap.put("r01", false);
            rmap.put("r02", false);
            return new Refrigerator(2, rmap);
        }
        if (type.equalsIgnoreCase("Locker")){
            Map<String, Boolean> lmap = new LinkedHashMap<>(3);
            lmap.put("L01", false);
            lmap.put("L02", false);
            lmap.put("L03", false);
            return new Locker(3, lmap);
        }
        return null;
    }
}
