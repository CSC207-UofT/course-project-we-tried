package Entities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface Container {

    int getCapacity();
    int getNumberOfItems();
    int getVacancy();
    Map<String, Boolean> generateMap();
    String nextVacantLocation();

    void modifyContainer(String l);

}
