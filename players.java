import java.util.Scanner;

//blueprint to create player objects to add to system
public class players {
    
    //player atributes system holds, all start at zero
    int playerPTS;
    //int playerAST;
    int playerRBD;
    //int playerBLK;
    //int playerSTL;
    String name;
    int playerID;

    public players(String pName, int pID) {
        name = pName;
        playerID = pID;
    }
    @Override
    //converts data to string to be held in arraylist
    public String toString() {
        return "Name: " + name + "\n Points: " + playerPTS + "\n Rebounds:" + playerRBD + "\n Player ID:" + playerID;
    }
    //function that allows users to edit that stats of players
    public static void statEdit(players inputPlayer) {
        System.out.println("Enter 1 to edit " + inputPlayer.name + "'s PTS, Enter 2 for RBDS ");
        //program takes user input to figure out what stat the user wants to edit
        Scanner myScanner = new Scanner(System.in);
        int codeEDT = myScanner.nextInt();
        //input of 1 allows users to edit points
        if (codeEDT == 1) {
            System.out.println(" ");
            System.out.println("Enter game stats: ");
            System.out.println(" ");
            int gameStat = myScanner.nextInt();
            inputPlayer.playerPTS = inputPlayer.playerPTS + gameStat;
            System.out.println(" ");
            System.out.println("Season total: " + inputPlayer.playerPTS + " pts");
        //input of 2 allows users to edit rebounds
        }
        if (codeEDT == 2) {
            System.out.println(" ");
            System.out.println("Enter game stats: ");
            System.out.println(" ");
            int gameStat = myScanner.nextInt();
            inputPlayer.playerRBD = inputPlayer.playerRBD + gameStat;
            System.out.println(" ");
            System.out.println("Season total: " + inputPlayer.playerRBD + " rebounds");
        }
        //copy and paste of above functions for blocks, steals, and assists
        //add another option that allows user to break out of stat edit function in case they made a mistake
        //ex: if (codeEDT==10) {break;}
    }
}
