package Entities;

import org.junit.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RefrigeratorTest {

    @Test
    public void nextVacantLocation_no_location() throws IOException {
        Map<String, Boolean> rmap = new HashMap<String, Boolean>();
        Refrigerator r = new Refrigerator(3,rmap);
        Map<String, Boolean> p = r.generateMap();
        p.put("a",true);
        p.put("b",true);
        p.put("c",true);
        assertNull(r.nextVacantLocation());
    }

    @Test
    public void nextVacantLocation_exists_location_at_first() throws IOException {
        Map<String, Boolean> rmap = new HashMap<String, Boolean>();
        Refrigerator r = new Refrigerator(3,rmap);
        Map<String, Boolean> p = r.generateMap();
        p.put("a",false);
        p.put("b",true);
        p.put("c",true);
        assertEquals("a", r.nextVacantLocation());


    }

    @Test
    public void nextVacantLocation_exists_location_at_end() throws IOException {
        Map<String, Boolean> rmap = new HashMap<String, Boolean>();
        Refrigerator r = new Refrigerator(3,rmap);
        Map<String, Boolean> p = r.generateMap();
        p.put("a",true);
        p.put("b",true);
        p.put("c",false);
        assertEquals("c", r.nextVacantLocation());
    }

    @Test
    public void getNumberOfItems() throws IOException {
        Map<String, Boolean> rmap = new HashMap<>(2);
        rmap.put("R01", false);
        rmap.put("R02", false);
        Refrigerator R = new Refrigerator(2, rmap);
        assertEquals(0, R.getNumberOfItems());
        R.modifyContainerAdd("F01");
        assertEquals(1, R.getNumberOfItems());
    }

    @Test
    public void getVacancy() throws IOException {
        Map<String, Boolean> rmap = new HashMap<>(2);
        rmap.put("R01", false);
        rmap.put("R02", false);
        Refrigerator R = new Refrigerator(2, rmap);
        assertEquals(2, R.getVacancy());
        R.modifyContainerAdd("R01");
        assertEquals(1, R.getVacancy());
    }

    @Test
    public void nextVacantLocation_exists_location_at_middle() throws IOException {
        Map<String, Boolean> rmap = new HashMap<String, Boolean>();
        Refrigerator r = new Refrigerator(3,rmap);
        Map<String, Boolean> p = r.generateMap();
        p.put("a",true);
        p.put("b",false);
        p.put("c",true);
        assertEquals("b", r.nextVacantLocation());
    }
}
