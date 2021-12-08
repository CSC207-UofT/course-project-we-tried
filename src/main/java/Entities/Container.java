package Entities;
import java.io.IOException;
import java.util.Map;

public interface Container {

    /**
     * @return  return the capacity of the container
     */
    int getCapacity();
    /**
     * @return  return the number of items in the container
     */
    int getNumberOfItems();
    /**
     * @return  return the number of empty space in the container
     */
    int getVacancy();
    /**
     * @return  return the map of the container
     */
    Map<String, Boolean> generateMap();
    /**
     * @return  return the next available empty space in the container
     */
    String nextVacantLocation();
    /**
     * add the item into the container
     */
    void modifyContainerAdd(String l) throws IOException;
    /**
     * remove the item into the container
     */
    void modifyContainerRemove(String l) throws IOException;
}
