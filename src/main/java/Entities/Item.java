package Entities;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Item implements Serializable{
    /**
     * The id of the item.
     */
    private String id;
    /**
     * a list of string of itemInfo of the item
     */
    private List<String> itemInfo; // From txt
    /**
     * The location where the item is stored
     */
    private String location;
    /**
     * The user(username) last processed this item
     */
    private String processor;
    /**
     * The storage requirement of the item, L/F/R
     */
    private String storageRequirement;

    /**
     * Create a item object
     * @param id the string id of the item
     * @param info the list of string of the item information
     * @param storageRequirement the string storage requirement of the item
     *
     */
    public Item(String id, List<String> info, String storageRequirement){
        this.id = id;
        this.itemInfo = info;
        this.location = "";
        this.processor = "";
        this.storageRequirement = storageRequirement;
    }
    /**
     * Create a item object
     * @param id the string id of the item
     * @param info the list of string of the item information
     * @param processor the string of the username who last processed this item
     * @param storageRequirement the string storage requirement of the item
     */
    public Item(String id, List<String> info, String location, String processor, String storageRequirement){
        this.id = id;
        this.itemInfo = info;
        this.location = location;
        this.processor = processor;
        this.storageRequirement = storageRequirement;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public void setProcessor(String username){
        this.processor = username;
    }

    public String getId() {
        return id;
    }

    public List<String> getItemInfo() {
        return itemInfo;
    }

    public String getLocation(){
        return this.location;
    }

    public String getProcessor() {
        return processor;
    }

    public String getStorageRequirement() {
        return storageRequirement;
    }

    public List<String> getInfo(){
        List<String> ltlt = new ArrayList<>(8);
        ltlt.add(0,this.id);
        ltlt.add(1, this.itemInfo.get(0));
        ltlt.add(2, this.itemInfo.get(1));
        ltlt.add(3, this.itemInfo.get(2));
        ltlt.add(4, this.location);
        ltlt.add(5, this.processor);
        ltlt.add(6, this.storageRequirement);

        return ltlt;
    }
}
