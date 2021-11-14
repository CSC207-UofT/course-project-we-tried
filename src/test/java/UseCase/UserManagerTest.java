package UseCase;

import UseCase.UserManager;
import Entities.User;
import Entities.Item;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserManagerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
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
        uman.record_item_processor("207project", i);
        Map<String, List<Item>> item_map = uman.getUserImap();
        assertTrue(item_map.get("207project").contains(i));
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
        assertNotNull(uman.getUMap("queenie"));
    }

    @Test
    public void getUserImap() {
        UserManager uman = new UserManager();
        uman.userRegister("queenie", "test1");
        assertNotNull(uman.getUserImap());
    }

}