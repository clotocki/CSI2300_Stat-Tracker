import java.util.Scanner;

public class players {
    
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
    public String toString() {
        return "Name: " + name + "\n Points: " + playerPTS + "\n Rebounds:" + playerRBD + "\n Player ID:" + playerID;
    }
    public static void statEdit(players inputPlayer) {
        System.out.println("Enter 1 to edit " + inputPlayer.name + "'s PTS, Enter 2 for RBDS ");
        Scanner myScanner = new Scanner(System.in);
        int codeEDT = myScanner.nextInt();
        if (codeEDT == 1) {
            System.out.println(" ");
            System.out.println("Enter game stats: ");
            System.out.println(" ");
            int gameStat = myScanner.nextInt();
            inputPlayer.playerPTS = inputPlayer.playerPTS + gameStat;
            System.out.println(" ");
            System.out.println("Season total: " + inputPlayer.playerPTS + " pts");
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
    }
}
