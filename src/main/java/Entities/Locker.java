package Entities;

import java.util.HashMap;
import java.util.Map;

public class Locker implements Container{
    private Map<String, Boolean> lmap;
    private final int capacity = 0;
    private int number_items;
    private int Vacancy;

    public Locker(int number_items, int vacancy, Map<String, Boolean> lmap){
        this.number_items = number_items;
        this.lmap= lmap;
        this.Vacancy = vacancy;
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
        for (String location: lmap.keySet()){
            Boolean empty = lmap.get(location);
            if (empty){ return location;
            }
        }
        return null;
    }

    @Override
    public Map<String, Boolean> generateMap() {
        return lmap;
    }
}
