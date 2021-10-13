package UseCase;

import Entities.Item;
import Entities.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager {

    private static Map<String, User> umap = new HashMap<String, User>();
    private static Map<String, List<Item>> imap = new HashMap<String, List<Item>>();

    public boolean register(){
        return true;
    }

    public boolean lookupUser(String username, String pw){
        // look up the user in umap; if not found, return false
        return true;
    }

    public static boolean recordUser(String currentUser){

        return true;
    }

    public static Map<String, User> generateUmap(){
        return umap;
    }

    public static Map<String, List<Item>> generateImap(){
        return imap;
    }


}
