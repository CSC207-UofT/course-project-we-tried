package UseCase;

import Entities.Item;
import Entities.Locker;
import Entities.Refrigerator;
import Entities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;


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

    @Test
    public void reload() throws IOException {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        Map<String, Boolean> rmap = new LinkedHashMap<>(1);
        rmap.put("r01", false);
        Refrigerator r = new Refrigerator(2, rmap);
        Map<String, Boolean> lmap = new LinkedHashMap<>(1);
        lmap.put("L01", false);
        Map<String, Boolean> fmap = new LinkedHashMap<>(1);
        fmap.put("f01",false);
        iman.reload(lmap, fmap, rmap);
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        iman.addItem("test_1", i_info, "L","jane");
        iman.addItem("test_2", i_info, "R","jane");
        iman.addItem("test_3", i_info, "F","jane");
        iman.addItem("test_4", i_info, "L","jane");
        iman.addItem("test_5", i_info, "R","jane");
        iman.addItem("test_6", i_info, "F","jane");
        assertEquals(3, iman.getItemMap().size());
    }

    @Test
    public void getItemMap() throws IOException {
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        assertEquals(0, iman.getItemMap().size());
    }

    @Test
    public void checkFee() throws IOException {
        Calendar t_start = Calendar.getInstance();
        int month_1 = t_start.get(Calendar.MONTH)+1;
        String s_1 = t_start.get(Calendar.YEAR) + "/" + month_1 + "/" + t_start.get(Calendar.DATE);

        Calendar t_fee = Calendar.getInstance();
        t_fee.add(Calendar.DATE,2);
        int month_2 = t_fee.get(Calendar.MONTH)+1;
        String s_2 = t_fee.get(Calendar.YEAR) + "/" + month_2 + "/" + t_fee.get(Calendar.DATE);

        Calendar t = Calendar.getInstance();
        t.add(Calendar.DATE,1);
        int month_3 = t.get(Calendar.MONTH)+1;
        String s_3 = t.get(Calendar.YEAR) + "/" + month_3 + "/" + t.get(Calendar.DATE);

        ItemManager i = new ItemManager(storer, searcher, picker, timer);
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        i.addItem("id1",i_info,"L", "queenie");
        i.addItem("id2",i_info,"F", "queenie");
        ArrayList<String> id1 = new ArrayList<String>(Arrays.asList(s_1, s_2, "0"));
        ArrayList<String> id2 = new ArrayList<String>(Arrays.asList(s_1, s_3, "0"));
        assertEquals(id1, i.checkFee("id1"));
        assertEquals(id2, i.checkFee("id2"));
    }

    @Test
    public void get_package_id() throws IOException {
        ItemManager i = new ItemManager(storer, searcher, picker, timer);
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        i.addItem("id1",i_info,"R", "queenie");
        i.addItem("id2",i_info,"R", "queenie");
        i.addItem("id3",i_info,"F", "queenie");
        i.addItem("id4",i_info,"L", "queenie");
        i.addItem("id5",i_info,"L", "queenie");
        i.addItem("id6",i_info,"L", "queenie");
        ArrayList<String> r_list = new ArrayList<String>(Arrays.asList("id1","id2"));
        ArrayList<String> f_list = new ArrayList<String>(Arrays.asList("id3"));
        ArrayList<String> L_list = new ArrayList<String>(Arrays.asList("id4","id5","id6"));
        assertEquals(L_list, i.get_package_id("locker"));
        assertEquals(r_list, i.get_package_id("refrigerator"));
        assertEquals(f_list, i.get_package_id("freezer"));

    }
}