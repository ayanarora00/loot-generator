package edu.grinnell.csc207.lootgenerator;

// Including neccessary imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.random.*;
import javax.crypto.NullCipher;

public class LootGenerator {
    /** The path to the dataset (either the small or large set). */
    private static final String DATA_SET = "data/large";

    // Declaring a random variable for later use
    static Random rand = new Random();

    // Declaring lists/hashmaps for armor, treasureclass, monsters, prefix and suffix
    private static Map<String, TreasureClass> treasuremap = new HashMap<>();
    private static Map<String, Armor> armormap = new HashMap<>();
    private static List<Monster> monsters = new ArrayList<>();
    private static List<MagicAffix> prefix  = new ArrayList<>();
    private static List<MagicAffix> suffix = new ArrayList<>();

    /** Parsing the textfile for monsters and returning them as a list
     * 
     * @param filename - The string which has filename from which we read
     * @return List<Monster> - the function parsest the file for monsters adding it to the list
     * @throws FileNotFoundException
     */
    private static List<Monster> parseMonsters(String filename) throws FileNotFoundException{

        // Declaring the list to store the monsters
        List<Monster> list = new ArrayList<>();

        // Opening up a new scanner object to parse through the file
        Scanner scanner = new Scanner(new File(filename));

        // Checking if the scanner has another line
        // Acknowledgement - JAVA API docs to see how hasNextLine() and nextLine() work and if it can be used
        // the same way as hasNext() and next()
        while (scanner.hasNextLine()){

            // If the scanner object has another line:

            // We remove the whitespaces using trim and store the line as a string
            String s = scanner.nextLine().trim();

            // Getting a list of words from the Line String
            String[] arr = s.split("\t");

            // The Name is first word in the array
            String Name = arr[0];

            // The Type is the second word in the array
            String Type = arr[1];

            // The Level of the monster which is the third word in the array
            int Level = Integer.parseInt(arr[2]);

            // The treasureclass of the monster is the 4th word
            String TreasureClass = arr[3];

            // We create a new monster object with these values obtained from the array/line and add it to our list
            Monster m = new Monster(Name, Type, Level, TreasureClass);
            list.add(m);

        }

        // We return the list which stores the monsters
        return list;

    }

    /** Parsing the textfile for affix and returning them as a list
     * 
     * @param filename - The string which has filename from which we read
     * @return List<MagicAffix> - the function parsest the file for MagicAffix, adding it to the list
     * @throws FileNotFoundException
     */
    private static List<MagicAffix> parseAffix(String filename) throws FileNotFoundException{

        // Declaring the list to store the magicaffixes
        List<MagicAffix> affix = new ArrayList<>();

        // New scanner object created to parse through the file
        Scanner scanner = new Scanner(new File(filename));

        // Checking if the scanner has another line
        while (scanner.hasNextLine()){

            // As long as it does, we keep accessing the file line by line

            // Storing the line as a string with whitespaces removed
            String s = scanner.nextLine().trim();

            // Creating an array of words from the string line
            String[] arr = s.split("\t");

            // Affix name is first word of the array
            String Name = arr[0];

            // Affix mod1code is the second word of the array
            String mod1code = arr[1];

            // The integers mod1min and mod1max (lower and upper bounds for the random value) are the 
            // third and 4th words in the line respectively
            int mod1min = Integer.parseInt(arr[2]);
            int mod1max = Integer.parseInt(arr[3]);

            // We create a new MagixAffix object with these values obtained from the array/line and add it to our list
            MagicAffix ma = new MagicAffix(Name, mod1code, mod1min, mod1max);
            affix.add(ma);

        }

        // The affix list is returned
        return affix;

    }


