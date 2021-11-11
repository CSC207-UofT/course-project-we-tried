package Entities;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RefrigeratorTest {

    @Test
    public void nextVacantLocation_no_location() {
        Refrigerator r = new Refrigerator(3,3);
        Map<String, Boolean> p = r.generateMap();
        p.put("a",false);
        p.put("b",false);
        p.put("c",false);
        assertNull(r.nextVacantLocation());
    }

    @Test
    public void nextVacantLocation_exists_location_at_first() {
        Refrigerator r = new Refrigerator(3,3);
        Map<String, Boolean> p = r.generateMap();
        p.put("a",true);
        p.put("b",false);
        p.put("c",false);
        assertEquals("a", r.nextVacantLocation());


    }

    @Test
    public void nextVacantLocation_exists_location_at_end() {
        Refrigerator r = new Refrigerator(3,3);
        Map<String, Boolean> p = r.generateMap();
        p.put("a",false);
        p.put("b",false);
        p.put("c",true);
        assertEquals("c", r.nextVacantLocation());


    }

    @Test
    public void nextVacantLocation_exists_location_at_middle() {
        Refrigerator r = new Refrigerator(3,3);
        Map<String, Boolean> p = r.generateMap();
        p.put("a",false);
        p.put("b",true);
        p.put("c",false);
        assertEquals("b", r.nextVacantLocation());
    }
}
