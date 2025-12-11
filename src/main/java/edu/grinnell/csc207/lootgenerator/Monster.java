package edu.grinnell.csc207.lootgenerator;
import java.util.*;

public class Monster {
        
    // Declaring the variables
    private String Name;
    private String Type;
    private int Level;
    private String TreasureClass;

    // The constructor 
    public Monster(String Name, String Type, int Level, String TreasureClass){
        
        this.Name = Name;
        this.TreasureClass = TreasureClass;
        this.Type = Type;
        this.Level = Level;

    }

    /**Used to get the monster's name
     * @return String (the monster's name)
     * @param none
     */
    public String getName(){
        return this.Name;
    }

    /**Used to get the monster's treasure class
     * @return String (the monster's treasure class)
     * @param none
     */
    public String getTreasureClass(){
        return this.TreasureClass;
    }

    /**Used to get the monster's type
     * @return String (the monster's type)
     * @param none
     */
    public String getType(){
        return this.Type;
    }

    /**Used to get the monster's level
     * @return integer - level of the monster
     * @param none
     */
    public int getLevel(){
        return this.Level;
    }



}