    /** Parsing the textfile for affix and returning them as a map
     * 
     * @param filename - The string which has filename from which we read
     * @return Map<String, TreasureClass> - the function parses the file for TreasureClass, adding it to the map
     * @throws FileNotFoundException
     */
    private static Map<String, TreasureClass> parseTreasureClass(String filename) throws FileNotFoundException{

        // Declaring a map variable
        Map<String, TreasureClass> map = new HashMap<>();
        
        // New scanner object created to parse through the file
        Scanner scanner = new Scanner(new File(filename));

        // Checking if the scanner has another line
        while (scanner.hasNextLine()){

            // As long as it does, we keep accessing the file line by line

            // We remove the whitespaces using trim and store the line as a string
            String s = scanner.nextLine().trim();

            // Getting an array of words by splitting the line
            String[] arr = s.split("\t");

            // The first word of the array is the name
            String Name = arr[0];

            // The next 3 words are the items of the treasureclass
            String item1 = arr[1];
            String item2 = arr[2];
            String item3 = arr[3];

            // We create a new treasureclass with the contents of the line
            TreasureClass tc = new TreasureClass(Name, item1, item2, item3);

            // The map gets the name of the class mapped to the contents of the treasureclass object
            map.put(Name, tc);

        }

        // We return the map
        return map;

    }

    /** Parsing the textfile for armor and returning them as a map
     * 
     * @param filename - The string which has filename from which we read
     * @return Map<String, Armor> - the function parses the file for Armor, adding it to the map we return
     * @throws FileNotFoundException
     */
    private static Map<String, Armor> parseArmor(String filename) throws FileNotFoundException{

        // Declaring a map variable
        Map<String, Armor> map = new HashMap<>();

        // New scanner object created to parse through the file
        Scanner scanner = new Scanner(new File(filename));

        // Checking if the scanner has another line
        while (scanner.hasNextLine()){

            // As long as it does, we keep accessing the file line by line

            // We remove the whitespaces using trim and store the line as a string
            String s = scanner.nextLine().trim();

            // Getting an array of words by splitting the line
            String[] arr = s.split("\t");

            // The name of the armor is first element of the array
            String Name = arr[0];

            // The minimum and the maximum bounds for the range in which the defense stat lies are the next 2

            int minac = Integer.parseInt(arr[1]);
            int maxac = Integer.parseInt(arr[2]);

            // Creating a new armor object from the line
            Armor tc = new Armor(Name, minac, maxac);

            // Putting it into the map object with the name of armor object mapping to the armor object we created
            map.put(Name, tc);

        }

        // returning
        return map;

    }

    /** This function used to pick a monster from our monsters list at random
     * 
     * @return Monster - a random monster picked
     * @param none
     */
    public static Monster pickMonster(){

        // Picking a random integer index for the list of monsters using Math.random
        int index = (int) (Math.random() * monsters.size());
        
        // Getting the monster at that random index generated
        return monsters.get(index);

    }

    /** This function used to find the random monster picked's treasureclass
     * 
     * @return TreasureClass object - the treasure class associated with the name of the treasureclass field of our random monster
     * @param Monster monster - the monster's whose treasureclass is needed
     */
    public static TreasureClass fetchTreasureClass(Monster monster){

        // We get the name of the monster's treasure class
        String Name = monster.getTreasureClass();

        // We find the TreasureClass object it maps to and return it
        TreasureClass treasure = treasuremap.get(Name);
        return treasure;
    }

    /** This function used to generate the base item from the random monster's treasureclass
     * 
     * @return String - the base item we generate from the monster's treasureclass
     * @param TreasureClass treasureclass - the treasureclass which has the items to generate the base item from
     */
    public static String generateBaseItem(TreasureClass treasureclass){
        
        // Picking a random integer index for the list of items using Math.random
        int index = (int) (Math.random() * 3);

        // Getting the items list from the TreasureClass object
        String[] items = treasureclass.getItems();

        // Generating a random item
        String drop = items[index];

        // Creating a new TreasureClass object storing in it the TreasureClass mapping to the name of the random item
        TreasureClass inner = treasuremap.get(drop);

        // If null, we return the random item. Otherwise, we generate a base item for the TreasureClass that maps to the 
        // random item (recursively done to make sure that the item is a base item i.e. it isn't a TreasureClass object 
        // with 3 more inner items)

        if (inner == null){
            return drop;
        } else {
            return generateBaseItem(inner);
        }

    }

