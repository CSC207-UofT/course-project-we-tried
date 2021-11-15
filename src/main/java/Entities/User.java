package Entities;
import java.io.*;
public class User implements Serializable{
    /**
     * The string of the username
     */
    private String username;
    /**
     * The string of the user's password
     */
    private String password;

    /**
     * create a user of the system
     * @param username the string of the user's username
     * @param password the string of the user's password
     */
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
