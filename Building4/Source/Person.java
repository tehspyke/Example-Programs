import java.util.ArrayList;

/**
 * The Person class contains attributes such as name,
 * inventory, locationID, attPower, health, and equippedItems.
 * 
 * The person class is inherited both by NPCs and Players.
 */

public class Person {
	//Instance variables
   protected String name;
   protected ArrayList<Integer> inventory;
   protected int locationID;
   protected int attPower;
   protected int health;
   protected int equippedItem;
    
   /**
    * Default constructor.
    */
   public Person() {
      this.name = "";
      this.inventory = new ArrayList<Integer>(0);
      this.locationID = 0;
      this.attPower = 0;
      this.health = 100;
      this.equippedItem = 0;
   }
	
   /**
    * Parameterized constructor.
    * @param name
    */
   public Person(String name) {
      this.name = name;
   }
	
   /**
    * Name accessor method.
    * @return String
    */
   public String getName(){
      return this.name;
   }
	
   /**
    * Name mutator method.
    * @param name
    */
   public void setName(String name){
      this.name = name;
   }
	
   /**
    * Inventory (add) mutator method.
    * @param itemID
    */
   public void addToInventory(int itemID) {
      this.inventory.add(itemID);
   }
    
   /**
    * Inventory (remove) mutator method.
    * @param itemID
    */
   public void rmFromInventory(int itemID) {
      this.inventory.remove(this.inventory.indexOf(itemID));
   }
   
   public ArrayList<Integer> getInventory(){
	   return this.inventory;
   }
	
   /**
    * LocationID accessor method.
    * @return int
    */
   public int getLocationID() {
      return this.locationID;
   }
	
   /**
    * LocationID mutator method.
    * @param locationID
    */
   public void setLocationID(int locationID) {
      this.locationID = locationID;
   }
	
   /**
    * AttPower accessor method.
    * @return int
    */
   public int getAttPower() {
      return this.attPower;
   }
	
   /**
    * AttPower mutator method.
    * @param attPower
    */
   public void setAttPower(int attPower) {
      this.attPower = attPower;
   }
	
   /**
    * Health accessor method.
    * @return int
    */
   public int getHealth() {
      return this.health;
   }
	
   /**
    * Health mutator method.
    * @param hp
    */
   public void setHealth(int hp) {
      this.health = hp;
   }
	
   /**
    * EquippedItem accessor method.
    * @return int
    */
   public int getEquippedItem(){
      return this.equippedItem;
   }
	
   /**
    * EquippedItem mutator method.
    * @param itemID
    */
   public void setEquippedItem(int itemID){
      this.equippedItem = itemID;
   }
}