    /** This function used to generate the base item's stats from the item name
     * 
     * @return the base item stats 
     * @param Baseitem the baseitem whose stats are generated
     */
    public static String generateBaseStats(String Baseitem){
       
        // to return -- Defense: <defense value>

        // We get the armor object that the baseitem we find maps to
        Armor armor = armormap.get(Baseitem);

        // We calculate its random stat and return the stat in the format required
        int minac = armor.getminac();
        int maxac = armor.getmaxac();
        int value = rand.nextInt(minac, maxac);
        return ("Defense: " + value);

    }

    /** This function used to generate an affix for the baseitem
     * 
     * @return the affix generated
     * @param generation the variable deciding whether to generate a suffix or prefix
     */
    public static MagicAffix generateAffix(int generation){

        // Declaring the variable;
        MagicAffix affix;

        // If the generation variable is divisible by 2, we get a suffix from the suffix list
        if (generation % 2 == 0){
            affix = suffix.get((int) (Math.random() * suffix.size()));
        } else {
            // Else, we get a prefix
            affix = prefix.get((int) (Math.random() * prefix.size()));
        }

        // Returning the affix
        return affix;

     
    }

    /** This function used to generate an affix stats
     * 
     * @return the stats generated of the MagicAffix object we pass in
     * @param affix the MagicAffix object
     */
    public static String generateAffixStats(MagicAffix affix){
    
        // Getting the mod1code
        String mod1code = affix.getmod1code();
        int mod1max = affix.getmod1max();
        int mod1min = affix.getmod1min();

        // We calculate its random value and return the stat in the format required
        int value = rand.nextInt(mod1min, mod1max);
        return (value + " " + mod1code);
  
    }


    /** Main function that is the driver for the program
     * 
     * @param args - the command line arguments
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("This program kills monsters and generates loot!");

        // The format we need to implement:

        // Fighting <monster name>...
        // You have slain <monster name>!
        // <monster name> dropped:

        // <complete item name>
        // <base item statistic>
        // <additional affix statistics>

        // Reading through the files and parsing them using our created functions, then storing them
        // in the lists/map variables we declared at the start of our program
        monsters = parseMonsters(DATA_SET + "/monstats.txt");
        treasuremap = parseTreasureClass(DATA_SET + "/TreasureClassEx.txt");
        prefix = parseAffix(DATA_SET + "/MagicPrefix.txt");
        armormap = parseArmor(DATA_SET + "/armor.txt");
        suffix = parseAffix(DATA_SET + "/MagicSuffix.txt");

        // Setting a boolean variable called running to be true
        // Our coming loop will keep running as long as the value of the variable is true
        boolean running = true;

        // As long as the value of running variable stays true
        while (running) {

            // Using the pickMonster function, we randomly pick a monster from our monsters list
            Monster monster = pickMonster();

            // We print out the following according to the format in the prompt:
            System.out.println("Fighting " + monster.getName());
            System.out.println("You have slain " + monster.getName());
            System.out.println(monster.getName() + " dropped:");

            // Using fetchTreasureClass, we get the treasure class of the monster we picked randomly
            TreasureClass treasureclass = fetchTreasureClass(monster);

            // Using the treasure class variable we create above, we generate and store a base item
            String baseitem = generateBaseItem(treasureclass);

            // Using that base item, we generate its stats
            String stats = generateBaseStats(baseitem);

            int generation = (int) (Math.random() * 2);

            MagicAffix affix = generateAffix(generation);
            
            String affixStats = generateAffixStats(affix);
            
            // Again we print the baseitem along with its stats according to the prompt:
            if (generation % 2 == 0){
                System.out.println(baseitem + " " + affix.getName());
            } else {
                System.out.println(affix.getName() + baseitem);
            }
            System.out.println(stats);
            System.out.println(affixStats);


            // Prompting the user with whether they want to play again
            System.out.println("Fight again [y/n]? <echoed user input from Scanner>");

            // New scanner object to read user input
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();

            if (answer.equals("y")){
                running = true;
            } else {
                // If the input is no, running is set to false and the loop is exited stopping the program.
                running = false;
            }

        }
    }
}
