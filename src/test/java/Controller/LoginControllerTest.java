package Controller;

import Entities.User;
import UseCase.UserManager;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginControllerTest {

    @Test
    public void userLogin_successful() {
        LoginController log = new LoginController();
        log.userRegister("alan", "abc");
        assertTrue(log.userLogin("alan", "abc"));

    }

    @Test
    public void userLogin_fail_wrong_password() {
        LoginController log = new LoginController();
        log.userRegister("alan", "abc");
        assertFalse(log.userLogin("alan", "ab"));
    }

    @Test
    public void userLogin_fail_wrong_user() {
        LoginController log = new LoginController();
        log.userRegister("alan", "abc");
        assertFalse(log.userLogin("ala", "abc"));
    }

    @Test
    public void userRegister_successful() {
        LoginController log = new LoginController();
        assertTrue(log.userRegister("alan", "abc"));

    }

    @Test
    public void userRegister_fail() {
        LoginController log = new LoginController();
        UserManager u = log.getUman();
        u.userRegister("alan", "123");
        assertFalse(log.userRegister("alan", "abc"));

    }

    @Test
    public void userLogout_has_current_user() {
        LoginController log = new LoginController();
        log.userRegister("alan", "abc");
        log.userLogin("alan", "abc");
        assertTrue(log.userLogout());
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
}