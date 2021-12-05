package Entities;

import org.junit.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FreezerTest {

    @Test
    public void freezer_constructor_1() throws IOException{
        Map<String, Boolean> fmap = new LinkedHashMap<>(1);
        fmap.put("f01", false);
        fmap.put("f02",false);
        Freezer f = new Freezer(2, fmap);
        assertEquals(2,f.getCapacity());
        assertEquals(2,f.getVacancy());
        assertEquals(0,f.getNumberOfItems());
    }

    @Test
    public void freezer_constructor_2() throws IOException{
        Map<String, Boolean> fmap = new LinkedHashMap<>(1);
        fmap.put("f01", false);
        Freezer f = new Freezer(fmap);
        assertEquals(1,f.getCapacity());
        assertEquals(1,f.getVacancy());
        assertEquals(0,f.getNumberOfItems());
    }

    @Test
    public void freezer_3() throws IOException{
        Map<String, Boolean> fmap = new LinkedHashMap<>(1);
        fmap.put("f01", false);
        fmap.put("fo2",true);
        Freezer f = new Freezer(fmap);
        assertEquals(2,f.getCapacity());
        assertEquals(1,f.getNumberOfItems());
        assertEquals(1, f.getVacancy());
    }



    @Test
    public void modifyContainer() throws IOException {
        Map<String, Boolean> fmap = new HashMap<>(1);
        fmap.put("L01", false);
        Locker F = new Locker(1, fmap);
        F.modifyContainerAdd("L01");
        assertTrue(F.generateMap().get("L01"));
    }

    @Test
    public void getCapacity() throws IOException {
        Map<String, Boolean> fmap = new HashMap<>(2);
        fmap.put("F01", false);
        fmap.put("F02", false);
        Freezer F = new Freezer(2, fmap);
        assertEquals(2, F.getCapacity());
    }

    @Test
    public void getNumberOfItems() throws IOException {
        Map<String, Boolean> fmap = new HashMap<>(2);
        fmap.put("F01", false);
        fmap.put("F02", false);
        Freezer F = new Freezer(2, fmap);
        assertEquals(0, F.getNumberOfItems());
        F.modifyContainerAdd("F01");
        assertEquals(1, F.getNumberOfItems());
    }


    @Test
    public void getVacancy() throws IOException {
        Map<String, Boolean> fmap = new HashMap<>(2);
        fmap.put("L01", false);
        fmap.put("L02", false);
        Freezer F = new Freezer(2, fmap);
        assertEquals(2, F.getVacancy());
        F.modifyContainerAdd("L01");
        assertEquals(1, F.getVacancy());
    }

    @Test
    public void generateMap() throws IOException {
        Map<String, Boolean> fmap = new HashMap<>(1);
        fmap.put("L01", false);
        Freezer F = new Freezer(1, fmap);
        assertNotNull(F.generateMap());
    }

    @Test
    public void nextVacantLocation() throws IOException {
        Map<String, Boolean> fmap = new HashMap<>(3);
        fmap.put("L01", false);
        fmap.put("L02", true);
        fmap.put("L03", false);
        Freezer F = new Freezer(3, fmap);
        assertEquals("L01", F.nextVacantLocation());
        assertEquals("L01", F.nextVacantLocation());
    }


}