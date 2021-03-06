package Controller;

import Entities.User;
import UseCase.ItemManager;
import UseCase.UserManager;
import org.junit.Test;
import java.io.IOException;
import java.util.*;
import static org.junit.Assert.*;
public class PickupSystemTest {

    @Test
    public void pickupsystem() throws IOException{
        PickupSystem p = new PickupSystem();
        assertNotNull(p.getIman());
    }

    @Test
    public void pickupsystem_2() throws IOException{
        UserManager u = new UserManager();
        ItemManager i = new ItemManager();
        PickupSystem p = new PickupSystem(i,u);
        assertEquals(p.getIman(), i);
        assertEquals(p.getUman(), u);

    }


    @Test
    public void pickup_successful() throws IOException, ClassNotFoundException {
        PickupSystem p = new PickupSystem();
        ItemManager i = p.getIman();
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        i.addItem("test_id1",i_info,"R", "queenie");
        p.pickup("test_id1");
        assertNull(i.searchItem("test_id1"));
    }
    @Test
    public void pickup_wrong_item() throws IOException, ClassNotFoundException {
        PickupSystem p = new PickupSystem();
        ItemManager i = p.getIman();
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        i.addItem("test_id1",i_info,"R", "queenie");
        p.pickup("a");
        assertNull(i.searchItem("a"));

    }
    @Test
    public void storeItem_successful() throws IOException, ClassNotFoundException {
        PickupSystem p = new PickupSystem();
        UserManager u = p.getUman();
        u.userRegister("alan", "1234");
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        String location = p.storeItem("test_id1", i_info, "L","alan");
        assertEquals("L01",location);
    }

    @Test
    public void storeItem_user_item_successful() throws IOException, ClassNotFoundException {
        PickupSystem p = new PickupSystem();
        UserManager u = p.getUman();
        u.userRegister("queenie", "1234");
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        String location = p.storeItem("test_1", i_info, "L","queenie");
        assertNotNull(u.getUserImap("queenie"));
        assertEquals(List.of("test_1"),u.getUserImap("queenie"));
        assertEquals("L01",location);
    }


    @Test
    public void search() throws IOException {
        Calendar t_start = Calendar.getInstance();
        int month_1 = t_start.get(Calendar.MONTH)+1;
        String s_1 = t_start.get(Calendar.YEAR) + "/" + month_1 + "/" + t_start.get(Calendar.DATE);

        Calendar t_fee = Calendar.getInstance();
        t_fee.add(Calendar.DATE,2);
        int month_2 = t_fee.get(Calendar.MONTH)+1;
        String s_2 = t_fee.get(Calendar.YEAR) + "/" + month_2 + "/" + t_fee.get(Calendar.DATE);

        PickupSystem p = new PickupSystem();
        ItemManager i = p.getIman();
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        User u = new User("test_user", "123456");
        String location =  i.addItem("a", info,"L","test_user" );
        List<String> expected_info = new ArrayList<>(Arrays.asList("a","Sender: test_sender","Receiver: test_receiver",
                "Description: This is a test!",location, "test_user","L",s_1, s_2,"0"));
        List<String> actual = p.search("a");
        assertEquals(expected_info,p.search("a"));

    }

    @Test
    public void getIman() throws IOException {
        PickupSystem p = new PickupSystem();
        assertTrue(p.getIman() != null);
    }
    @Test
    public void getUman() throws IOException {
        PickupSystem p = new PickupSystem();
        assertTrue(p.getUman() != null);

    }
    @Test
    public void get_processor_item() throws IOException, ClassNotFoundException {
        PickupSystem p = new PickupSystem();
        UserManager u = p.getUman();
        u.userRegister("queenie", "1234");
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        String location = p.storeItem("test_1", i_info, "L", "queenie");
        assertNotNull(u.getUserImap("queenie"));
        assertEquals(List.of("test_1"), u.getUserImap("queenie"));
        assertEquals(List.of("test_1"), p.get_processor_item("queenie"));
        assertEquals("L01", location);
    }

    @Test
    public void get_package_id() throws IOException, ClassNotFoundException {
        PickupSystem p = new PickupSystem();
        ItemManager i = p.getIman();
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        i.addItem("id1",i_info,"R", "queenie");
        i.addItem("id2",i_info,"R", "queenie");
        i.addItem("id3",i_info,"F", "queenie");
        i.addItem("id4",i_info,"L", "queenie");
        i.addItem("id5",i_info,"L", "queenie");
        i.addItem("id6",i_info,"L", "queenie");
        Map<String,String> idm_r = new LinkedHashMap<>();
        Map<String,String> idm_f = new LinkedHashMap<>();
        Map<String,String> idm_l = new LinkedHashMap<>();
        for(int x = 1; x <= 6; x=x+1){
            String loc = "F"+"0" + x;
            idm_f.put(loc,null);
        }
        for(int x = 1; x <= 12; x=x+1) {
            String loc = null;
            if (x <= 9) {
                loc = "R" + "0" + x;
            } else {
                loc = "R" + x;
            }
            idm_r.put(loc,null);
        }
        for (int x = 1; x <= 15; x = x + 1) {
            String loc = null;
            if (x <= 9) {
                loc = "L" + "0" + x;
            } else {
                loc = "L" + x;
            }
            idm_l.put(loc,null);
        }
        idm_r.put("R01", "id1");
        idm_r.put("R02", "id2");
        idm_f.put("F01", "id3");
        idm_l.put("L01", "id4");
        idm_l.put("L02", "id5");
        idm_l.put("L03", "id6");
        assertEquals(idm_l, i.get_package_id("locker"));
        assertEquals(idm_r, i.get_package_id("refrigerator"));
        assertEquals(idm_f, i.get_package_id("freezer"));
        idm_r.replace("R01", null);
        i.removeItem("id1");
        i.get_package_id("refrigerator");
        assertEquals(idm_r, p.get_package("refrigerator"));
        assertEquals(idm_l, p.get_package("locker"));
        assertEquals(idm_f, p.get_package("freezer"));
        }

    @Test
    public void testGet_processor_item() throws IOException, ClassNotFoundException {
        PickupSystem p = new PickupSystem();
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        String location = p.storeItem("test_id1", i_info, "L","alan");
        UserManager u = new UserManager();
        ArrayList<String> a = new ArrayList<>();
        a.add("test_id1");
        assertEquals(a, p.get_processor_item("alan"));
    }
}