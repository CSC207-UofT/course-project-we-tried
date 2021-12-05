package UseCase;
import Entities.Item;
import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserManagerTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void is_valid_name(){
        UserManager uman = new UserManager();
        String a = "123";
        String b = "1234";
        String c = "abcd";
        String d = "abcd12bc";
        String e = "asrae123!";
        String f = "123456789abc3";
        assertTrue(uman.is_valid_name(b));
        assertTrue(uman.is_valid_name(c));
        assertTrue(uman.is_valid_name(d));
        assertFalse(uman.is_valid_name(a));
        assertFalse(uman.is_valid_name(e));
        assertFalse(uman.is_valid_name(f));
    }

    @Test
    public void userRegister_empty() {
        UserManager uman = new UserManager();
        //assertNull(uman.lookupUser("207project"));
        assertNull(uman.lookupUser("207"));
    }

    @Test
    public void userRegister() {
        UserManager uman = new UserManager();
        uman.userRegister("207project", "test1");
        assertNotNull(uman.lookupUser("207project"));
        assertSame(uman.lookupUser("207project").getUsername(), "207project");
        assertSame(uman.lookupUser("207project").getPassword(), "test1");
    }

    @Test
    public void userDelete() {
        UserManager uman = new UserManager();
        uman.userRegister("queenie", "2077");
        assertNotNull(uman.lookupUser("queenie"));
        uman.userDelete("queenie");
        assertNull(uman.lookupUser("queenie"));
    }

    @Test
    public void lookupUser_empty() {
        UserManager uman = new UserManager();
        //assertNull(uman.lookupUser("207project"));
        assertNull(uman.lookupUser("207"));
    }

    @Test
    public void lookupUser() {
        UserManager uman = new UserManager();
        uman.userRegister("207project", "test1");
        assertNotNull(uman.lookupUser("207project"));
        assertNull(uman.lookupUser("207"));
    }

    @Test
    public void pwVerify_empty() {
        UserManager uman = new UserManager();
        assertFalse(uman.pwVerify("", ""));
        assertFalse(uman.pwVerify("207project", "test1"));
        assertFalse(uman.pwVerify("project", "test2"));
    }

    @Test
    public void pwVerify() {
        UserManager uman = new UserManager();
        uman.userRegister("pprojectt", "test2");
        assertTrue(uman.pwVerify("pprojectt", "test2"));
        assertFalse(uman.pwVerify("pprojectt", ""));
        assertFalse(uman.pwVerify("project", "test2"));
    }

    @Test
    public void record_item_processor() {
        UserManager uman = new UserManager();
        uman.userRegister("207project", "test1");
        List<String> i_info = Arrays.asList("Sender: t_sender", "Receiver: t_receiver", "Description: !");
        Item i = new Item("test_i1", i_info,"F");
        uman.record_item_processor("207project", "test_i1");
        ArrayList<String> item_map = uman.getUserImap("207project");
        assertEquals(Arrays.asList("test_i1"), item_map);
        assertTrue(item_map.contains("test_i1"));
    }

    @Test
    public void recordUser() {
        UserManager uman = new UserManager();
        uman.userRegister("queenie", "test1");
        assertNotNull(uman.RecordUser("queenie"));
        assertEquals(uman.getCurrentUser().getUsername(), "queenie");
    }

    @Test
    public void recordUser_null() {
        UserManager uman = new UserManager();
        uman.userRegister("queenie", "test1");
        uman.RecordUser(null);
        assertNull(uman.getCurrentUser());
    }

    @Test
    public void getUMap() {
        UserManager uman = new UserManager();
        uman.userRegister("queenie", "test1");
        assertNotNull(uman.getUMap());
    }

    @Test
    public void getUserImap() {
        UserManager uman = new UserManager();
        uman.userRegister("queenie", "test1");
        assertNotNull(uman.getUserImap("queenie"));
    }


   @Test
    public void get_processor_item(){

   }
}