package Entities;

import org.junit.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LockerTest {

    @Test
    public void locker_constructor_1() throws IOException{
        Map<String, Boolean> lmap = new LinkedHashMap<>(1);
        lmap.put("f01", false);
        lmap.put("f02",false);
        Locker l = new Locker(2, lmap);
        assertEquals(2,l.getCapacity());
        assertEquals(2,l.getVacancy());
        assertEquals(0,l.getNumberOfItems());
    }

    @Test
    public void locker_constructor_2() {
        Map<String, Boolean> lmap = new LinkedHashMap<>(1);
        lmap.put("f01", false);
        Locker l = new Locker(lmap);
        assertEquals(1,l.getCapacity());
        assertEquals(1,l.getVacancy());
        assertEquals(0,l.getNumberOfItems());
    }

    @Test
    public void locker_3() {
        Map<String, Boolean> lmap = new LinkedHashMap<>(1);
        lmap.put("l01", false);
        lmap.put("lo2",true);
        Locker l = new Locker(lmap);
        assertEquals(2,l.getCapacity());
        assertEquals(1,l.getNumberOfItems());
        assertEquals(1, l.getVacancy());
    }


    @Test
    public void modifyContainer() throws IOException {
        Map<String, Boolean> lmap = new HashMap<>(1);
        lmap.put("L01", false);
        Locker L = new Locker(1, lmap);
        L.modifyContainerAdd("L01");
        assertTrue(L.generateMap().get("L01"));
    }

    @Test
    public void getCapacity() throws IOException {
        Map<String, Boolean> lmap = new HashMap<>(2);
        lmap.put("L01", false);
        lmap.put("L02", false);
        Locker L = new Locker(2, lmap);
        assertEquals(2, L.getCapacity());
    }

    @Test
    public void getNumberOfItems() throws IOException {
        Map<String, Boolean> lmap = new HashMap<>(2);
        lmap.put("L01", false);
        lmap.put("L02", false);
        Locker L = new Locker(2, lmap);
        assertEquals(0, L.getNumberOfItems());
        L.modifyContainerAdd("L01");
        assertEquals(1, L.getNumberOfItems());
    }

    @Test
    public void getVacancy() throws IOException {
        Map<String, Boolean> lmap = new HashMap<>(2);
        lmap.put("L01", false);
        lmap.put("L02", false);
        Locker L = new Locker(2, lmap);
        assertEquals(2, L.getVacancy());
        L.modifyContainerAdd("L01");
        assertEquals(1, L.getVacancy());
    }

    @Test
    public void nextVacantLocation() throws IOException {
        Map<String, Boolean> lmap = new HashMap<>(2);
        lmap.put("L01", false);
        lmap.put("L02", false);
        Locker L = new Locker(2, lmap);
        assertEquals("L01", L.nextVacantLocation());
    }

    @Test
    public void nextVacantLocation_not_first() throws IOException {
        Map<String, Boolean> lmap = new HashMap<>(2);
        lmap.put("L01", true);
        lmap.put("L02", false);
        Locker L = new Locker(2, lmap);
        assertEquals("L02", L.nextVacantLocation());
    }

    @Test
    public void nextVacantLocation_not_change() throws IOException {
        Map<String, Boolean> lmap = new HashMap<>(3);
        lmap.put("L01", false);
        lmap.put("L02", true);
        lmap.put("L03", false);
        Locker L = new Locker(3, lmap);
        assertEquals("L01", L.nextVacantLocation());
        assertEquals("L01", L.nextVacantLocation());
    }

    @Test
    public void generateMap() throws IOException {
        Map<String, Boolean> lmap = new HashMap<>(1);
        lmap.put("L01", false);
        Locker L = new Locker(1, lmap);
        assertNotNull(L.generateMap());
    }

}