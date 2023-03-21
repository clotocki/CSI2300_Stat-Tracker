import java.util.ArrayList;
import java.util.Scanner;

public class playerlist {
    //creates arraylist to hold player data
    static ArrayList<players> pList = new ArrayList<>();
    //player id corresponds to index in arraylist
    static int playID = 0;
    
    //function takes inputed player and adds them to array list, also printing it out to display
    static void addPlayer(players exPlayer) {
        pList.add(exPlayer);
        System.out.println(pList.toString());
        System.out.println(" ");
    }
     
    //function to add players into system
     static players playerCreator() {
        String name;

        Scanner s0 = new Scanner(System.in);

        System.out.println("Enter Player Name:");
        System.out.println(" ");
        name = s0.nextLine();

        players newPlayers = new players(name, playID);
        playID++;

        System.out.println(" ");
        System.out.println("New Player Added!");
        System.out.println(" ");

        return newPlayers;
    }
    
    //need function that writes arraylist input to txt file, should be automatic after player is entered into system, this is how we'll save the information when users exit program
    
    //need function that copies information from txt file line by line to arraylist as soon as program starts; this will allow previous inputs to be added back to arraylist, allowing their stats to be edited again
    
    //im assuming these functions will probably go here since it has to do with arraylist, but work on this outside the projects code and when you get it implement it here
    
    
}
