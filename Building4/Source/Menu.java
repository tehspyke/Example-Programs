import java.util.Scanner;

/**
 * This class contains the display that is presented to the user
 * when starting the game.
 */

public class Menu {

    Scanner keyboard;

    /**
     * Default constructor.
     */
    public Menu() {
        keyboard = new Scanner(System.in);
    }

    /**
     * Prints out the BUILDING 4 banner is ascii art.
     */
    public void title() {
        System.out.println(" ____        _ _     _ _               _  _");
        System.out.println("|  _ \\      (_) |   | (_)             | || |");
        System.out.println("| |_) |_   _ _| | __| |_ _ __   __ _  | || |_");
        System.out.println("|  _ <| | | | | |/ _` | | '_ \\ / _` | |__   _|");
        System.out.println("| |_) | |_| | | | (_| | | | | | (_| |    | |");
        System.out.println("|____/ \\__,_|_|_|\\__,_|_|_| |_|\\__, |    |_|");
        System.out.println("                                __/ |");
        System.out.println("                               |___/");
    }

    /**
     * Displays a list of options to the user: new game, load game,
     * and exit. 
     * @return int
     */
    public int options() {
        System.out.println("Pick what you would like to do below...\n");
        System.out.println("(1) NEW GAME");
        System.out.println("(2) LOAD GAME");
        System.out.println("(3) EXIT");
        int choice = 0;

        do {
            try {
				System.out.print(">>>");
                choice = keyboard.nextInt();
            }
            catch(Exception e) {
                System.out.println("Invalid choice, try again.");
                keyboard.nextLine();
            }
        } while(choice < 0 || choice > 3);

        return choice;
    }

    /**
     * This method is passed the choice the user selects on the menu.
     * If new game is selected, a new player is returned.
     * If load game is selected, a saved player is returned.
     * @param choice
     * @return Player
     */
    public Player selection(int choice) {
        switch(choice) {
            case 1:
            	Player newP = new Player();
            	newP.newPlayer();
                return newP;
            case 2:
            	Player loadedP = new Player();
            	loadedP.loadedPlayer();
                return loadedP;
            case 3:
				System.exit(0);
            default:
            	return null;
        }
    }
    
}
