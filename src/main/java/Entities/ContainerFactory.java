package Entities;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ContainerFactory {
    public Container get_container(String type) throws IOException {
        if (type.equalsIgnoreCase("Freezer")){
            Map<String, Boolean> fmap = new LinkedHashMap<>(6);
            for(int x = 1; x <= 6; x=x+1){
                 String loc = "F"+"0" + x;
                 fmap.put(loc, false);}
            return new Freezer(6, fmap);
        }

        if (type.equalsIgnoreCase("Refrigerator")){
            Map<String, Boolean> rmap = new LinkedHashMap<>(12);
            for(int x = 1; x <= 12; x=x+1){
                String loc = null;
                if(x<=9){
                    loc = "R"+"0" + x;
                }else{
                    loc = "R"+x;
                }
                rmap.put(loc, false);}
            return new Refrigerator(12, rmap);
        }

        if (type.equalsIgnoreCase("Locker")) {
            Map<String, Boolean> lmap = new LinkedHashMap<>(15);
            for (int x = 1; x <= 15; x = x + 1) {
                String loc = null;
                if (x <= 9) {
                    loc = "L" + "0" + x;
                } else {
                    loc = "L" + x;
                }
                lmap.put(loc, false);
            }
            return new Locker(15, lmap);
        }

        return null;
    }
}
