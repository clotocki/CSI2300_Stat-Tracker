import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BBallStatTracker {
    private static final String fileName = "playerStats.txt"; 
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) { 
        
        boolean exit = false;

        while (exit == false) { // lets the user choose which function they want to do
            System.out.println("\nChoose an option:");
            System.out.println("1. Create player");
            System.out.println("2. Update player stats");
            System.out.println("3. View player stats");
            System.out.println("4. Player ID log");
            // System.out.println("5. Delete players"); BUGGED
            System.out.println("0. Exit");

            System.out.print("--> ");
            int choice = input.nextInt(); 
            input.nextLine();

            // uses user input to decided which task to perform
            switch (choice) {
                case 1:
                    createPlayer();
                    break;
                case 2:
                    updatePlayerStats();
                    break;
                case 3:
                    viewPlayerStats();
                    break;
                case 4:
                    viewPlayerIds();
                    break;
                /*case 5: 
                    deletePlayer();
                    break; */ 
                case 0:
                    exit = true;
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

    private static void createPlayer() { // makes player and assigns them their stats
        System.out.println("Enter player name:"); 
        String name = input.nextLine();

        int points = getStat("points");
        int rebounds = getStat("rebounds");
        int assists = getStat("assists");
        int blocks = getStat("blocks");
        int steals = getStat("steals");

        int id = getNextPlayerId(); // uses that method to use the next available ID

        // this is the format that the data is stored in the text file
        String playerData = String.format("%d,%s,%d,%d,%d,%d,%d", id, name, points, rebounds, assists, blocks, steals);

        try { // writes the above info in that format to the text file
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            if (new File(fileName).length() > 0) { 
                writer.newLine();
            }

            writer.write(playerData);
            writer.close();

            System.out.println("Player created successfully! ID: " + id);
        } 
        catch (IOException e) { // for errors
            System.out.println("An unexpected error occurred while creating player: " + e.getMessage());
        }
    }

    // used in createPlayer to simplify getting each stat from the user when making player
    private static int getStat(String statName) {
        System.out.println("Enter " + statName + ":");
        return input.nextInt();
    }

    private static void updatePlayerStats() { // lets you update player stats
        System.out.println("Enter player ID:");
        System.out.print("--> ");
        int id = input.nextInt();
        input.nextLine();

        try { // this updates the data from the file and has user input the new stats
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuffer buffer = new StringBuffer();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int playerId = Integer.parseInt(parts[0]);

                if (playerId == id) {
                    int points = getStat("points");
                    int rebounds = getStat("rebounds");
                    int assists = getStat("assists");
                    int blocks = getStat("blocks");
                    int steals = getStat("steals");

                    // formats the string when putting it into the text file
                    String updatedPlayerData = String.format("%d,%s,%d,%d,%d,%d,%d", id, parts[1], points, rebounds, assists, blocks, steals);

                    buffer.append(updatedPlayerData);
                } 
                else {
                    buffer.append(line);
                }

                buffer.append("\n"); // new line in the next file
            }

            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(buffer.toString());
            writer.close();

            System.out.println("Player stats updated successfully!");
        } 
        catch (IOException e) {
            System.out.println("An unexpected error occurred while updating player stats: " + e.getMessage());
        }
    }

    private static void viewPlayerStats() { // lets user input an ID and view stats of that player
        System.out.println("Enter player ID:");
        System.out.print("--> ");
        int id = input.nextInt();
        input.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            boolean foundPlayer = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int playerId = Integer.parseInt(parts[0]);

                if (playerId == id) {
                    System.out.println("\nPlayer ID: " + parts[0]);
                    System.out.println("Player Name: " + parts[1]);
                    System.out.println("Points: " + parts[2]);
                    System.out.println("Rebounds: " + parts[3]);
                    System.out.println("Assists: " + parts[4]);
                    System.out.println("Blocks: " + parts[5]);
                    System.out.println("Steals: " + parts[6]);
                    foundPlayer = true;
                    break;
                }
            }

            reader.close();

            if (!foundPlayer) { // when ID is not in the system
                System.out.println("Player not found.");
            }
        } 
        catch (IOException e) {
            System.out.println("An error occurred while viewing player stats: " + e.getMessage());
        }
    }

    private static int getNextPlayerId() {
        int nextId = 1;
    
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
    
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int playerId = Integer.parseInt(parts[0]);
    
                if (playerId >= nextId) {
                    nextId = playerId + 1;
                }
            }
    
            reader.close();
        } catch (FileNotFoundException e) {
            // ignore, file will be created when first player is added
        } catch (IOException e) {
            System.out.println("An unexpected error occurred while getting next player ID: " + e.getMessage());
        }
    
        return nextId;
    }
    
    private static void viewPlayerIds() { // lets user view all player IDs their player names
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            System.out.println("\nPlayer ID Log:");
    
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.println(parts[0] + ": " + parts[1]);
            }
    
            reader.close();
        } catch (IOException e) {
            System.out.println("An unexpected error occurred while viewing the player ID log: " + e.getMessage());
        }
    }
    
    // getting a bug when I try to use viewPlayerIds() after i delete a player
   /* private static void deletePlayer() { // lets you delete a player by ID
        System.out.println("Enter player ID to delete:");
        System.out.print("--> ");
        int id = input.nextInt();
        input.nextLine();
    
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuffer buffer = new StringBuffer();
            String line;
    
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int playerId = Integer.parseInt(parts[0]);
    
                if (playerId != id) { 
                    buffer.append(line);
                    buffer.append("\n"); // new line in the next line of text file
                }
            }
    
            reader.close();
    
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(buffer.toString());
            writer.close();
    
            System.out.println("Player with ID " + id + " has been deleted.");
        } catch (IOException e) {
            System.out.println("An unexpected error occurred while deleting player: " + e.getMessage());
        }
    } */
}
