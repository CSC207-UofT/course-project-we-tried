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

    public User lookupUser(String username){
        // look up and return the user in umap; if not found, return null
        if (umap.containsKey(username)){
            return umap.get(username);
        }
        return null;
  

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
