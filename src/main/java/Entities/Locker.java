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
    public Locker(int capacity, Map<String, Boolean> lmap){
        this.capacity = capacity;
        this.lmap = lmap;
        this.Vacancy = capacity;
        this.number_items = 0;
    }

    /**
     * Make modifications to the container when an item is added.
     */
    @Override
    public void modifyContainerAdd(String location) throws IOException {
        this.number_items = this.number_items + 1;
        this.Vacancy = this.Vacancy - 1;
        this.lmap.replace(location, false, true);
        FileOutputStream fos = new FileOutputStream("locker.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.lmap);
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

    @Override
    public Map<String, Boolean> generateMap() {
        return lmap;
    }
}