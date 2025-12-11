package edu.grinnell.csc207.lootgenerator;

public class MagicAffix {

    // Structure of file:
    // Name  mod1code     mod1min     mod1max

    // Declaring the variables
    private String Name;
    private String mod1code;
    private int mod1min;
    private int mod1max;

    // Constructor
    public MagicAffix (String Name, String mod1code, int mod1min, int mod1max){
        this.Name = Name;
        this.mod1code = mod1code; 
        this.mod1max = mod1max;
        this.mod1min = mod1min;
    }

    /**Used to get the affix name
     * @return String (the name of the affix)
     * @param none
     */
    public String getName(){
        return this.Name;
    }

    /**Used to get the name of the additional statistic contained in mod1code
     * @return String - the additional statistic
     * @param none
     */
    public String getmod1code(){
        return this.mod1code;
    }

    /**Used to get the lower range of the random integer
     * @return integer - the lower range for the random integer the magicaffix generates
     * @param none
     */
    public int getmod1min(){
        return this.mod1min;
    }

    /**Used to get the upper range of the random integer
     * @return integer - the upper range for the random integer the magicaffix generates
     * @param none
     */
    public int getmod1max(){
        return this.mod1max;
    }

}
