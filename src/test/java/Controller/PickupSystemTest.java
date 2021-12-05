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
        assertEquals(Arrays.asList("test_1"),u.getUserImap("queenie"));
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
        assertTrue(p.getIman() instanceof ItemManager);
    }
    @Test
    public void getUman() throws IOException {
        PickupSystem p = new PickupSystem();
        assertTrue(p.getUman() instanceof UserManager);

    }
    @Test
    public void get_processor_item() throws IOException, ClassNotFoundException {
        PickupSystem p = new PickupSystem();
        UserManager u = p.getUman();
        u.userRegister("queenie", "1234");
        List<String> i_info = Arrays.asList("Sender: test_s", "Receiver: test_receiver", "Description: Test!");
        String location = p.storeItem("test_1", i_info, "L", "queenie");
        assertNotNull(u.getUserImap("queenie"));
        assertEquals(Arrays.asList("test_1"), u.getUserImap("queenie"));
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
        Map<String,String> idm_L = new LinkedHashMap<>();
        idm_r.put("R01", "id1");
        idm_r.put("R02", "id2");
        idm_f.put("F01", "id3");
        idm_L.put("L01", "id4");
        idm_L.put("L02", "id5");
        idm_L.put("L03", "id6");
        assertEquals(idm_L, p.get_package("locker"));
        assertEquals(idm_r, p.get_package("refrigerator"));
        assertEquals(idm_f, p.get_package("freezer"));
        }
}