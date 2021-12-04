package UseCase;

import Entities.Item;
import Entities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class ItemManagerTest {


    private ItemStorer storer = new ItemStorer();
    private ItemSearcher searcher = new ItemSearcher();
    private ItemPicker picker = new ItemPicker();
    private ItemTimer timer = new ItemTimer();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddItem_L() throws IOException {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        User u = new User("queenie", "123456");
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        try {
            iman.addItem("test_id", i_info,"L","queenie");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("L01", iman.getItemMap().get("test_id").getLocation());
        assertEquals("queenie", iman.getItemMap().get("test_id").getProcessor());
    }

    @Test
    public void testAddItem_R_two_item() throws IOException {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        User u = new User("queenie", "123456");
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        iman.addItem("test_id1",i_info,"R", "queenie");
        assertEquals("r01", iman.getItemMap().get("test_id1").getLocation());
        assertEquals("queenie", iman.getItemMap().get("test_id1").getProcessor());
        iman.addItem("test_id2",i_info,"R", "queenie");
        assertEquals("r02", iman.getItemMap().get("test_id2").getLocation());
        assertEquals("queenie", iman.getItemMap().get("test_id2").getProcessor());
    }

    @Test
    public void testAddItem_F() throws IOException {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        User u = new User("queenie", "123456");
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        iman.addItem("test_id", i_info, "F","queenie");
        assertEquals("f01", iman.getItemMap().get("test_id").getLocation());
    }

    @Test
    public void testAddItem_right_container_mixed() throws IOException {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        User u = new User("queenie", "123456");
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        iman.addItem("test_id_L", i_info,"L","queenie");
        iman.addItem("test_id_F", i_info,"F","queenie");
        assertEquals("L01", iman.getItemMap().get("test_id_L").getLocation());
        assertEquals("f01", iman.getItemMap().get("test_id_F").getLocation());
    }

    @Test
    public void testAddItem_Full() throws IOException {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        User u = new User("queenie", "123456");
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        iman.addItem("test_id", i_info, "F","queenie");
        assertEquals("f01", iman.getItemMap().get("test_id").getLocation());
        iman.addItem("test_o", i_info, "F","queenie");
        assertNull(iman.searchItem("test_o"));
    }

    @Test
    public void testAddItem_repetitive() throws IOException {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        User u = new User("jane", "123456");
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        iman.addItem("test_id", i_info, "L","jane");
        assertEquals("L01", iman.getItemMap().get("test_id").getLocation());
        assertEquals("*", iman.addItem("test_id", i_info, "F","jane"));
    }


    @Test(timeout = 10000)
    public void testRemoveItem_exist_item() throws IOException {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        User u = new User("test_user", "123456");
        List<String> i_info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        iman.addItem("a",i_info,"L","alan");
        assertEquals("L01", iman.removeItem("a"));
        List<String> result = iman.searchItem("a");
        assertNull(iman.searchItem("a"));
    }

    @Test
    public void testSearchItem_no_item() throws IOException {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item i = new Item("a", info, "L");
        assertNull(iman.searchItem("a"));

    }
    @Test
   public void testSearchItem_exist_item() throws IOException {
        Calendar t_start = Calendar.getInstance();
        int month_1 = t_start.get(Calendar.MONTH)+1;
        String s_1 = t_start.get(Calendar.YEAR) + "/" + month_1 + "/" + t_start.get(Calendar.DATE);

        Calendar t_fee = Calendar.getInstance();
        t_fee.add(Calendar.DATE,2);
        int month_2 = t_fee.get(Calendar.MONTH)+1;
        String s_2 = t_fee.get(Calendar.YEAR) + "/" + month_2 + "/" + t_fee.get(Calendar.DATE);

        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        User u = new User("test_user", "123456");
        String location =  iman.addItem("a", info,"L","test_user" );
        List<String> expected = new ArrayList<>(Arrays.asList("a","Sender: test_sender","Receiver: test_receiver",
                "Description: This is a test!",location, "test_user","L", s_1, s_2,"0"));
        assertEquals(expected,iman.searchItem("a"));

    }

}