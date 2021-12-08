package UseCase;

import Entities.Freezer;
import Entities.Item;
import Entities.Locker;
import Entities.Refrigerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

public class ItemPickerTest {

    private Item il;
    private Item ir;
    private Item ifr;
    private Item bad;
    private ItemPicker ip;


    @Before
    public void setUp1() throws Exception {
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        il = new Item("a", info, "L");
        ir = new Item("b", info, "R");
        ifr = new Item("c", info, "F");
        bad = new Item("d", info, "E");
        ip = new ItemPicker();
        Map<String, Boolean> fmap = new LinkedHashMap<>(1);
        fmap.put("f01", false);
        Freezer f = new Freezer(1,fmap);
        Map<String, Boolean> rmap = new LinkedHashMap<>(2);
        rmap.put("r01", false);
        rmap.put("r02", false);
        Refrigerator r = new Refrigerator(2, rmap);
        Map<String, Boolean> lmap = new LinkedHashMap<>(3);
        lmap.put("L01", false);
        lmap.put("L02", false);
        lmap.put("L03", false);
        Locker l = new Locker(3, lmap);
        Map<String, Item> imap = new HashMap<>();
        imap.put("a", il);
        imap.put("b", ir);
        imap.put("c", ifr);
        imap.put("d", bad);
        il.setLocation("L01");
        ir.setLocation("r01");
        ifr.setLocation("f01");
        ip.Imap = imap;
        ip.L = l;
        ip.F = f;
        ip.R = r;


    }

    @After
    public void tearDown() {
       il =null;
       ir = null;
       ifr = null;
       bad = null;
       ip = null;
    }

    @Test
    public void findContainer_L() {
        ip.findContainer(il);
        assertTrue(ip.c instanceof Locker);

    }

    @Test
    public void findContainer_R() {
        ip.findContainer(ir);
        assertTrue(ip.c instanceof Refrigerator);

    }

    @Test
    public void findContainer_F() {
        ip.findContainer(ifr);
        assertTrue(ip.c instanceof Freezer);

    }

    @Test
    public void findContainer_null() {
        ip.findContainer(bad);
        assertNull(ip.c);

    }

    @Test
    public void setup() throws IOException {
        Map<String, Item> imap = new HashMap<>();
        Map<String, Boolean> fmap = new LinkedHashMap<>(2);
        Freezer f = new Freezer(2,fmap);
        Map<String, Boolean> rmap = new LinkedHashMap<>(3);
        Refrigerator r = new Refrigerator(3, rmap);
        Map<String, Boolean> lmap = new LinkedHashMap<>(4);
        Locker l = new Locker(4, lmap);
        ip.setup(imap,l,f,r);
        assertEquals(ip.L.getCapacity(), 4);
        assertEquals(ip.F.getCapacity(),2);
        assertEquals(ip.R.getCapacity(),3);
        assertTrue(ip.Imap instanceof  HashMap);
    }

    @Test
    public void remove_L() {
        String location = ip.remove("a");
        assertEquals(location, "L01");
    }

    @Test
    public void remove_R() {
        String location = ip.remove("b");
        assertEquals(location, "r01");
    }

    @Test
    public void remove_F() {
        String location = ip.remove("c");
        assertEquals(location, "f01");
    }

    @Test
    public void remove_null() {
        assertNull(ip.remove("g"));
    }

}