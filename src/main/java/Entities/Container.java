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

    void modifyContainerAdd(String l) throws IOException;
    void modifyContainerRemove(String l) throws IOException;
}
