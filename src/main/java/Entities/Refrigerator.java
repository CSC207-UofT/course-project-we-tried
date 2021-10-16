package Entities;

import java.util.HashMap;
import java.util.Map;

public class Refrigerator implements Container {
    private Map<String, Boolean> rmap;
    private final int capacity = 0;
    private int number_items;
    private int Vacancy;

    public Refrigerator(int number_items, int vacancy){
        this.number_items = number_items;
        this.Vacancy = vacancy;
        this.rmap = new HashMap<String, Boolean>();
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
            if (empty){ return location;
            }
        }
        return null;
    }

    @Override
    public Map<String, Boolean> generateMap() {
        return rmap;
    }
}
