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

    private Map<String, User> umap = new HashMap<String, User>();
    private final Map<String, List<String>> imap = new HashMap<String, List<String>>();
    private User currentUser;

    /**
     * check if the username is a valid name for register
     * @param name username
     * @return Return true if name is valid; false if not.
     */
    public boolean is_valid_name(String name){
        return name.matches("^[a-zA-Z0-9]{4,12}$");
    }

    /**
     * Register the new user to the system.
     * @param username user's username
     * @param pw user's corresponding password
     */
    public void userRegister(String username, String pw){
        if (is_valid_name(username)) {
            umap.put(username, new User(username, pw));
            imap.put(username, new ArrayList<String>());
        }
    }

    /**
     * Register the new user to the system.
     * @param name input username
     * @param pw input corresponding password
     */
    public void userDelete(String name, String pw){
        //first check password
        if (pwVerify(name, pw)){
            umap.remove(name);
        }
    }

    /**
     * Look up existing user in the map.
     * @param username user's username
     * @return Return user; if not found, return null.
     */
    public User lookupUser(String username){
        if (umap.containsKey(username)){
            return umap.get(username);
        }
        return null;
    }

    /**
     * Verify the user's input password and stored password.
     * @param username input username
     * @param pw input corresponding password
     * @return Return true if the username matches password, false if it doesn't.
     */
    public boolean pwVerify(String username, String pw){
        if (umap.containsKey(username)){
            return Objects.equals(pw, umap.get(username).getPassword());
        }
        return false;
    }

    /**
     * Record and the current username.
     * @param curr_name current username
     * @return Return true if successfully record, false if not.
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
     * @param processor_name processor's username
     * @param new_item_id new processed item's id
     */
    public void record_item_processor(String processor_name, String new_item_id){
        imap.get(processor_name).add(new_item_id);
    }

    /**
     * Reset UserManager to not have any users.
     */
    public void reset_all_users(){
        this.umap = new HashMap<String, User>();
    }

    /**
     * Get users' map
     * @param username user's username
     * @return Return the map contains (username: user).
     */
    public Map<String, User> getUMap(String username){

        return umap;
    }

    /**
     * Get list contains all items' ids processed by the user
     * @param username user's username
     * @return Return the ArrayList contains items' ids processed by this user.
     */
    public ArrayList<String> getUserImap(String username){

        return (ArrayList<String>) imap.get(username);
    }

}
