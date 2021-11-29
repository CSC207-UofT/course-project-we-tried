package Controller;

import Entities.User;
import UseCase.ItemManager;
import UseCase.UserManager;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

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
        String location = p.storeItem("test_1", i_info, "L","alan");
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
        assertEquals(expected_info,p.search("a"));

    }

    @Test
    public void getIman(){
        PickupSystem p = new PickupSystem();
        assertTrue(p.getIman() instanceof ItemManager);
    }
    @Test
    public void getUman(){
        PickupSystem p = new PickupSystem();
        assertTrue(p.getUman() instanceof UserManager);

    }
    }