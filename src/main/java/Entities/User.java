package Entities;
import java.io.*;
public class User implements Serializable{

    /**
     * The string of the username
     */
    private final String username;

    /**
     * The string of the user's password
     */
    private final String password;

    /**
     * create a user of the system
     * @param username the string of the user's username
     * @param password the string of the user's password
     */
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     * Return the user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Return the user's username.
     */
    public String getUsername() {
        return username;
    }
}
