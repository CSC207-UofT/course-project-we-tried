package Entities;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void setLocation() {
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item i = new Item("a", info, "L");
        i.setLocation("where");
        assertEquals("where", i.getLocation());
    }

    @Test
    public void setProcessor() {
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item i = new Item("a", info, "L");
        i.setProcessor("alan");
        assertEquals("alan", i.getProcessor());
    }


    @Test
    public void getId() {
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item i = new Item("a", info, "L");
        assertEquals("a",i.getId());
    }

    @Test
    public void getItemInfo() {
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item i = new Item("a", info, "L");
        assertEquals(info,i.getItemInfo());
    }

    @Test
    public void getLocation() {
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item i = new Item("a", info, "L");
        assertEquals("",i.getLocation());
    }

    @Test
    public void getProcessor() {
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item i = new Item("a", info, "L");
        assertEquals("",i.getProcessor());
    }

    @Test
    public void getStorageRequirement() {
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item i = new Item("a", info, "L");
        assertEquals("L",i.getStorageRequirement());
    }


    @Test
    public void getInfo() {
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item i = new Item("a", info, "L");
        List<String> expected = new ArrayList<>(Arrays.asList("a","Sender: test_sender","Receiver: test_receiver",
                "Description: This is a test!","", "","L"));
        assertEquals(expected,i.getInfo());
    }
}