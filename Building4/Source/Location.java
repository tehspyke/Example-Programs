import java.util.ArrayList;

/**
 * Holds details for location such as exits, locationID, description,
 * entities present, and items present.
 */
public class Location {

   private ArrayList<Integer> entityList;
   private ArrayList<Integer> stockpile;
   private int locationID;
   private String locationDesc;
   private String hint; // Narration and tips
   private boolean visited;
   private int north;
   private int south;
   private int east;
   private int west;
   private int up;
   private int down;

	/**
	 * Default constructor.
	 */
   public Location() {
      this.entityList = new ArrayList<Integer>(0);
      this.stockpile = new ArrayList<Integer>(0);
      this.locationID = 0;
      this.locationDesc = "";
      this.hint = "";
      this.visited = false;
   	
      this.north = 0;
      this.south = 0;
      this.east = 0;
      this.west = 0;
      this.up = 0;
      this.down = 0;
   }

    /**
     * entityList accessor method.
     * @return ArrayList
     */
   public ArrayList<Integer> getEntityList() {
      return this.entityList;
   }

    /**
     * itemList accessor method.
     * @return ArrayList
     */
   public ArrayList<Integer> getItemList() {
      return this.stockpile;
   }

    /**
     * locationID accessor method.
     * @return int
     */
   public int getLocationID() {
      return this.locationID;
   }

    /**
     * locationDesc accessor method.
     * @return String
     */
   public String getLocationDesc() {
      return this.locationDesc;
   }

    /**
     * hint accessor method.
     * @return String
     */
   public String getHint() {
      return this.hint;
   }

    /**
     * visited accessor method.
     * @return boolean
     */
   public boolean getVisited() {
      return this.visited;
   }
	
    /**
     * north accessor method.
     * @return int
     */
   public int getNorth(){
      return this.north;
   }
	
	/**
	 * south accessor method.
	 * @return int
	 */
   public int getSouth(){
      return this.south;
   }
	
	/**
	 * east accessor method.
	 * @return int
	 */
   public int getEast(){
      return this.east;
   }
	
	/**
	 * west accessor method.
	 * @return int
	 */
   public int getWest(){
      return this.west;
   }
	
	/**
	 * up accessor method.
	 * @return int
	 */
   public int getUp(){
      return this.up;
   }
	
	/**
	 * down accessor method.
	 * @return int
	 */
   public int getDown(){
      return this.down;
   }
	
	/*Setters*/
   /**
    * entityList (add) mutator method.
    * Adds a person to the entityList.
    * @param aPerson
    */
   public void addToEntityList(Integer aPerson) {
      this.entityList.add(aPerson); // Fixed for ArrayList
   }
    
   /**
    * entityList (remove) mutator method.
    * Removes a person from the entityList.
    * @param aPerson
    */
   public void rmFromEntityList(Integer aPerson) {
      this.entityList.remove(aPerson);
   }

   /**
    * itemList (add) mutator method.
    * Adds an item to the itemList.
    * @param anItem
    */
   public void addToItemList(Integer anItem) {
      this.stockpile.add(anItem); // Fixed for ArrayList
   }
    
   /**
    * itemList (remove) mutator method.
    * Removes an item from the itemList.
    * @param anItem
    */
   public void rmFromItemList(Integer anItem) {
      this.stockpile.remove(anItem);
   }
    
   /**
    * locationID mutator method.
    * @param locationID
    */
   public void setLocationID(int locationID) {
      this.locationID = locationID;
   }

   /**
    * locationDesc mutator method.
    * @param locationDesc
    */
   public void setLocationDesc(String locationDesc) {
      this.locationDesc = locationDesc;
   }

   /**
    * hint mutator method.
    * @param hint
    */
   public void setHint(String hint) {
      this.hint = hint;
   }

   /**
    * visited mutator method.
    * @param visited
    */
   public void setVisited(boolean visited) {
      this.visited = visited;
   }
	
   /**
    * north mutator method.
    * @param north
    */
   public void setNorth(int north){
      this.north = north;
   }
	
   /**
    * south mutator method.
    * @param south
    */
   public void setSouth(int south){
      this.south = south;
   }
	
   /**
    * east mutator method.
    * @param east
    */
   public void setEast(int east){
      this.east = east;
   }
	
   /**
    * west mutator method.
    * @param west
    */
   public void setWest(int west){
      this.west = west;
   }
	
   /**
    * up mutator method.
    * @param up
    */
   public void setUp(int up){
      this.up = up;
   }
	
   /**
    * down mutator method.
    * @param down
    */
   public void setDown(int down){
      this.down = down;
   }

}
