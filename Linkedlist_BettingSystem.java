import java.util.LinkedList; // Imports the LinkedList class for creating linked lists
import java.util.Scanner; // Imports the Scanner class for taking user input

// Defining the main class for the betting system
public class Linkedlist_BettingSystem {
    // The main method - entry point of the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creates a Scanner object to read input from the user
        int WINNING_NUMBER = 20; // Defines the winning number for the betting game
        int PLAYERS = 100; // Defines the maximum number of players allowed per day

        // Initializes two arrays of LinkedLists to store bet details and bet numbers
        @SuppressWarnings("unchecked")
        LinkedList<int[]>[] betDetails = new LinkedList[30];
        @SuppressWarnings("unchecked")
        LinkedList<int[]>[] betNumbers = new LinkedList[30];

        int dayCount = 1; // Tracks the current day of the betting game
        int totalEarnings = 0; // Tracks total earnings from players
        int totalPayouts = 0; // Tracks total payouts to winners
        int choice; // Stores the user's menu choice

        // Initializes each element of betDetails and betNumbers arrays with new LinkedLists
        for (int i = 0; i < betDetails.length; i++) {
            betDetails[i] = new LinkedList<>();
            betNumbers[i] = new LinkedList<>();
        }

        // Main loop for the menu system, continues until the user chooses to exit
        do {
            System.out.println("\n\n\n");
            System.out.println("________________________________");
            System.out.println("       Menu:");
            System.out.println("       1: Play");
            if (dayCount > 1) {
                System.out.println("       2: Report");
                System.out.println("       3: Exit");
                System.out.println("________________________________");
            } else {
                System.out.println("       2: Exit");
                System.out.println("________________________________");
            }
            System.out.print("Enter your Choice: ");
            choice = scanner.nextInt(); // Reads the user's menu choice

            // Switch statement to handle user's menu choice
            switch (choice) {
                case 1:
                    boolean morePlayers = true; // Flag to control player input loop
                    int dayEarnings = 0; // Tracks earnings for the current day
                    int dayPayouts = 0; // Tracks payouts for the current day
                    int dailyPlayerCount = 0; // Tracks number of players for the current day

                    System.out.println("________________________________");
                    System.out.println("       Day " + dayCount);
                    System.out.println("________________________________");

                    // Loop to handle multiple players' bets
                    while (morePlayers && dailyPlayerCount < PLAYERS) {
                        System.out.println("Player " + (dailyPlayerCount + 1) + ":");
                        System.out.print("How many numbers you bet: ");
                        int numBets = scanner.nextInt(); // Reads the number of bets the player wants to place

                        boolean hasDuplicateNumberBet;
                        // Loop to handle multiple bets for a single player
                        for (int i = 0; i < numBets; i++) {
                            do {
                                hasDuplicateNumberBet = false; // Flag to check for duplicate bet numbers
                                System.out.print("Number you bet " + (i + 1) + ": ");
                                int betNumber = scanner.nextInt(); // Reads the bet number

                                // Checks for duplicate bet numbers for the current player
                                for (int[] bet : betNumbers[dayCount - 1]) {
                                    if (bet[0] == dailyPlayerCount && bet[1] == betNumber) {
                                        System.out.println("Duplicate number detected. Please enter a different number.");
                                        hasDuplicateNumberBet = true;
                                        break;
                                    }
                                }

                                // If no duplicate bet number, proceed to read the bet price
                                if (!hasDuplicateNumberBet) {
                                    System.out.print("Price you bet " + (i + 1) + ": ");
                                    int betPrice = scanner.nextInt(); // Reads the bet price
                                    betNumbers[dayCount - 1].add(new int[]{dailyPlayerCount, betNumber, betPrice}); // Stores the bet details

                                    // Checks if the player already has bets recorded for the day, and updates the bet price
                                    boolean foundPlayer = false;
                                    for (int[] playerBet : betDetails[dayCount - 1]) {
                                        if (playerBet[0] == dailyPlayerCount) {
                                            playerBet[1] += betPrice;
                                            foundPlayer = true;
                                            break;
                                        }
                                    }
                                    if (!foundPlayer) {
                                        betDetails[dayCount - 1].add(new int[]{dailyPlayerCount, betPrice, 0});
                                    }

                                    dayEarnings += betPrice; // Updates the day's earnings
                                }
                            } while (hasDuplicateNumberBet);
                        }

                        dailyPlayerCount++; // Increments the player count

                        // Prompts the user to decide if another player will place bets
                        while (true) {
                            System.out.println("________________________________");
                            System.out.print("One more player (y/n): ");
                            char more = scanner.next().charAt(0);
                            if (more == 'y' || more == 'Y') {
                                System.out.println("________________________________");
                                break;
                            } else if (more == 'n' || more == 'N') {
                                morePlayers = false;
                                System.out.println("________________________________");
                                break;
                            } else {
                                System.out.println("Invalid choice. Please enter 'y' or 'n'.");
                                System.out.println("________________________________");
                            }
                        }
                    }

                    int result = WINNING_NUMBER; // Sets the winning number
                    System.out.println("Result = " + result);

                    boolean hasWinner = false; // Flag to check if there's a winner
                    // Checks each bet to see if there's a winner and calculates payouts
                    for (int[] bet : betNumbers[dayCount - 1]) {
                        if (bet[1] == WINNING_NUMBER) {
                            int payout = bet[2] * 80; // Calculates the payout amount
                            for (int[] playerBet : betDetails[dayCount - 1]) {
                                if (playerBet[0] == bet[0]) {
                                    playerBet[2] += payout;
                                    break;
                                }
                            }
                            dayPayouts += payout; // Updates the day's payouts
                            hasWinner = true;
                        }
                    }

                    // Displays winner information if there's a winner
                    if (!hasWinner) {
                        System.out.println("________________________________");
                        System.out.println("           No winner            ");
                        System.out.println("________________________________");
                    } else {
                        System.out.println("Winner list");
                        System.out.println("Player\tAmount");
                        for (int[] playerBet : betDetails[dayCount - 1]) {
                            if (playerBet[2] > 0) {
                                System.out.println((playerBet[0] + 1) + "\t" + playerBet[2] + "$");
                            }
                        }
                    }

                    totalEarnings += dayEarnings; // Updates total earnings
                    totalPayouts += dayPayouts; // Updates total payouts

                    System.out.println("________________________________");
                    System.out.println("  Total amount earned from players: " + dayEarnings + "$");
                    System.out.println("  Total amount paid to winners: " + dayPayouts + "$");
                    System.out.println("________________________________");
                    System.out.println("Day " + dayCount + " end");
                    System.out.println("Press any key to continue...");
                    scanner.nextLine(); // Waits for user input to continue
                    scanner.nextLine(); // Reads the newline character

                    dayCount++; // Increments the day count
                    break;

                case 2:
                    if (dayCount > 1) {
                        System.out.println("\n\n\n");
                        System.out.println("_______________________________");
                        System.out.println("           Report              ");
                        System.out.println("_______________________________");
                        for (int d = 1; d < dayCount; d++) {
                            System.out.println("Report Day " + d);
                            System.out.println("\n");
                            System.out.println("Player\tAmount+\tAmount-");
                            for (int[] playerBet : betDetails[d - 1]) {
                                System.out.println((playerBet[0] + 1) + "\t" + playerBet[1] + "\t" + playerBet[2]);
                            }
                            System.out.println("_______________________________");
                        }
                        System.out.println("Total Earnings: " + totalEarnings + "$");
                        System.out.println("Total Payouts: " + totalPayouts + "$");
                        System.out.println("_______________________________");
                    } else {
                        System.out.println("Exiting...");
                        choice = 3;
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 3); // Loop continues until the user chooses to exit

        scanner.close(); // Closes the scanner object
    }
}
