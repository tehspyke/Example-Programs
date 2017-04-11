import java.io.*;

public class TestClient{

   public static void main(String[] args){
      Map map = new Map();
   	
      ItemList itemList = new ItemList();
      NPCList npcList = new NPCList();
   	
      Menu theMenu = new Menu();
      theMenu.title();
      Player user = theMenu.selection(theMenu.options()); // Returns a Player
	  
	  map.fillMap(npcList, itemList);
   	
      clearScreen();
	  System.out.println("Welcome to Building 4! Type help to view a list of commands.");
	  map.viewLocation(user.getLocationID(), npcList, itemList);
      gameLoop(map, user, itemList, npcList);
   }
	
	//Game loop
   public static void gameLoop(Map map, Player user, ItemList itemList, NPCList npcList) {
      String commandLine = "";
      BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
   	
      while(true){
         System.out.print(">>>");
         try{
            commandLine = console.readLine();
         }
         catch(Exception e){
            e.printStackTrace();
            System.exit(1);
         }
      	
         if(commandLine.equals("")){
            continue;
         }
         else if(commandLine.equalsIgnoreCase("help")){
            System.out.println("****************************** LIST OF COMMANDS *******************************");
            System.out.println("clear:                                 Clears the screen by printing 50 newlines");
            System.out.println("quit:                                  Returns to the main menu");
            System.out.println("exit:                                  Closes the game");
            System.out.println("look:                                  Displays the location details");
			System.out.println("hint:                                  Displays a hint about your current location");
            System.out.println("inv:                                   Displays items in inventory");
            System.out.println("charinfo:                              Displays summary of your player");
            System.out.println("get [number of item at location]:      Picks up item");
            System.out.println("drop [number of item in inventory]:    Drop desired item from inventory");
            System.out.println("equip [number of item in inventory]:   Equip desired item from inventory");
            System.out.println("unequip:                               Unequips your currently equipped item");
            System.out.println("<N, S, E, W, U, D>:                    Move player in desired direction");
            System.out.println("save:                                  Save your player's stats");
         
                /* FINISH LIST OF COMMANDS */
         }
         else if(commandLine.equalsIgnoreCase("clear")) {
            clearScreen();
         }
         else if(commandLine.equalsIgnoreCase("quit")) {
            clearScreen();
            String[] args = {};
            main(args);
         }
         else if(commandLine.equalsIgnoreCase("exit")) {
            System.out.println("Program Terminated");
            System.exit(0);
         }
         else if(commandLine.equalsIgnoreCase("look")) {
            map.viewLocation(user.getLocationID(), npcList, itemList);
         }
         else if(commandLine.equalsIgnoreCase("charinfo")) {
            System.out.println(user.toString());
         }
         else if(commandLine.equalsIgnoreCase("n")){
            user.move(commandLine.charAt(0), map, npcList, itemList);
         }
         else if(commandLine.equalsIgnoreCase("s")){
            user.move(commandLine.charAt(0), map, npcList, itemList);
         }
         else if(commandLine.equalsIgnoreCase("e")){
            user.move(commandLine.charAt(0), map, npcList, itemList);
         }
         else if(commandLine.equalsIgnoreCase("w")){
            user.move(commandLine.charAt(0), map, npcList, itemList);
         }
         else if(commandLine.equalsIgnoreCase("u")){
            user.move(commandLine.charAt(0), map, npcList, itemList);
         }
         else if(commandLine.equalsIgnoreCase("d")){
            user.move(commandLine.charAt(0), map, npcList, itemList);
         }
         else if(commandLine.equalsIgnoreCase("save")){
        	 user.saveGame();
         }
		 else if(commandLine.equalsIgnoreCase("hint")){
			 map.getHint(user.getLocationID());
		 }
		 else if(commandLine.equalsIgnoreCase("inv")){
			 user.showInventory(itemList);
		 }
		 else if(commandLine.length() >= 5 && commandLine.substring(0,3).equalsIgnoreCase("get")){
			 try{
				 int index = Integer.parseInt(commandLine.substring(4));
				 user.grabItem(index, map);
			 }catch(Exception e){
				 System.out.println("Invalid input.");
			 }
		 }
		 else if(commandLine.length() >= 6 && commandLine.substring(0,4).equalsIgnoreCase("drop")){
			 try{
				 int index = Integer.parseInt(commandLine.substring(5));
				 user.dropItem(index, map);
			 }catch(Exception e){
				 System.out.println("Invalid input.");
			 }
		 }
		 else if(commandLine.length() >= 7 && commandLine.substring(0,5).equalsIgnoreCase("equip")){
			 try{
				 int index = Integer.parseInt(commandLine.substring(6));
				 user.equipItem(index, itemList);
			 }catch(Exception e){
				 System.out.println("Invalid input.");
			 }
		 }
		 else if(commandLine.equalsIgnoreCase("unequip")){
			 user.unequipItem(itemList);
		 }
         else{
            System.out.println("Invalid input.");
         }
      }
   }
	
   public static void clearScreen(){
      for(int i = 0; i < 50; i++){
         System.out.print("\n");
      }
   }
}
