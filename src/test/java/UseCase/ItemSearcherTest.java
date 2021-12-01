package UseCase;

import Entities.Item;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ItemSearcherTest {

    @Test
    public void search() {
      ItemSearcher searchi = new ItemSearcher();
      List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
      Item il = new Item("a", info, "L");
      Map<String, Item> imap = new HashMap<String, Item>();
      imap.put("a", il);
      List<String>  actual = Arrays.asList("a","Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!","","", "L");
      assertEquals(searchi.search("a", imap), actual);

    }

    @Test
    public void search_null(){
        ItemSearcher searchi = new ItemSearcher();
        List<String> info = Arrays.asList("Sender: test_sender", "Receiver: test_receiver", "Description: This is a test!");
        Item il = new Item("a", info, "L");
        Map<String, Item> imap = new HashMap<String, Item>();
        assertNull(searchi.search("a", imap));

    }
}