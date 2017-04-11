import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * The Player class is inherited from Person
 * and contains additional attributes such as
 * gender and boolean labeling if they are in
 * combat or not.
 */

public class Player extends Person {
	//Instance variables
   private char gender;
   private boolean inCombat;

   /**
    * Default constructor.
    */
   public Player() {
      super();
      this.gender = 'N';
      this.inCombat = false;
   }
    
   /**
    * Parameterized constructor.
    * @param name
    * @param gender
    */
   public Player(String name, char gender) {
      super(name);
      this.gender = gender;
   }

   /**
    * Gender accessor method.
    * @return char
    */
   public char getGender() {
      return this.gender;
   }
	
   /**
    * Gender mutator method.
    * @param gender
    */
   public void setGender(char gender) {
      this.gender = gender;
   }

   /**
    * InCombat accessor method.
    * @return boolean
    */
   public boolean getInCombat() {
      return this.inCombat;
   }
	
   /**
    * InCombat mutator method.
    * @param inCombat
    */
   public void setInCombat(boolean inCombat) {
      this.inCombat = inCombat;
   }
	
   /**
    * This method allows the player's location to
    * be changed to an adjacent location if available.
    * @param dir
    * @param map
    */
   public void move(char dir, Map map, NPCList npcList, ItemList itemList) {
      Location currentLoc = map.getMap().get(this.locationID);
      if(dir == 'n' || dir == 'N') {
         if(currentLoc.getNorth() != 0) {
            this.locationID = currentLoc.getNorth();
            map.viewLocation(this.locationID, npcList, itemList);
         }
         else{
            System.out.println("No exit in that direction.");
         }
      }
      else if(dir == 's' || dir == 'S') {
         if(currentLoc.getSouth() != 0) {
            this.locationID = currentLoc.getSouth();
            map.viewLocation(this.locationID, npcList, itemList);
         }
         else{
            System.out.println("No exit in that direction.");
         }
      }
      else if(dir == 'e' || dir == 'E') {
         if(currentLoc.getEast() != 0) {
            this.locationID = currentLoc.getEast();
            map.viewLocation(this.locationID, npcList, itemList);
         }
         else{
            System.out.println("No exit in that direction.");
         }
      }
      else if(dir == 'w' || dir == 'W') {
         if(currentLoc.getWest() != 0) {
            this.locationID = currentLoc.getWest();
            map.viewLocation(this.locationID, npcList, itemList);
         }
         else{
            System.out.println("No exit in that direction.");
         }
      }
      else if(dir == 'u' || dir == 'U') {
         if(currentLoc.getUp() != 0) {
            this.locationID = currentLoc.getUp();
            map.viewLocation(this.locationID, npcList, itemList);
         }
         else{
            System.out.println("No exit in that direction.");
         }
      }
      else if(dir == 'd' || dir == 'D') {
         if(currentLoc.getDown() != 0) {
            this.locationID = currentLoc.getDown();
            map.viewLocation(this.locationID, npcList, itemList);
         }
         else{
            System.out.println("No exit in that direction.");
         }
      }
      else{
         System.out.println("Invalid input.");
      }
   }
	//Methods
	//Creates a new player
   public void newPlayer() {
      Scanner keyboard = new Scanner(System.in);
    	
      System.out.println("NEW CHARACTER CREATION");
      System.out.print("Enter character name: ");
      this.name = keyboard.next();
      System.out.print("Is your character male or female? Type M or F: ");
      this.gender = keyboard.next().charAt(0);
    	
      this.locationID = 119;
   	
   }
   
   /**
    * Saves the state of the game
    */
   public void saveGame() {
	   try {
		   PrintWriter pw = new PrintWriter("save.txt");
		   pw.println(this.name);
		   pw.println(this.inventory.size());
		   for(int i = 0; i < this.inventory.size(); i++) {
			   pw.println(this.inventory.get(i));
		   }
		   pw.println(this.locationID);
		   pw.println(this.attPower);
		   pw.println(this.health);
		   pw.println(this.equippedItem);
		   pw.println(this.gender);
		   pw.flush();
		   System.out.println("Game saved.");
		   pw.close();
	   }
	   catch(Exception e) {
		   System.out.println("Error saving game. Save file not found.");
		   e.printStackTrace();
		   System.exit(1);
	   }
   }
   
   public void loadedPlayer() {
	   try{
		   File saveFile = new File("save.txt");
		   Scanner scan = new Scanner(saveFile, "UTF-8");
		   this.name = scan.nextLine();
		   int inventorySize = scan.nextInt();
		   for(int i = 0; i < inventorySize; i++) {
			   scan.nextLine();
			   this.inventory.add(scan.nextInt());
		   }
		   scan.nextLine();
		   this.locationID = scan.nextInt();
		   scan.nextLine();
		   this.attPower = scan.nextInt();
		   scan.nextLine();
		   this.health = scan.nextInt();
		   scan.nextLine();
		   this.equippedItem = scan.nextInt();
		   scan.nextLine();
		   this.gender = scan.nextLine().charAt(0);
		   scan.close();
	   }
	   catch(Exception e) { //If there is a problem reading the file, program will abort
		   e.printStackTrace();
		   System.exit(1);
	   }
   }
    
