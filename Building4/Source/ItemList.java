import java.util.Hashtable;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * The ItemList class holds a Hashtable
 * of 
 
 */

public class ItemList{
   protected Hashtable<Integer, Item> itemList;
	
   /**
    * Default constructor.
    */
   public ItemList(){
      this.itemList = new Hashtable<Integer, Item>(1000);
      this.initItemList();
   }
	
   /**
    * This method initializes the ItemList with
    * the data read from the designated .txt file.
    * 
    * This method throws a FileNotFound exception if
    * the designated file cannot be found on the system.
    */
   private void initItemList(){
      try{
         File itemFile = new File("itemlist.txt");
      	
         Scanner scan = new Scanner(itemFile);
      	
         while(scan.hasNextInt()){
            Item newItem = new Item();
         	
            newItem.setItemID(scan.nextInt());
            newItem.setItemLevel(scan.nextInt());
            newItem.setItemValue(scan.nextInt());
            scan.nextLine();
            newItem.setItemName(scan.nextLine());
            newItem.setItemDesc(scan.nextLine());
         	
         	
            this.itemList.put(new Integer(newItem.getItemID()), newItem);
         }
      	
      	//Close the file
         scan.close();
      }
      catch(Exception e){ //If there is a problem reading the file, program will abort
         e.printStackTrace();
         System.exit(1);
      }
   }
   
   public Item getItem(Integer itemID){
	   return this.itemList.get(itemID);
   }
   
   public void viewInvDesc(int index, Player user){
      ArrayList<Integer> inventory = user.getInventory();
      Item item = this.getItem(inventory.get(index-1));
      
      System.out.println("[" + item.getItemName() + "]\n" + item.getItemDesc() +"\n"+
                     "Attack Power: " + item.getItemLevel() +"\n" + "Value: " + item.getItemValue());
   }
   
   public void viewDesc(int index, Player user,  Map map){
       Location current = map.getLocation(user.getLocationID());
       ArrayList<Integer> stockpile = current.getItemList();
       
       Item item = this.getItem(stockpile.get(index-1));
       
       System.out.println("[" + item.getItemName() + "]\n" + item.getItemDesc() +"\n"+
                     "Attack Power: " + item.getItemLevel() +"\n" + "Value: " + item.getItemValue());
       
       
   }
  
}
