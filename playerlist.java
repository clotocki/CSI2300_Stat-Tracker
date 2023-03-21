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
    
}
