import java.util.LinkedList;
import java.util.Scanner;

public class Rach_Linkedlist_BettingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int WINNING_NUMBER = 20;
        int PLAYERS = 100;
        @SuppressWarnings("unchecked")
        LinkedList<int[]>[] betDetails = new LinkedList[30];
        @SuppressWarnings("unchecked")
        LinkedList<int[]>[] betNumbers = new LinkedList[30]; 
        int dayCount = 1;
        int totalEarnings = 0;
        int totalPayouts = 0;
        int choice;

        for (int i = 0; i < betDetails.length; i++) {
            betDetails[i] = new LinkedList<>();
            betNumbers[i] = new LinkedList<>();
        }

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
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    boolean morePlayers = true;
                    int dayEarnings = 0;
                    int dayPayouts = 0;
                    int dailyPlayerCount = 0;

                    System.out.println("________________________________");
                    System.out.println("       Day " + dayCount);
                    System.out.println("________________________________");

                    while (morePlayers && dailyPlayerCount < PLAYERS) {
                        System.out.println("Player " + (dailyPlayerCount + 1) + ":");
                        System.out.print("How many numbers you bet: ");
                        int numBets = scanner.nextInt();

                        boolean hasDuplicateNumberBet;
                        for (int i = 0; i < numBets; i++) {
                            do {
                                hasDuplicateNumberBet = false;
                                System.out.print("Number you bet " + (i + 1) + ": ");
                                int betNumber = scanner.nextInt();

                                for (int[] bet : betNumbers[dayCount - 1]) {
                                    if (bet[0] == dailyPlayerCount && bet[1] == betNumber) {
                                        System.out.println("Duplicate number detected. Please enter a different number.");
                                        hasDuplicateNumberBet = true;
                                        break;
                                    }
                                }

                                if (!hasDuplicateNumberBet) {
                                    System.out.print("Price you bet " + (i + 1) + ": ");
                                    int betPrice = scanner.nextInt();
                                    betNumbers[dayCount - 1].add(new int[]{dailyPlayerCount, betNumber, betPrice});

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

                                    dayEarnings += betPrice;
                                }
                            } while (hasDuplicateNumberBet);
                        }

                        dailyPlayerCount++;

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
                    int result = WINNING_NUMBER;
                    System.out.println("Result = " + result);

                    boolean hasWinner = false;
                    for (int[] bet : betNumbers[dayCount - 1]) {
                        if (bet[1] == WINNING_NUMBER) {
                            int payout = bet[2] * 80;
                            for (int[] playerBet : betDetails[dayCount - 1]) {
                                if (playerBet[0] == bet[0]) {
                                    playerBet[2] += payout;
                                    break;
                                }
                            }
                            dayPayouts += payout;
                            hasWinner = true;
                        }
                    }

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

                    totalEarnings += dayEarnings;
                    totalPayouts += dayPayouts;

                    System.out.println("________________________________");
                    System.out.println("  Total amount earned from players: " + dayEarnings + "$");
                    System.out.println("  Total amount paid to winners: " + dayPayouts + "$");
                    System.out.println("________________________________");
                    System.out.println("Day " + dayCount + " end");
                    System.out.println("Press any key to continue...");
                    scanner.nextLine();
                    scanner.nextLine();

                    dayCount++;
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
        } while (choice != 3);

        scanner.close();
    }
}