    /**
     * Displays a summary of the Player info
     * @return String
     */
   public String toString() {
	   String retVal;
	  if(this.attPower == 69){
		retVal = "Name: "   + this.name     + "\n" +
         	     "Gender: " + this.gender   + "\n" +
         	     "Health: " + this.health   + "\n" +
			     "Attack power: " + this.attPower + " (lol, nice bro)\n";
	  }
	  else{
		  retVal = "Name: "   + this.name     + "\n" +
         	 "Gender: " + this.gender   + "\n" +
         	 "Health: " + this.health   + "\n" +
			 "Attack power: " + this.attPower + "\n";
	  }
      return retVal;
   }
   
   public void showInventory(ItemList itemList){
	   ArrayList<Integer> inv = this.getInventory();
	   Item tempItem;
	   
	   System.out.print("Equipped: ["); 
	   if(this.equippedItem == 0){
		   System.out.println("N/A]");
	   }
	   else{
		   tempItem = itemList.getItem(this.equippedItem);
		   System.out.println(tempItem.getItemName() + "]");
	   }
	   System.out.println("Inventory items:");
	   
	   for(int i=0; i < inv.size(); i++){
		   tempItem = itemList.getItem(inv.get(i));
		   System.out.println("(" + (i+1) + ") [" + tempItem.getItemName() + "]");
	   }
   }
   
   public void equipItem(int index, ItemList itemList){
	   Item currentItem;
	   
	   if(index <= 0 || index - 1 > this.inventory.size()){
		   System.out.println("Invalid item index.");
	   }
	   else{		   
		   if(this.equippedItem != 0){ //If there is already an equipped item
			   //Remove the power from the old item
			   currentItem = itemList.getItem(new Integer(this.equippedItem));
			   this.attPower -= currentItem.getItemLevel();
			   
			   int temp = this.equippedItem;
			   this.equippedItem = this.inventory.get(index-1); //Updates the equipped item
			   
			   //Add the power of the new item
			   currentItem = itemList.getItem(new Integer(this.equippedItem));
			   this.attPower += currentItem.getItemLevel();
			   
			   this.rmFromInventory(this.inventory.get(index-1)); //Removes the item from inventory
			   this.addToInventory(temp); //Places the old item into inventory
			   
			   System.out.println("Item equipped. Previous equipped item moved to inventory.");
		   }
		   else{ //There is not a currently equipped item
			   this.equippedItem = this.inventory.get(index-1); //Update the equipped item
			   
			   //Add the power of the new item
			   currentItem = itemList.getItem(new Integer(this.equippedItem));
			   this.attPower += currentItem.getItemLevel();
			   
			   this.rmFromInventory(this.inventory.get(index-1)); //Removes the item from inventory
			   System.out.println("Item equipped.");
		   }
	   }
   }
   
   public void unequipItem(ItemList itemList){
	   Item currentItem;
	   
	   if(this.equippedItem == 0){
		   System.out.println("You do not have anything equipped.");
	   }
	   else{
		   //Remove the power from the old item
		   currentItem = itemList.getItem(new Integer(this.equippedItem));
		   this.attPower -= currentItem.getItemLevel();
		   
		   addToInventory(this.equippedItem);
		   this.equippedItem = 0;
		   System.out.println("Item unequipped.");
	   }
   }
   
   public void grabItem(int index, Map map){
	   Location currentLocation = map.getLocation(this.locationID);
	   ArrayList<Integer> currentStockpile = currentLocation.getItemList();
	   
	   if(index <= 0 || index - 1 > currentStockpile.size()){
		   System.out.println("Invalid item index.");
	   }
	   else{
		   this.addToInventory(currentStockpile.get(index-1));
		   currentLocation.rmFromItemList(new Integer(currentStockpile.get(index-1)));
		   System.out.println("Item grabbed.");
	   }
   }
   
   public void dropItem(int index, Map map){
	   Location currentLocation = map.getLocation(this.locationID);
	   if(this.inventory.size() == 0){
		   System.out.println("You have nothing in your inventory to drop.");
	   }
	   else if(index <= 0 || index - 1 > this.inventory.size()){
		   System.out.println("Invalid item index.");
	   }
	   else{
		   currentLocation.addToItemList(new Integer(this.inventory.get(index-1)));
		   this.rmFromInventory(this.inventory.get(index-1));
		   System.out.println("Item dropped.");
	   }
   }
}
