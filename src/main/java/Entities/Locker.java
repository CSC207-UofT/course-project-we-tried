package Entities;
import java.io.*;
import java.util.Map;

public class Locker implements Container, Serializable{
    /**
     * The map of this Locker, with index of the locations and its state(empty or not).
     */
    private final Map<String, Boolean> lmap;
    /**
     * The capacity of this Locker.
     */
    private final int capacity;
    /**
     * The current number of items in this Locker. Default is 0.
     */
    private int number_items;
    /**
     * The number of vacant spaces of this Locker.
     */
    private int Vacancy;

    /**
     * A new, empty locker, with a preset capacity and map.
     */
    public Locker(int capacity, Map<String, Boolean> lmap) throws IOException {
        this.capacity = capacity;
        this.lmap = lmap;
        this.Vacancy = capacity;
        this.number_items = 0;
    }

    /**
     * A locker, generated from a existing map.
     * @param lmap existing map from files.
     */
    public Locker(Map<String, Boolean> lmap){
        this.capacity = lmap.size();
        this.lmap = lmap;
        this.Vacancy = capacity;
        this.number_items = 0;
        for(boolean i: lmap.values()){
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
        this.lmap.replace(location, false, true);
    }
    /**
     * Make modifications to the container when an item is removed.
     * @param location  a string of the location of container
     */
    @Override
    public void modifyContainerRemove(String location) {
        this.number_items = this.number_items - 1;
        this.Vacancy = this.Vacancy + 1;
        this.lmap.replace(location, true, false);
    }

    /**
     * Return the Locker's capacity.
     */
    @Override
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Return the number of items in Locker.
     */
    @Override
    public int getNumberOfItems() {
        return this.number_items;
    }

    /**
     * Return the Locker's vacancy.
     */
    @Override
    public int getVacancy() {
        return this.Vacancy;
    }

    /**
     * Automatically find the next vacant location for a new item to be placed in.
     */
    @Override
    public String nextVacantLocation() {
        for (String location: lmap.keySet()){
            Boolean empty = lmap.get(location);
            if (!empty){ return location;
            }
        }
        return null;
    }

    /**
     *
     * @return a map with key string and value boolean for the locker
     */
    @Override
    public Map<String, Boolean> generateMap() {
        return lmap;
    }
}