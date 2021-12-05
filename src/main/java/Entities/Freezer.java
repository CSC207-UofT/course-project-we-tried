package Entities;
import java.io.*;
import java.util.Map;

public class Freezer implements Container, Serializable{
    /**
     * The map of this Freezer, with index of the locations and its state(empty or not).
     */
    private final Map<String, Boolean> fmap;
    /**
     * The capacity of this Freezer.
     */
    private final int capacity;
    /**
     * The current number of items in this Freezer. Default is 0.
     */
    private int number_items;
    /**
     * The number of vacant spaces of this Freezer.
     */
    private int Vacancy;

    /**
     * A new, empty freezer, with a preset capacity and map.
     * @param fmap existing map from files.
     */
    public Freezer(int capacity, Map<String, Boolean> fmap) throws IOException {
        this.capacity = capacity;
        this.fmap = fmap;
        this.number_items = 0;
        this.Vacancy = capacity;
    }

    /**
     * A freezer, generated from a existing map.
     * @param fmap existing map from files.
     */
    public Freezer(Map<String, Boolean> fmap){
        this.capacity = fmap.size();
        this.fmap = fmap;
        this.Vacancy = capacity;
        this.number_items = 0;
        for(boolean i: fmap.values()){
            if(i){
                this.number_items = this.number_items + 1;
                this.Vacancy = this.Vacancy - 1;
            }
        }
    }

    /**
     * Make modifications to the container when an item is added.
     * @param location  a string of the location of container
     */
    @Override
    public void modifyContainerAdd(String location) {
        this.number_items = this.number_items + 1;
        this.Vacancy = this.Vacancy - 1;
        this.fmap.replace(location, false, true);
    }

    /**
     * Make modifications to the container when an item is removed.
     * @param location  a string of the location of container
     */
    @Override
    public void modifyContainerRemove(String location) {
        this.number_items = this.number_items - 1;
        this.Vacancy = this.Vacancy + 1;
        this.fmap.replace(location, true, false);
    }

    /**
     * Return the Freezer's capacity.
     */
    @Override
    public int getCapacity() {
        return capacity;
    }

    /**
     * Return the number of items in Freezer.
     */
    @Override
    public int getNumberOfItems() {
        return number_items;
    }
    /**
     * Return the Freezer's vacancy.
     */
    @Override
    public int getVacancy() {
        return Vacancy;
    }
    /**
     * Automatically find the next vacant location for a new item to be placed in.
     */
    @Override
    public String nextVacantLocation() {
        for (String location: fmap.keySet()){
            Boolean empty = fmap.get(location);
            if (!empty){ return location;
            }
        }
        return null;
    }

    @Override
    public Map<String, Boolean> generateMap() {
        return fmap;
    }

}
