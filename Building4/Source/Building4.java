/**
 * Main class file for Building 4. Contains the main method and game loop.
 */

import java.io.*;

public class Building4{

	public static void main(String[] args){
		//Creates the game objects
		Map map = new Map();
		ItemList itemList = new ItemList();
		NPCList npcList = new NPCList();
		Menu theMenu = new Menu();
		
		//Prints out an ASCII art title for the game
		theMenu.title();
		
		//Returns a player object based on the menu selections
		Player user = theMenu.selection(theMenu.options());

		//Populates the map with NPCs and items
		map.fillMap(npcList, itemList);

		//Clears the screen and prints an initial greeting
		clearScreen();
		System.out.println("Welcome to Building 4! Type help to view a list of commands.");
		
		//Prints out the location info for the player object and runs the game loop
		map.viewLocation(user.getLocationID(), npcList, itemList);
		gameLoop(map, user, itemList, npcList);
	}

//Game loop (Needs refactoring)
public static void gameLoop(Map map, Player user, ItemList itemList, NPCList npcList) {
	String commandLine = "";
	BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

	while(true){
		//Get input
		System.out.print(">>>");
		try{
			commandLine = console.readLine();
		}
		catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
		
		//Parse input
		if(commandLine.equals("")){
			continue;
		}
		
		else if(commandLine.equalsIgnoreCase("help")){
			System.out.println("****************************** LIST OF COMMANDS *******************************");
			System.out.println("<N, S, E, W, U, D>:                    Move player in desired direction");
			System.out.println("clear:                                 Clears the screen");
			System.out.println("quit:                                  Returns to the main menu");
			System.out.println("exit:                                  Closes the game");
			System.out.println("save:                                  Save your player's stats");
			System.out.println("look:                                  Displays the location details");
			System.out.println("hint:                                  Displays a hint about your current location");
			System.out.println("inv:                                   Displays items in inventory");
			System.out.println("charinfo:                              Displays summary of your player");
			System.out.println("get [item index]:      				   Picks up item");
			System.out.println("drop [item index]:    				   Drop desired item from inventory");
			System.out.println("equip [item index]:   				   Equip desired item from inventory");
			System.out.println("unequip:                               Unequips your currently equipped item");
			System.out.println("invdesc [item index]:  				   View item description within inventory");
			System.out.println("desc [item index]:    				   View item description for item on ground");
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
		
		else if(commandLine.length() >=9 && commandLine.substring(0,7).equalsIgnoreCase("invdesc")){
			try{
				int index = Integer.parseInt(commandLine.substring(8));
				itemList.viewInvDesc(index, user);
			}catch(Exception e){
				System.out.println("Invalid input.");
			}
		}
		
		else if(commandLine.length() >= 6 && commandLine.substring(0,4).equalsIgnoreCase("desc")){
			try {
				int index = Integer.parseInt(commandLine.substring(5));
				itemList.viewDesc(index, user, map);
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

	//Prints newlines to clear off the terminal
	public static void clearScreen(){
		for(int i = 0; i < 50; i++){
			System.out.print("\n");
		}
	}
}
