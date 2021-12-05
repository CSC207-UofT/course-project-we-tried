import Controller.LoginController;
import Controller.PickupSystem;
import UI.LoginPage;
import UseCase.ItemManager;
import UseCase.UserManager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
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
        Path path = Paths.get("./data file");
        Path pathCreate = Files.createDirectories(path);
        File file = new File("./data file/xyz.txt");
        if (! file.exists()){
            UserManager userManager = new UserManager();
            FileOutputStream fos = new FileOutputStream("./data file/user.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userManager);
            ItemManager itemManager = new ItemManager();
            FileOutputStream foss = new FileOutputStream("./data file/xyz.txt");
            ObjectOutputStream ooss = new ObjectOutputStream(foss);
            ooss.writeObject(itemManager);
        }
        FileInputStream fis = new FileInputStream("./data file/xyz.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ItemManager im = (ItemManager) ois.readObject();
        FileInputStream fiss = new FileInputStream("./data file/user.txt");
        ObjectInputStream oiss = new ObjectInputStream(fiss);
        UserManager um = (UserManager) oiss.readObject();
        ois.close();
        oiss.close();
        LoginController loginController = new LoginController(um);
        PickupSystem pickupSystem = new PickupSystem(im, um);
        LoginPage loginPage = new LoginPage(pickupSystem, loginController);}
        //PickupSystem pickupSystem = new PickupSystem();
        //LoginController loginController = new LoginController();
        //OperationStore operationStore = new OperationStore("user",pickupSystem,loginController);
        //OperationSearch operationSearch = new OperationSearch("user",pickupSystem,loginController);
}

