package UseCase;

import Entities.Container;
import Entities.Item;
import Entities.User;

import java.io.IOException;
import java.util.*;

public class DataManager implements Observer{

    private final Map<String, Item> ItemManagerMap = new HashMap<String, Item>();
    private Map<String, User> UserManagerMap = new HashMap<String, User>();
    private final Map<String, Map<String,Boolean>> ContainerMap = new HashMap<String, Map<String,Boolean>>();

    // This is more of a "boundary" and only record map info.
    // We are not supposed to consult its map, except the containers(for vis).
    // Get map directly from the managers!
    // This is used to create, save, reload all the managers...

    public void LoadDM(/*a DM object, directly from file!*/){
        // This is probably a method in controller layer. it will construct a DataManager.
    }

    public DataManager(){
        // new DM, everything is empty. call constructEmpty(maybe).
        Map<String,Boolean> lmap = new HashMap<String,Boolean>();
        ContainerMap.put("L",lmap);

    }

    public List<Object> constructEmptyData() throws IOException{
        // When outside tries to make new im,um, must go through here.
        List<Object> result = new ArrayList<>();
        ItemStorer storer = new ItemStorer();
        ItemPicker picker = new ItemPicker();
        ItemSearcher searcher = new ItemSearcher();
        ItemTimer timer = new ItemTimer();
        ItemManager iman = new ItemManager(storer, searcher, picker, timer);
        UserManager uman = new UserManager();
        result.add(0, iman);
        result.add(1, uman);
        return result;
    }

    public List<Object> constructCurrentData() throws IOException {
        // First, reload DM....
        // Now this DM will have some maps.
        //
        // construct im and um, and reload them...
        // When outside tries to use existing im,dm, they must read an existing DM and extract im and dm from it.
        // This is done through this method.
        List<Object> empty_list = this.constructEmptyData();
        ItemManager im = (ItemManager) empty_list.get(0);
        UserManager um = (UserManager) empty_list.get(1);
        //im.reload(ContainerMap.get());
        return empty_list; //Not set yet, should be something new...
    }

    private void saveCurrentDataToFile(){
        // save current data to file
    }

    private void saveContainerToDM(Container c){

    }

    private void saveItemManagerToDM(){

    }

    private void saveUserManagerToDM(){

    }

    public void update(Observable o, Object arg) {
        // if (o instanceof) { //is instance of one of our managers or container, an observable...
            //make change to the specific map with (arg)

            // call saveCurrentData
        }
    }

    // public Map getter(){}



