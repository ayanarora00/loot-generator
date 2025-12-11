package edu.grinnell.csc207.lootgenerator;

public class Armor {

    // Declaring the variables
    private String Name;
    private int minac;
    private int maxac;

    // Constructor
    public Armor(String Name, int minac, int maxac){
        
        this.Name = Name;
        this.minac = minac;
        this.maxac = maxac;

    }

    /**Used to get the armor's name
     * @return String (the armor's name)
     * @param none
     */
    public String getName(){
        return this.Name;
    }

    /**Used to get the upper bound armor's defense stat
     * @return integer - the upper bound for the random defense stat of the armor
     * @param none
     */
    public int getminac(){
        return this.minac;
    }

    /**Used to get the upper bound armor's defense stat
     * @return integer - the upper bound for the random defense stat of the armor
     * @param none
     */
    public int getmaxac(){
        return this.maxac;
    }

}
