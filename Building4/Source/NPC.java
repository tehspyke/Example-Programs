import java.util.ArrayList;

/**
 * The NPC class extends the attributes of Person.
 * An NPC object contains the NPCID and an ArrayList of quotes.
 */

public class NPC extends Person {
   private int NPCID;
   private ArrayList<String> quotes; // Things the NPC can say

   /**
    * Default constructor.
    */
   public NPC() {
      super();
      this.quotes = new ArrayList<String>(0);
      this.NPCID = 0;
   }
	
   /**
    * NPCID accessor method.
    * @return int
    */
   public int getNPCID(){
      return this.NPCID;
   }
	
   /**
    * NPCID mutator method.
    * @param ID
    */
   public void setNPCID(int ID){
      this.NPCID = ID;
   }

   /**
    * Quotes accessor method.
    * @return ArrayList
    */
   public ArrayList<String> getQuotes() {
      return this.quotes;
   }

   /**
    * Quotes mutator method.
    * @param quote
    */
   public void addQuote(String quote) {
      this.quotes.add(quote);
   }
}
