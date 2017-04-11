import java.util.Hashtable;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * The Map class holds data that associates locationIDs
 * with the locations themselves. The data is stored in
 * a Hashtable.
 */

public class Map{
	//Using a hash table to hold the map locations
   protected Hashtable<Integer, Location> map;
	
   /**
    * Default constructor.
    */
   public Map(){
      this.map = new Hashtable<Integer, Location>(1000);
      this.initMap();
   }
	
   /**
    * The initMap method initializes the map to the
    * data that is read from the designated .txt file.
    * 
    * If the designated file cannot be found, a
    * FileNotFound exception is thrown.
    */
   private void initMap(){
      try{
      	/* CHANGE THE FILENAME BELOW THIS LINE */
         File mapFile = new File("map.txt");
      	
      	//Open the file to read
         Scanner scan = new Scanner(mapFile, "UTF-8");
      
         while(scan.hasNextInt()){ //Loops until there are no more locations to read in
         	//Create a new location
            Location newLocation = new Location();
         	
         	//Fill the ID, exits, description, and hint from the file
            newLocation.setLocationID(scan.nextInt());
            newLocation.setNorth(scan.nextInt());
            newLocation.setSouth(scan.nextInt());
            newLocation.setEast(scan.nextInt());
            newLocation.setWest(scan.nextInt());
            newLocation.setUp(scan.nextInt());
            newLocation.setDown(scan.nextInt());
            scan.nextLine(); //nextInt() doesn't consume the newline
            newLocation.setLocationDesc(scan.nextLine());
            newLocation.setHint(scan.nextLine());
         	
         	//Put the location in the hash table
            this.map.put(new Integer(newLocation.getLocationID()), newLocation);
         }
      	
      	//Close the file
         scan.close();
      }
      catch(Exception e){ //If there is a problem reading the file, program will abort
         e.printStackTrace();
         System.exit(1);
      }
   }
	
   /**
    * Hashtable accessor method.
    * @return Hashtable
    */
   public Hashtable<Integer, Location> getMap() {
      return this.map;
   }
	
   /**
    * Displays the details of the current location.
    * @param LID
	* @param npcList
	* @param itemList
    */
   public void viewLocation(int LID, NPCList npcList, ItemList itemList){
   	//Lookup and retrieve the location from the map
      Location currentLocation = this.map.get(LID);
	  ArrayList<Integer> eList = currentLocation.getEntityList(); //Entity list
	  ArrayList<Integer> stockpile = currentLocation.getItemList();
	  NPC tempNPC;
	  Item tempItem;
   	
   	//Prints the location description
	  for(int i = 0; i < 3; i++){
	     System.out.print("\n");
	  }
      System.out.println(""+currentLocation.getLocationDesc());
   	
   	//Prints out the list of exits
      System.out.print("[");
      if(currentLocation.getNorth() != 0){
         System.out.print(" N ");
      }
      if(currentLocation.getSouth() != 0){
         System.out.print(" S ");
      }
      if(currentLocation.getEast() != 0){
         System.out.print(" E ");
      }
      if(currentLocation.getWest() != 0){
         System.out.print(" W ");
      }
      if(currentLocation.getUp() != 0){
         System.out.print(" U ");
      }
      if(currentLocation.getDown() != 0){
         System.out.print(" D ");
      }
      System.out.println("]");
   	
   	/*TODO: Print entity list and stockpile*/
	  for(int i = 0; i < eList.size(); i++){
		  tempNPC = npcList.getNPC(eList.get(i));
		  System.out.println("{"+ (i+1) +"} " + tempNPC.getName() + " is here.");
	  }
	  
	  for(int i = 0; i < stockpile.size(); i++){
		  tempItem = itemList.getItem(stockpile.get(i));
		  System.out.println("("+ (i+1) +") There is a(n) [" + tempItem.getItemName() + "] on the ground.");
	  }
   }
   
   public void getHint(int LID){
	   Location currentLocation = this.map.get(LID);
	   System.out.println(currentLocation.getHint());
   }
   
   public Location getLocation(int LID){
	   return this.map.get(LID);
   }
   
   /**
    * Adds an NPC to a location.
	* @param LID
	* @param NPCID
	*/
   public void addNPC(Integer LID, Integer NPCID){
     Location location = this.map.get(LID);
     location.addToEntityList(NPCID);
   }
   
   /**
    * Adds an item to a location.
	* @param LID
	* @param itemID
	*/
   public void addItem(Integer LID, Integer itemID){
	   Location location = this.map.get(LID);
	   location.addToItemList(itemID);
   }
   
   public void fillMap(NPCList npcList, ItemList itemList){
	 //NPC ADDITIONS
	 //this.addNPC(new Integer(<Location ID>), new Integer(<NPC ID>));
	 this.addNPC(new Integer(123), new Integer(100));
	 this.addNPC(new Integer(118), new Integer(101));
	 this.addNPC(new Integer(212), new Integer(102));
	 this.addNPC(new Integer(218), new Integer(103));
	 this.addNPC(new Integer(220), new Integer(104));
	 this.addNPC(new Integer(222), new Integer(105));
	 this.addNPC(new Integer(112), new Integer(106));
	 this.addNPC(new Integer(211), new Integer(107));
	 this.addNPC(new Integer(114), new Integer(108));
	 this.addNPC(new Integer(120), new Integer(109));
	 this.addNPC(new Integer(110), new Integer(110));
	 this.addNPC(new Integer(300), new Integer(111));
	 this.addNPC(new Integer(223), new Integer(200));
	 //ITEM ADDITIONS
	 //this.addItem(new Integer(<Location ID>), new Integer(<Item ID>));
	 this.addItem(new Integer(120), new Integer(100));
	 this.addItem(new Integer(214), new Integer(100));
	 this.addItem(new Integer(113), new Integer(101));
	 this.addItem(new Integer(215), new Integer(101));
	 this.addItem(new Integer(213), new Integer(102));
	 this.addItem(new Integer(111), new Integer(102));
	 this.addItem(new Integer(124), new Integer(103));
	 this.addItem(new Integer(225), new Integer(103));
	 this.addItem(new Integer(115), new Integer(104));
	 this.addItem(new Integer(200), new Integer(104));
	 this.addItem(new Integer(100), new Integer(105));
	 this.addItem(new Integer(221), new Integer(105));
	 this.addItem(new Integer(119), new Integer(106));
	 this.addItem(new Integer(221), new Integer(106));
	 this.addItem(new Integer(100), new Integer(107));
	 this.addItem(new Integer(201), new Integer(107));
   }
}