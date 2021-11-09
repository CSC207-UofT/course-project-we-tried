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
    public void testAddItem() {
    }

    @Test(timeout = 50)
    public void testRemoveItem_exist_item() {
        ItemManager iman = new ItemManager();
        User u = new User("test_user", "123456");
        List<String> i_info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item i = new Item("test_id", i_info, "L01", u.getUsername(),"L");
        iman.addItem("test_id","alan");
        assertEquals(i.getLocation(), iman.removeItem(i.getId()));
        assertNull(iman.searchItem(i.getId()));
    }

    @Test
    public void testSearchItem_no_item() {
        ItemManager iman = new ItemManager();
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item i = new Item("a", info, "l");
        assertNull(iman.searchItem("a"));

    }
    @Test
    public void testSearchItem_exist_item(){
        ItemManager iman = new ItemManager();
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item i = new Item("a", info, "l");
        ItemManager.addItem("a","alan");
        String location = i.getLocation();
        boolean fee = i.isFee();
        String processor = i.getProcessor();
        String line_seperator = System.lineSeparator();
        String expect = "Item:a"+line_seperator+info+line_seperator+location+line_seperator+processor+line_seperator+fee;
        assertEquals(expect,iman.searchItem("a"));
    }


    @Test
    public void testGetStorageTime() {
    }
}