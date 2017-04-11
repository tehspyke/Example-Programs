import java.util.Hashtable;
import java.io.File;
import java.util.Scanner;

/**
 * The NPCList class contains a Hashtable that
 * pairs NPCIDs with the NPCs themselves.
 */

public class NPCList{
   protected Hashtable<Integer, NPC> npcList;
	
   /**
    * Default constructor.
    */
   public NPCList(){
      this.npcList = new Hashtable<Integer, NPC>(1000);
      this.initNPCList();
   }
	
   /**
    * This method initializes the NPCList according
    * to the data read from the designated file.
    * 
    * If the file is not found, an exception is thrown.
    */
   private void initNPCList(){
      try{
         File npcFile = new File("npcs.txt");
      	
         Scanner scan = new Scanner(npcFile);
      	
         while(scan.hasNextInt()){
            NPC newNPC = new NPC();
         	
            newNPC.setNPCID(scan.nextInt());
            newNPC.setLocationID(scan.nextInt());
            newNPC.setAttPower(scan.nextInt());
            newNPC.setHealth(scan.nextInt());
            newNPC.setEquippedItem(scan.nextInt());
            newNPC.addToInventory(scan.nextInt());
            scan.nextLine();
            newNPC.setName(scan.nextLine());
            newNPC.addQuote(scan.nextLine());
            newNPC.addQuote(scan.nextLine());
            newNPC.addQuote(scan.nextLine());
         	
            this.npcList.put(new Integer(newNPC.getNPCID()), newNPC);
         }
      	
      	//Close the file
         scan.close();
      }
      catch(Exception e){ //If there is a problem reading the file, program will abort
         e.printStackTrace();
         System.exit(1);
      }
   }
   
   public NPC getNPC(Integer NPCID){
	   return this.npcList.get(NPCID);
   }
}
