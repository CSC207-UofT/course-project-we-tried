package UseCase;
import java.io.*;
import Entities.Item;
import Entities.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UserManager implements Serializable{

    private final Map<String, User> umap = new HashMap<String, User>();
    private final Map<String, List<Item>> imap = new HashMap<String, List<Item>>();
    private User currentUser;

    /**
     * Register the new user to the system.
     */
    public boolean userRegister(String username, String pw){
        umap.put(username, new User(username, pw));
        imap.put(username, new ArrayList<Item>());
        return true;
    }

    /**
     * Look up existing user in the map, and return user; if not found, return null.
     */
    public User lookupUser(String username){
        if (umap.containsKey(username)){
            return umap.get(username);
        }
        return null;
    }

    /**
     * Verify the user's input password and stored password.
     */
    public boolean pwVerify(String username, String pw){
        if (umap.containsKey(username)){
            return Objects.equals(pw, umap.get(username).getPassword());
        }
        return false;
    }

    /**
     * Record and return the current username.
     */
    public String RecordUser(String curr_name){
        if (umap.containsKey(curr_name)){
            currentUser = umap.get(curr_name);
            return curr_name;
        } else {
            currentUser = null;
            return null;
        }
    }

    /**
     * Return current user.
     */
    public User getCurrentUser(){
        return currentUser;
    }

    /**
     * Record item that the user processed.
     */
    public void record_item_processor(String processor_name, Item new_item){
        imap.get(processor_name).add(new_item);
    }

    /**
     * Return the map contains (username: user).
     */
    public Map<String, User> getUMap(String username){

        return umap;
    }

    /**
     * Return the map contains (username: List of items).
     */
    public Map<String, List<Item>> getUserImap(){

        return imap;
    }

}
