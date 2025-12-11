package edu.grinnell.csc207.lootgenerator;
import java.util.*;

public class TreasureClass {

    // Dcelaring the variables
    private String Name;
    private String item1;
    private String item2;
    private String item3;
    private String[] items;

    // The constructor
    public TreasureClass(String Name, String item1, String item2, String item3){
        
        this.Name = Name;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;

    }

    /**Used to get the monster's type
     * @return String (the monster's type)
     * @param none
     */
    public String getName(){
        return this.Name;
    }

    /**Used to get the monster's items
     * @return List of Strings containing the monster's 3 items
     * @param none
     */
    public String[] getItems(){
        this.items = new String[]{item1, item2, item3};
        return this.items;
    }
    
}

    





