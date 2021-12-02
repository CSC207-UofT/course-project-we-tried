package UseCase;

import Entities.Item;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ItemTimerTest {

    @Test
    public void recordStart() {
        List<String> info = Arrays.asList("Sender: test_s", "Receiver: test_r", "Description: test!");
        Item i = new Item("qq", info, "L");
        ItemTimer itime = new ItemTimer();
        itime.RecordStart(i);
        assertNotNull(itime.getTimer_map().get("qq"));
    }

    @Test
    public void recordEnd() {
        List<String> info = Arrays.asList("Sender: test_s", "Receiver: test_r", "Description: test!");
        Item i = new Item("qq", info, "L");
        ItemTimer itime = new ItemTimer();
        itime.RecordStart(i);
        assertNotNull(itime.getTimer_map().get("qq"));
        itime.RecordEnd("qq");
        assertNull(itime.getTimer_map().get("qq"));
    }

    @Test
    public void calculateFee() {
        List<String> info = Arrays.asList("Sender: test_s", "Receiver: test_r", "Description: test!");
        Item i = new Item("qq", info, "L");
        ItemTimer itime = new ItemTimer();
        itime.RecordStart(i);
        assertEquals(0, itime.CalculateFee("qq"));
    }

    @Test
    public void getTimeListString() {
        List<String> info = Arrays.asList("Sender: test_s", "Receiver: test_r", "Description: test!");
        Item i = new Item("qq", info, "L");
        ItemTimer itime = new ItemTimer();
        itime.RecordStart(i);
        assertEquals(Arrays.asList("2021/12/1", "2021/12/3"), itime.getTimeListString("qq"));
        Item i2 = new Item("qqq", info, "F");
        itime.RecordStart(i2);
        assertEquals(Arrays.asList("2021/12/1", "2021/12/2"), itime.getTimeListString("qqq"));
    }

    @Test
    public void getTimer_map() {
        List<String> info = Arrays.asList("Sender: test_s", "Receiver: test_r", "Description: test!");
        Item i = new Item("qq", info, "L");
        ItemTimer itime = new ItemTimer();
        itime.RecordStart(i);
        assertNotNull(itime.getTimer_map());
    }
}