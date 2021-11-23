package Controller;

import Entities.User;
import UseCase.UserManager;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LoginControllerTest {

    @Test
    public void user(){
        LoginController log = new LoginController();
        UserManager u = log.getUman();
        Map<String, User> m = u.getUMap("al");
    }

    @Test
    public void userLogin_successful() throws IOException {
        LoginController log = new LoginController();
        UserManager u = log.getUman();
        Map<String, User> m = u.getUMap("al");
        log.userRegister("alan", "abc");
        assertTrue(log.userLogin("alan", "abc"));
        assertEquals("alan",log.getCurrentUser());
        assertEquals("alan", log.getUman().getCurrentUser().getUsername());

    }

    @Test
    public void userLogin_fail_wrong_password() throws IOException {
        LoginController log = new LoginController();
        log.userRegister("alan", "abc");
        assertFalse(log.userLogin("alan", "ab"));
    }

    @Test
    public void userLogin_fail_wrong_user() throws IOException {
        LoginController log = new LoginController();
        log.userRegister("alan", "abc");
        assertFalse(log.userLogin("ala", "abc"));
    }

    @Test
    public void userRegister_successful() throws IOException {
        LoginController log = new LoginController();
        UserManager u = log.getUman();
        Map<String, User> m = u.getUMap("alan");
        Boolean a = log.userRegister("alan","abc");
        assertTrue(a);

    }

    @Test
    public void userRegister_fail() throws IOException {
        LoginController log = new LoginController();
        UserManager u = log.getUman();
        u.userRegister("alan", "123");
        assertFalse(log.userRegister("alan", "abc"));

    }

    @Test
    public void userRegister_fail_name() throws IOException {
        LoginController log = new LoginController();
        UserManager u = log.getUman();
        u.userRegister("ala", "123");
        assertFalse(log.userRegister("ala", "abc"));
    }

    @Test
    public void userLogout_has_current_user() throws IOException {
        LoginController log = new LoginController();
        log.userRegister("alan", "abc");
        log.userLogin("alan", "abc");
        assertTrue(log.userLogout());
        assertEquals("",log.getCurrentUser());
        assertNull(log.getUman().getCurrentUser());
    }

    @Test
    public void userLogout_has_no_current_user() {
        LoginController log = new LoginController();
        assertFalse(log.userLogout());
    }

    @Test
    public void getUman() {
        LoginController log = new LoginController();
        assertTrue(log.getUman() instanceof UserManager);
    }

    @Test
    public void is_valid_name(){
        LoginController log = new LoginController();
        String a = "123";
        String b = "1234";
        String c = "abcd";
        String d = "abcd12bc";
        String e = "asrae123!";
        String f = "123456789abc3";
        assertTrue(log.is_valid_name(b));
        assertTrue(log.is_valid_name(c));
        assertTrue(log.is_valid_name(d));
        assertFalse(log.is_valid_name(a));
        assertFalse(log.is_valid_name(e));
        assertFalse(log.is_valid_name(f));
    }
}