package Entities;

import java.util.Map;

public class Refrigerator implements Container {
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
    public Refrigerator(int capacity, Map<String, Boolean> rmap){
        this.capacity = capacity;
        this.rmap = rmap;
        this.Vacancy = capacity;
        this.number_items = 0;
    }

    /**
     * Make modifications to the container when an item is added.
     */
    @Override
    public void modifyContainer(String location) {
        this.number_items = this.number_items + 1;
        this.Vacancy = this.Vacancy - 1;
        this.rmap.replace(location, false, true);
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfItems() {
        return this.number_items;
    }

    @Override
    public int getVacancy() {
        return this.Vacancy;
    }

    @Override
    public String nextVacantLocation() {
        for (String location: rmap.keySet()){
            Boolean empty = rmap.get(location);
            if (!empty){ return location;
            }
        }
        return null;
    }

    @Override
    public Map<String, Boolean> generateMap() {
        return rmap;
    }
}
