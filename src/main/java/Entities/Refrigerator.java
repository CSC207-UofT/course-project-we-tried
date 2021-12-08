package Entities;
import java.io.*;
import java.util.Map;

public class Refrigerator implements Container, Serializable {
    /**
     * The map of this Refrigerator, with index of the locations and its state(empty or not).
     */
    private final Map<String, Boolean> rmap;
    /**
     * The capacity of this Refrigerator.
     */
    private final int capacity;
    /**
     * The current number of items in this Refrigerator. Default is 0.
     */
    private int number_items;
    /**
     * The number of vacant spaces of this Refrigerator.
     */
    private int Vacancy;

    /**
     * A new, empty Refrigerator, with a preset capacity and map.
     */
    public Refrigerator(int capacity, Map<String, Boolean> rmap) throws IOException {
        this.capacity = capacity;
        this.rmap = rmap;
        this.Vacancy = capacity;
        this.number_items = 0;
    }

    /**
     * A refrigerator, generated from a existing map.
     * @param rmap existing map from files.
     */
    public Refrigerator(Map<String, Boolean> rmap){
        this.capacity = rmap.size();
        this.rmap = rmap;
        this.Vacancy = capacity;
        this.number_items = 0;
        for(boolean i: rmap.values()){
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
        this.rmap.replace(location, false, true);
    }
    /**
     * Make modifications to the container when an item is removed.
     * @param location  a string of the location of container
     */
    @Override
    public void modifyContainerRemove(String location) {
        this.number_items = this.number_items - 1;
        this.Vacancy = this.Vacancy + 1;
        this.rmap.replace(location, true, false);
    }

    /**
     * Return the Refrigerator's capacity.
     */
    @Override
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Return the number of items in Refrigerator.
     */
    @Override
    public int getNumberOfItems() {
        return this.number_items;
    }

    /**
     * Return the Refrigerator's vacancy.
     */
    @Override
    public int getVacancy() {
        return this.Vacancy;
    }

    /**
     *
     * @return the next empty location for the refrigerator
     */
    @Override
    public String nextVacantLocation() {
        for (String location: rmap.keySet()){
            Boolean empty = rmap.get(location);
            if (!empty){ return location;
            }
        }
        return null;
    }

    /**
     *
     * @return a map with key string and value boolean for the refrigerator
     */
    @Override
    public Map<String, Boolean> generateMap() {
        return rmap;
    }
}
