import Controller.LoginController;
import Controller.PickupSystem;
import UI.LoginPage;
import UI.OperationSearch;
import UI.OperationStore;

import java.util.HashMap;

public class DemoMain {

    public static void main(String[] args) {
        /*List<String> i1_info = new ArrayList<String>(Arrays.asList("Sender: CSC", "Receiver: We_Tried", "Description: This is a package!"));
        List<String> i2_info = new ArrayList<String>(Arrays.asList("Sender: CSC", "Receiver: We_Failed", "Description: This is not my package!"));
        User u1 = new User("user1", "123456");
        Item i1 = new Item("207", i1_info, "L01", u1.getUsername(),"L");
        Item i2 = new Item("236", i2_info, "F02", u1.getUsername(),"F");

        Scanner in = new Scanner(System.in);
        System.out.println("Package Extraction");
        System.out.println("Please enter the Package ID:");
        String id = in.nextLine();

        ItemManager iman = new ItemManager();
        iman.addItem(i1);
        iman.addItem(i2);
        if(iman.searchItem(id)== null){
            System.out.println("Item not found!");
        } else {
            System.out.println(iman.searchItem(id));
            System.out.println("Enter 1 to remove the item and 2 to keep the item");
            int option = in.nextInt();
            if (option == 1){
                iman.removeItem(id);
                System.out.println("Pickup succeed.");
            }
            else if (option == 2){
                System.out.println("Returning to the main menu...");
            }
        }*/
        LoginPage loginPage = new LoginPage();
        //PickupSystem pickupSystem = new PickupSystem();
        //LoginController loginController = new LoginController();
        //OperationStore operationStore = new OperationStore("user",pickupSystem,loginController);
        //OperationSearch operationSearch = new OperationSearch("user",pickupSystem,loginController);
    }
}
