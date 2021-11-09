package Entities;

import java.util.Map;

public interface Container {

    int getCapacity();
    int getNumberOfItems();
    int getVacancy();
    Map<String, Boolean> generateMap();
    String nextVacantLocation();

    /* Need to change map*/
    void modifyMap(String l);

}
