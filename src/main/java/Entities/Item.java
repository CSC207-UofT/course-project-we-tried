package Entities;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String id;
    private List<String> itemInfo; // From txt
    private String location;
    private String processor; // The user(username) last processed this item
    private String storageRequirement; // L/F/R
    private boolean fee; // whether the item has exceeded free storage time

    public Item(String id, List<String> info, String storageRequirement){
        this.id = id;
        this.itemInfo = info;
        this.location = "";
        this.processor = "";
        this.storageRequirement = storageRequirement;
        this.fee = false;
    }

    public Item(String id, List<String> info, String location, String processor, String storageRequirement){
        this.id = id;
        this.itemInfo = info;
        this.location = location;
        this.processor = processor;
        this.storageRequirement = storageRequirement;
        this.fee = false;
    }

    /* Item needs a set location & set processor and record fee*/
    public void setLocation(String location){
        this.location = location;
    }

    public void setProcessor(String username){
        this.processor = username;
    }

    public void setFee(int fee){
        this.fee = true;
    }

    /*Above are all the new modifications*/

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

    public boolean isFee() {
        return fee;
    }

    @Override
    public String toString(){
        return String.format("Item: %s%nInformation:%s%nLocation:%s%nProcessor:%s%nFee:%b%n",
                id, itemInfo, location, processor, fee);
    }
}
