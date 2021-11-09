package UseCase;

import Entities.Item;
import Entities.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UserManager {

    private static Map<String, User> umap = new HashMap<String, User>();
    private static Map<String, List<Item>> imap = new HashMap<String, List<Item>>();
    private User currentUser;

    public boolean UserRegister(String username, String pw){
        umap.put(username, new User(username, pw));
        return true;
    }

    public User lookupUser(String username){
        // look up and return the user in umap; if not found, return null
        if (umap.containsKey(username)){
            return umap.get(username);
        }
        return null;
    }

    public boolean pwVerify(String username, String pw){
        // verify password
        return Objects.equals(pw, umap.get(username).getPassword());
    }

    public boolean RecordUser(User currUser){
        // User or name&pw ???
        currentUser = currUser;
        return true;
    }

    public static Map<String, User> GetUMap(String username, User user){
        return umap;
    }

    public static Map<String, List<Item>> GetUserImap(String username, User user){
        return imap;
    }


}
