package Entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getPassword() {
        User Queenie = new User("queenie", "123456");
        assertNotEquals("123", Queenie.getPassword());
        assertEquals("123456", Queenie.getPassword());
    }

    @Test
    public void getUsername() {
        User Queenie = new User("queenie", "123456");
        assertEquals("queenie", Queenie.getUsername());
    }
}