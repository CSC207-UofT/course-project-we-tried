package UseCase;

import Entities.Item;
import org.junit.Test;
import java.util.Arrays;
import java.util.Calendar;
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
        Calendar t_start = Calendar.getInstance();
        int month_1 = t_start.get(Calendar.MONTH)+1;
        String s_1 = t_start.get(Calendar.YEAR) + "/" + month_1 + "/" + t_start.get(Calendar.DATE);

        Calendar t_fee = Calendar.getInstance();
        t_fee.add(Calendar.DATE,2);
        int month_2 = t_fee.get(Calendar.MONTH)+1;
        String s_2 = t_fee.get(Calendar.YEAR) + "/" + month_2 + "/" + t_fee.get(Calendar.DATE);

        List<String> info = Arrays.asList("Sender: test_s", "Receiver: test_r", "Description: test!");
        Item i = new Item("qq", info, "L");
        ItemTimer itime = new ItemTimer();
        itime.RecordStart(i);
        assertEquals(Arrays.asList(s_1, s_2), itime.getTimeListString("qq"));


    }

    @Test
    public void getTimeListString_F(){
        Calendar t_start = Calendar.getInstance();
        int month_1 = t_start.get(Calendar.MONTH)+1;
        String s_3 = t_start.get(Calendar.YEAR) + "/" + month_1 + "/" + t_start.get(Calendar.DATE);

        Calendar t_fee = Calendar.getInstance();
        t_fee.add(Calendar.DATE,1);
        int month_2 = t_fee.get(Calendar.MONTH)+1;
        String s_4 = t_fee.get(Calendar.YEAR) + "/" + month_2 + "/" + t_fee.get(Calendar.DATE);

        List<String> info = Arrays.asList("Sender: test_s", "Receiver: test_r", "Description: test!");
        ItemTimer itime = new ItemTimer();
        Item i2 = new Item("qqq", info, "F");
        itime.RecordStart(i2);
        assertEquals(Arrays.asList(s_3, s_4), itime.getTimeListString("qqq"));
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