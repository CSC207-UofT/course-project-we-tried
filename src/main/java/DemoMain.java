import Controller.ItemPropertiesIterator;
import Controller.PickupSystem;

public class DemoMain {

    public static void main(String[] args) {
        System.out.println("Test");
        PickupSystem sys = new PickupSystem();
        ItemPropertiesIterator itr = new ItemPropertiesIterator();
        sys.run();
    }

}
