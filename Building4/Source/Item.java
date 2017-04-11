/**
 * The Item class holds information for items such as
 * name, id, desc, level, and value.
 */

public class Item {

   private String itemName;
   private int itemID;
   private String itemDesc;
   private int itemLevel; // Power level of item
   private int itemValue; // Item's currency value

   /**
    * Default constructor.
    */
   public Item() {
      this.itemName = "";
      this.itemID = 0;
      this.itemDesc = "";
      this.itemLevel = 0;
      this.itemValue = 0;
   }

   /**
    * itemName accessor method.
    * @return String
    */
   public String getItemName() {
      return this.itemName;
   }

   /**
    * itemID accessor method.
    * @return int
    */
   public int getItemID() {
      return this.itemID;
   }

   /**
    * itemDesc accessor method.
    * @return String
    */
   public String getItemDesc() {
      return this.itemDesc;
   }

   /**
    * itemLevel accessor method.
    * @return int
    */
   public int getItemLevel() {
      return this.itemLevel;
   }

   /**
    * itemValue accessor method.
    * @return int
    */
   public int getItemValue() {
      return this.itemValue;
   }

   /**
    * itemName mutator method.
    * @param itemName
    */
   public void setItemName(String itemName) {
      this.itemName = itemName;
   }

   /**
    * itemID mutator method.
    * @param itemID
    */
   public void setItemID(int itemID) {
      this.itemID = itemID;
   }

   /**
    * itemDesc mutator method.
    * @param itemDesc
    */
   public void setItemDesc(String itemDesc) {
      this.itemDesc = itemDesc;
   }

   /**
    * itemLevel mutator method.
    * @param itemLevel
    */
   public void setItemLevel(int itemLevel) {
      this.itemLevel = itemLevel;
   }

   /**
    * itemValue mutator method.
    * @param itemValue
    */
   public void setItemValue(int itemValue) {
      this.itemValue = itemValue;
   }
}
