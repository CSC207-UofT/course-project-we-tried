package Entities;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FreezerTest {

    @Test
    public void modifyContainer() {
        Map<String, Boolean> fmap = new HashMap<>(1);
        fmap.put("L01", false);
        Locker F = new Locker(1, fmap);
        F.modifyContainer("L01");
        assertTrue(F.generateMap().get("L01"));
    }

    @Test
    public void getCapacity() {
        Map<String, Boolean> fmap = new HashMap<>(2);
        fmap.put("L01", false);
        fmap.put("L02", false);
        Locker F = new Locker(2, fmap);
        assertEquals(2, F.getCapacity());
    }

    @Test
    public void getNumberOfItems() {
        Map<String, Boolean> fmap = new HashMap<>(2);
        fmap.put("L01", false);
        fmap.put("L02", false);
        Locker F = new Locker(2, fmap);
        assertEquals(0, F.getNumberOfItems());
        F.modifyContainer("L01");
        assertEquals(1, F.getNumberOfItems());
    }

    @Test
    public void getVacancy() {
        Map<String, Boolean> fmap = new HashMap<>(2);
        fmap.put("L01", false);
        fmap.put("L02", false);
        Locker F = new Locker(2, fmap);
        assertEquals(2, F.getVacancy());
        F.modifyContainer("L01");
        assertEquals(1, F.getVacancy());
    }

    @Test
    public void generateMap() {
        Map<String, Boolean> fmap = new HashMap<>(1);
        fmap.put("L01", false);
        Locker F = new Locker(1, fmap);
        assertNotNull(F.generateMap());
    }

    @Test
    public void nextVacantLocation() {
        Map<String, Boolean> fmap = new HashMap<>(3);
        fmap.put("L01", false);
        fmap.put("L02", true);
        fmap.put("L03", false);
        Locker F = new Locker(3, fmap);
        assertEquals("L01", F.nextVacantLocation());
        assertEquals("L01", F.nextVacantLocation());
    }

}