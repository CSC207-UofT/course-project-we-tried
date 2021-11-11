import org.junit.*;
import static org.junit.Assert.*;
import Entities.Item;
import Entities.User;
import UseCase.ItemManager;

import java.util.*;


public class ItemManagerTest {


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCreateItem() {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        List<String> i_info = Arrays.asList("Sender: Queenie", "Receiver: test", "Description: Test!");
        iman.createItem("test_c", i_info, "L");
        assertNotNull(iman.searchItem("test_c"));
        assertNull(iman.searchItem("test_a"));
    }

    @Test
    public void testAddItem_L() {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        User u = new User("queenie", "123456");
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        Item i = iman.createItem("test_id", i_info, "L");
        assertEquals(i.getLocation(), "");
        iman.addItem("test_id", "queenie");
        assertEquals("L01", iman.getItemMap().get("test_id").getLocation());
        assertEquals("queenie", i.getProcessor());
    }

    @Test
    public void testAddItem_R_two_item() {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        User u = new User("queenie", "123456");
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        Item i1 = iman.createItem("test_id1", i_info, "R");
        Item i2 = iman.createItem("test_id2", i_info, "R");
        iman.addItem("test_id1", "queenie");
        assertEquals("r01", i1.getLocation());
        assertEquals(i2.getLocation(), "");
        iman.addItem("test_id2", "queenie");
        assertEquals("r02", i2.getLocation());
    }

    @Test
    public void testAddItem_F() {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        User u = new User("queenie", "123456");
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        Item i = iman.createItem("test_id", i_info, "F");
        iman.addItem("test_id", "queenie");
        assertEquals("f01", i.getLocation());
    }

    @Test
    public void testAddItem_right_container_mixed() {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        User u = new User("queenie", "123456");
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        Item iL = new Item("test_id_L", i_info,"L");
        Item iF = new Item("test_id_F", i_info,"F");
        iman.addItem("test_id_L", "queenie");
        iman.addItem("test_id_F", "queenie");
        assertEquals("L01", iL.getLocation());
        assertEquals("f01", iF.getLocation());
    }

    @Test
    public void testAddItem_Full() {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        User u = new User("queenie", "123456");
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        Item i = iman.createItem("test_id", i_info, "F");
        iman.addItem("test_id", "queenie");
        assertEquals("f01", i.getLocation());
        Item o = iman.createItem("test_o", i_info, "F");
        iman.addItem("test_o", "queenie");
        assertEquals("", i.getLocation());
        assertNull(iman.searchItem("test_o"));

    }

    @Test(timeout = 50)
    public void testRemoveItem_exist_item() {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        User u = new User("test_user", "123456");
        List<String> i_info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item i = new Item("test_id", i_info, "L01", u.getUsername(),"L");
        iman.addItem("a","alan");
        assertEquals(i.getLocation(), iman.removeItem(i.getId()));
        assertNull(iman.searchItem(i.getId()));
    }

    @Test
    public void testSearchItem_no_item() {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item i = new Item("a", info, "l");
        assertNull(iman.searchItem("a"));

    }
    @Test
    public void testSearchItem_exist_item(){
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item i = new Item("a", info, "l");
        iman.addItem("a","alan");
        String location = i.getLocation();
        boolean fee = i.isFee();
        String processor = i.getProcessor();
        String line_seperator = System.lineSeparator();
        String expect = "Item:a"+line_seperator+info+line_seperator+location+line_seperator+processor+line_seperator+fee;
        assertEquals(expect,iman.searchItem("a"));
    }

}