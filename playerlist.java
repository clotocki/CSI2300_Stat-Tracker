import java.util.ArrayList;
import java.util.Scanner;

public class playerlist {
    static ArrayList<players> pList = new ArrayList<>();
    static int playID = 0;

    static void addPlayer(players exPlayer) {
        pList.add(exPlayer);
        System.out.println(pList.toString());
        System.out.println(" ");
    }

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
