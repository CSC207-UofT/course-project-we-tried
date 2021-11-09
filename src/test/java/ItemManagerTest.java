import org.junit.*;
import static org.junit.Assert.*;
import Entities.Item;
import Entities.User;
import UseCase.ItemManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ItemManagerTest {


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddItem() {
        ItemManager iman = new ItemManager();
        User u = new User("test_user", "123456");
        List<String> i_info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: Test!");
        Item i = new Item("test_id", i_info, "L01", u.getUsername(),"L");
        iman.addItem(i);
        assertEquals(iman.searchItem(i.getId()), i.toString());
    }

    @Test
    public void testAddItem_right_container() {
        ItemManager iman = new ItemManager();
        User u = new User("test_user", "123456");
        List<String> i_info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: Test!");
        Item i = new Item("test_id", i_info,"L");
        assertEquals(i.getLocation(), "");
        iman.addItem(i);
        assertNotNull(i.getLocation());
    }

    @Test(timeout = 50)
    public void testRemoveItem_exist_item() {
        ItemManager iman = new ItemManager();
        User u = new User("test_user", "123456");
        List<String> i_info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: Test!");
        Item i = new Item("test_id", i_info, "L01", u.getUsername(),"L");
        iman.addItem(i);
        assertEquals(i.getLocation(), iman.removeItem(i.getId()));
        assertNull(iman.searchItem(i.getId()));
    }

    @Test
    public void testSearchItem() {
    }

    @Test
    public void testGetStorageTime() {
    }
}