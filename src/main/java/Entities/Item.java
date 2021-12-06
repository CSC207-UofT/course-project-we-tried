package Entities;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Item implements Serializable{
    public static final int ID_INDEX = 0;
    public static final int SENDER_INDEX = 1;
    public static final int RECEIVER_INDEX = 2;
    public static final int DESCRIPTION_INDEX = 3;
    public static final int LOCATION_INDEX = 4;
    public static final int PROCESSOR_INDEX = 5;
    public static final int REQUIREMENT_INDEX = 6;
    public static final int INFO_CAPACITY = 8;

    /**
     * The id of the item.
     */
    private final String id;
    /**
     * a list of string of itemInfo of the item
     */
    private final List<String> itemInfo; // From txt
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
    private final String storageRequirement;

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
        List<String> ltlt = new ArrayList<>(INFO_CAPACITY);
        ltlt.add(ID_INDEX,this.id);
        ltlt.add(SENDER_INDEX, this.itemInfo.get(0));
        ltlt.add(RECEIVER_INDEX, this.itemInfo.get(1));
        ltlt.add(DESCRIPTION_INDEX, this.itemInfo.get(2));
        ltlt.add(LOCATION_INDEX, this.location);
        ltlt.add(PROCESSOR_INDEX, this.processor);
        ltlt.add(REQUIREMENT_INDEX, this.storageRequirement);

        return ltlt;
    }
}
