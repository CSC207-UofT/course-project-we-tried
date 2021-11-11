package Entities;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LockerTest {

    @Test
    public void nextVacantLocation() {
        Map<String, Boolean> lmap = new HashMap<>(2);
        lmap.put("L01", false);
        lmap.put("L02", false);
        Locker L = new Locker(2, lmap);
        assertEquals("L01", L.nextVacantLocation());
    }

    @Test
    public void nextVacantLocation_not_first() {
        Map<String, Boolean> lmap = new HashMap<>(2);
        lmap.put("L01", true);
        lmap.put("L02", false);
        Locker L = new Locker(2, lmap);
        assertEquals("L02", L.nextVacantLocation());
    }

    @Test
    public void nextVacantLocation_not_change() {
        Map<String, Boolean> lmap = new HashMap<>(3);
        lmap.put("L01", false);
        lmap.put("L02", true);
        lmap.put("L03", false);
        Locker L = new Locker(3, lmap);
        assertEquals("L01", L.nextVacantLocation());
        assertEquals("L01", L.nextVacantLocation());
    }
}