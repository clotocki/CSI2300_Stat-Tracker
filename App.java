import java.util.Scanner;
import java.util.Random;

public class App {
    static int killswitch = 0;
    static Scanner s0 = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int playerCode = 0;
        while (killswitch == 0) {
        boolean check = true;
        while (check) {
        check = false;
        System.out.println("Enter Code: ");
        System.out.println("");
        int code = s0.nextInt();
        if (code == 1) {
            System.out.println(" ");
            System.out.println(">Enter Stat Editor");
            getPlayerCode(playerCode);
            players.statEdit(playerlist.pList.get(playerCode));
        }
        else if (code == 2) {
            System.out.println("");
            System.out.println(">Enter Stat Check");
            getPlayerCode(playerCode);
            System.out.println(" ");
            System.out.println(playerlist.pList.get(playerCode));
            System.out.println(" ");
        }
        else if (code == 3) {
            System.out.println("");
            System.out.println(">Enter Player Creator");
            players myPlayer = playerlist.playerCreator();
            playerlist.addPlayer(myPlayer); 
        }
        else if (code == 827) {
            killswitch();
    }
        else {
            System.out.println("Incorrect Value");
            check = true;
        }
    }
    }
}
    static void killswitch() {
        Boolean check1 = true;
            while (check1) {
            check1 = false;
            System.out.println("Press 1 to Confirm Killswitch, Press 2 to exit Killswitch");
            System.out.println(" ");
            int Confirmcode = s0.nextInt();
            if (Confirmcode == 1) {
                killswitch++;
            }
            else if (Confirmcode == 2) {
                break;
            }
            else {
                System.out.println("Invalid Input");
                check1 = true;
            } 
        }
        }
    static void getPlayerCode(int a) {
        System.out.println("Enter player code:");
        System.out.println(" ");
        a = s0.nextInt();
    }
}
