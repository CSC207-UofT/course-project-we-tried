import Controller.LoginController;
import Controller.PickupSystem;
import UI.LoginPage;
import UseCase.ItemManager;
import UseCase.UserManager;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
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
}

