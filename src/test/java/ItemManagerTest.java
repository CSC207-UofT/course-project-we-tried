import Entities.Item;
import Entities.User;
import UseCase.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
    public void testAddItem_L() {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        User u = new User("queenie", "123456");
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        iman.addItem("test_id", i_info,"L","queenie");
        assertEquals("L01", iman.getItemMap().get("test_id").getLocation());
        assertEquals("queenie", iman.getItemMap().get("test_id").getProcessor());
    }

    @Test
    public void testAddItem_R_two_item() {
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
    public void testAddItem_F() {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        User u = new User("queenie", "123456");
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        iman.addItem("test_id", i_info, "F","queenie");
        assertEquals("f01", iman.getItemMap().get("test_id").getLocation());
    }

    @Test
    public void testAddItem_right_container_mixed() {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        User u = new User("queenie", "123456");
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        iman.addItem("test_id_L", i_info,"L","queenie");
        iman.addItem("test_id_F", i_info,"F","queenie");
        assertEquals("L01", iman.getItemMap().get("test_id_L").getLocation());
        assertEquals("f01", iman.getItemMap().get("test_id_F").getLocation());
    }

    @Test
    public void testAddItem_Full() {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        User u = new User("queenie", "123456");
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        iman.addItem("test_id", i_info, "F","queenie");
        assertEquals("f01", iman.getItemMap().get("test_id").getLocation());
        iman.addItem("test_o", i_info, "F","queenie");
        assertNull(iman.searchItem("test_o"));
    }

    @Test(timeout = 50)
    public void testRemoveItem_exist_item() {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        User u = new User("test_user", "123456");
        List<String> i_info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        iman.addItem("a",i_info,"L","alan");
        assertEquals("L01", iman.removeItem("a"));
        assertNull(iman.searchItem("a"));
    }

    @Test
    public void testSearchItem_no_item() {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item i = new Item("a", info, "L");
        assertNull(iman.searchItem("a"));

    }
    @Test
   public void testSearchItem_exist_item(){
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        User u = new User("test_user", "123456");
        String location =  iman.addItem("a", info,"L","test_user" );
        List<String> expected = new ArrayList<>(Arrays.asList("a","Sender: test_sender","Receiver: test_receiver",
                "Description: This is a test!",location, "test_user","L"));
        assertEquals(expected,iman.searchItem("a"));

    }

//    @Test
//    public void testSearchItem_exist_item(){
//        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
//        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
//        iman.addItem("a",info, "l","alan");
//        Item i = iman.getItemMap().get("a");
//        String location = i.getLocation();
//        boolean fee = i.isFee();
//        String processor = i.getProcessor();
//        String line_seperator = System.lineSeparator();
//        String expect = "Item:a"+line_seperator+info+line_seperator+location+line_seperator+processor+line_seperator+fee;
//        assertEquals(expect, iman.searchItem("a"));
//    }

}