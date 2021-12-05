package Entities;

import org.junit.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RefrigeratorTest {

    @Test
    public void refrigerator_constructor_1() throws IOException{
        Map<String, Boolean> rmap = new LinkedHashMap<>(1);
        rmap.put("r01", false);
        rmap.put("r02",false);
        Refrigerator r = new Refrigerator(2, rmap);
        assertEquals(2,r.getCapacity());
        assertEquals(2,r.getVacancy());
        assertEquals(0,r.getNumberOfItems());
    }

    @Test
    public void refrigerator_constructor_2() throws IOException{
        Map<String, Boolean> rmap = new LinkedHashMap<>(1);
        rmap.put("r01", false);
        Refrigerator r = new Refrigerator(rmap);
        assertEquals(1,r.getCapacity());
        assertEquals(1,r.getVacancy());
        assertEquals(0,r.getNumberOfItems());

    }

    @Test
    public void refrigerator_3() throws IOException{
        Map<String, Boolean> rmap = new LinkedHashMap<>(1);
        rmap.put("r01", false);
        rmap.put("ro2",true);
        Refrigerator r = new Refrigerator(rmap);
        assertEquals(2,r.getCapacity());
        assertEquals(1,r.getNumberOfItems());
        assertEquals(1, r.getVacancy());
    }

    @Test
    public void getCapacity() throws IOException {
        Map<String, Boolean> rmap = new HashMap<>(2);
        rmap.put("R01", false);
        rmap.put("R02", false);
        Locker R = new Locker(2, rmap);
        assertEquals(2, R.getCapacity());
    }

    @Test
    public void getNumberOfItems() throws IOException {
        Map<String, Boolean> rmap = new HashMap<>(2);
        rmap.put("R01", false);
        rmap.put("R02", false);
        Locker R = new Locker(2, rmap);
        assertEquals(0, R.getNumberOfItems());
        R.modifyContainerAdd("R01");
        assertEquals(1, R.getNumberOfItems());
    }

    @Test
    public void getVacancy() throws IOException {
        Map<String, Boolean> rmap = new HashMap<>(2);
        rmap.put("R01", false);
        rmap.put("R02", false);
        Locker R = new Locker(2, rmap);
        assertEquals(2, R.getVacancy());
        R.modifyContainerAdd("R01");
        assertEquals(1, R.getVacancy());
    }

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
