package UseCase;

import Entities.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

public class ItemStorerTest {
    private Item il;
    private Item ir;
    private Item ifr;
    private Item bad;
    private ItemStorer istore;

    @Before
    public void setUp1() throws Exception {
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        il = new Item("a", info, "L");
        ir = new Item("b", info, "R");
        ifr = new Item("c", info, "F");
        bad = new Item("d", info, "E");
        istore = new ItemStorer();
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
        Map<String, Item> imap = new HashMap<String, Item>();
        imap.put("a", il);
        imap.put("b", ir);
        imap.put("c", ifr);
        imap.put("d", bad);
        istore.Imap = imap;
        istore.L = l;
        istore.F = f;
        istore.R = r;
    }

    @After
    public void tearDown() throws Exception {
        il =null;
        ir = null;
        ifr = null;
        bad = null;
        istore = null;
    }

    @Test
    public void setup() {
        Map<String, Item> imap = new HashMap<String, Item>();
        Map<String, Boolean> fmap = new LinkedHashMap<>(2);
        Freezer f = new Freezer(2,fmap);
        Map<String, Boolean> rmap = new LinkedHashMap<>(3);
        Refrigerator r = new Refrigerator(3, rmap);
        Map<String, Boolean> lmap = new LinkedHashMap<>(4);
        Locker l = new Locker(4, lmap);
        istore.setup(imap,l,f,r);
        assertEquals(istore.L.getCapacity(), 4);
        assertEquals(istore.F.getCapacity(),2);
        assertEquals(istore.R.getCapacity(),3);
        assertTrue(istore.Imap instanceof  HashMap);
    }

    @Test
    public void findContainer_L() {
        istore.findContainer(il);
        assertTrue(istore.c instanceof Locker);

    }

    @Test
    public void findContainer_R() {
        istore.findContainer(ir);
        assertTrue(istore.c instanceof Refrigerator);

    }

    @Test
    public void findContainer_F() {
        istore.findContainer(ifr);
        assertTrue(istore.c instanceof Freezer);

    }

    @Test
    public void findContainer_null() {
        istore.findContainer(bad);
        assertNull(istore.c);
    }

    @Test
    public void create_success() {
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item i = istore.create("i", info, "L");
        assertEquals(i.getId(), "i");
        assertEquals(istore.Imap.get("i"), i);


    }

    @Test
    public void create_fail() {
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item i = istore.create("a", info, "L");
        assertNull(i);
    }

    @Test
    public void add_success_L() throws IOException {
        User alan = new User("Alan", "1234");
        String location = istore.add("a","Alan");
        assertEquals(location, "L01");
        assertEquals(il.getLocation(), "L01");
        assertEquals(il.getProcessor(), "Alan");
    }

    @Test
    public void add_success_R() throws IOException {
        User alan = new User("Alan", "1234");
        String location = istore.add("b","Alan");
        assertEquals(location, "r01");
        assertEquals(ir.getLocation(), "r01");
        assertEquals(ir.getProcessor(), "Alan");
    }

    @Test
    public void add_success_F() throws IOException {
        User alan = new User("Alan", "1234");
        String location = istore.add("c","Alan");
        assertEquals(location, "f01");
        assertEquals(ifr.getLocation(), "f01");
        assertEquals(ifr.getProcessor(), "Alan");
    }

    @Test
    public void add_fail_wrong_item() throws IOException{
        User alan = new User("Alan", "1234");
        String location = istore.add("d","Alan");
        assertNull(location);
        assertNull(istore.Imap.get("d"));
    }


    @Test
    public void add_fail_no_space() throws IOException{
        User alan = new User("Alan", "1234");
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item ifr2 = new Item("j", info, "F");
        istore.Imap.put("j", ifr2);
        assertNotNull(istore.Imap.get("j"));
        istore.add("c","Alan");
        assertNotNull(istore.Imap.get("c"));
        assertNull(istore.add("j", "Alan"));
        assertNull(istore.Imap.get("j"));
    }


}