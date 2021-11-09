package UseCase;

import Entities.Item;
import Entities.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UserManager {

    private static Map<String, User> umap = new HashMap<String, User>();
    private static Map<String, List<Item>> imap = new HashMap<String, List<Item>>();
    private User currentUser;

    public boolean userRegister(String username, String pw){
        umap.put(username, new User(username, pw));
        imap.put(username, new ArrayList<Item>());
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
        if (umap.containsKey(username)){
            return Objects.equals(pw, umap.get(username).getPassword());
        }
        return false;
    }

    public boolean recordUser(User currUser){
        // User or name&pw ???
        currentUser = currUser;
        return true;
    }

    public void record_item_processor(String processor_name, Item new_item){
        imap.get(processor_name).add(new_item);
    }

    public Map<String, User> getUMap(String username, User user){
        return umap;
    }

    public Map<String, List<Item>> getUserImap(){
        return imap;
    }


}
