package Controller;

import Entities.User;
import UseCase.UserManager;
import org.junit.Test;
import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.*;

public class LoginControllerTest {

    @Test
    public void user() throws IOException {
        LoginController log = new LoginController();
        UserManager u = log.getUman();
        Map<String, User> m = u.getUMap();
    }

    @Test
    public void userLogin_successful() throws IOException {
        LoginController log = new LoginController();
        UserManager u = log.getUman();
        Map<String, User> m = u.getUMap();
        log.userRegister("alan", "abcd");
        assertTrue(log.userLogin("alan", "abcd"));
        assertEquals("alan",log.getCurrentUser());
        assertEquals("alan", log.getUman().getCurrentUser().getUsername());

    }

    @Test
    public void userLogin_fail_wrong_password() throws IOException {
        LoginController log = new LoginController();
        log.userRegister("alan", "abce");
        assertFalse(log.userLogin("alan", "abcc"));
    }

    @Test
    public void userLogin_fail_wrong_user() throws IOException {
        LoginController log = new LoginController();
        log.userRegister("alan", "abcd");
        assertFalse(log.userLogin("ala", "abcd"));
    }

    @Test
    public void userRegister_successful() throws IOException {
        LoginController log = new LoginController();
        UserManager u = log.getUman();
        Map<String, User> m = u.getUMap();
        Boolean a = log.userRegister("alan","abcd");
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
    public void userLogout_has_no_current_user() throws IOException {
        LoginController log = new LoginController();
        assertFalse(log.userLogout());
    }

    @Test
    public void getUman() throws IOException {
        LoginController log = new LoginController();
        assertTrue(log.getUman() instanceof UserManager);
    }

    @Test
    public void userDelete_success() throws IOException {
        LoginController log = new LoginController();
        UserManager u = log.getUman();
        u.userRegister("Alan", "1234");
        log.userDelete("Alan");
        assertTrue(u.getUMap().isEmpty());
    }



    @Test
    public void getCurrentUser() throws IOException {
        LoginController log = new LoginController();
        UserManager u = log.getUman();
        u.userRegister("Alan", "1234");
        u.RecordUser("Alan");
        assertEquals("Alan", u.getCurrentUser().getUsername());
    }


}