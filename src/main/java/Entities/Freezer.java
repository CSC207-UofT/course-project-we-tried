package Entities;

import java.util.HashMap;
import java.util.Map;

public class Freezer implements Container{

    private Map<String, Boolean> fmap;
    private final int capacity = 0;
    private int number_items;
    private int Vacancy;

    public Freezer( int number_items, int Vacancy){
        this.number_items = number_items;
        this.Vacancy = Vacancy;
        this.fmap = new HashMap<String, Boolean>();
    }

    @Override
    public void modifyMap(String location){
        this.fmap.replace(location, false, true);
    }


    @Override
    public int getCapacity() {
        return capacity;
    }


    @Override
    public int getNumberOfItems() {
        return number_items;
    }

    @Override
    public int getVacancy() {
        return Vacancy;
    }

    @Override
    public Map<String, Boolean> generateMap() {
        return fmap;
    }

    @Override
    public String nextVacantLocation() {
        for (String location: fmap.keySet()){
            Boolean empty = fmap.get(location);
            if (empty){ return location;
            }
        }
        return null;
    }


}
