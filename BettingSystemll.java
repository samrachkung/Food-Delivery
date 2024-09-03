import java.util.Scanner;

public class BettingSystemll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int WINNING_NUMBER = 20;
        int MAX_PLAYERS = 100;
        int[][][] playersBets = new int[30][MAX_PLAYERS][3]; // Store bets: [day][player][{total bet amount, bet number, payout}]
        
        int dayCount = 1;
        int totalEarnings = 0;
        int totalPayouts = 0;

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1: Play");
            if (dayCount > 1) {
                System.out.println("2: Report");
                System.out.println("3: Exit");
            } else {
                System.out.println("2: Exit");
            }
            System.out.print("Enter your Choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    boolean morePlayers = true;
                    int dayEarnings = 0;
                    int dayPayouts = 0;
                    int dailyPlayerCount = 0;

                    System.out.println("_________________");
                    System.out.println("Day " + dayCount);
                    System.out.println("_________________");

                    while (morePlayers && dailyPlayerCount < MAX_PLAYERS) {
                        System.out.println("Player " + (dailyPlayerCount + 1) + ":");
                        System.out.print("How many numbers you bet: ");
                        int numBets = scanner.nextInt();

                        int[] betNumbers = new int[numBets];
                        boolean hasDuplicate = false;

                        for (int i = 0; i < numBets; i++) {
                            do {
                                hasDuplicate = false;
                                System.out.print("numbers you bet " + (i + 1) + ": ");
                                int betNumber = scanner.nextInt();

                                for (int j = 0; j < i; j++) {
                                    if (betNumbers[j] == betNumber) {
                                        System.out.println("Duplicate number detected. Please enter a different number.");
                                        hasDuplicate = true;
                                        break;
                                    }
                                }

                                if (!hasDuplicate) {
                                    betNumbers[i] = betNumber;
                                    System.out.print("price you bet " + (i + 1) + ": ");
                                    int betPrice = scanner.nextInt();

                                    playersBets[dayCount - 1][dailyPlayerCount][0] += betPrice;
                                    playersBets[dayCount - 1][dailyPlayerCount][1] = betNumber;
                                    dayEarnings += betPrice;
                                }
                            } while (hasDuplicate);
                        }

                        dailyPlayerCount++;

                        while (true) {
                            System.out.println("________________________________");
                            System.out.print("One more player (y/n): ");
                            char more = scanner.next().toLowerCase().charAt(0);
                            System.out.println("________________________________");
                            if (more == 'y') {
                                break;
                            } else if (more == 'n') {
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
                    for (int i = 0; i < dailyPlayerCount; i++) {
                        if (playersBets[dayCount - 1][i][1] == WINNING_NUMBER) {
                            int payout = playersBets[dayCount - 1][i][0] * 80;
                            playersBets[dayCount - 1][i][2] = payout;
                            dayPayouts += payout;
                            hasWinner = true;
                        }
                    }

                    if (!hasWinner) {
                        System.out.println("________________________________");
                        System.out.println("           No winner            ");
                        System.out.println("________________________________");
                    } else {
                        System.out.println("________________________________");
                        System.out.println("Winner list");
                        System.out.println("Player\tAmount");
                        for (int i = 0; i < dailyPlayerCount; i++) {
                            if (playersBets[dayCount - 1][i][2] > 0) {
                                System.out.println((i + 1) + "\t" + playersBets[dayCount - 1][i][2] + "$");
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
                        System.out.println("_______________________________");
                        System.out.println("           Report              ");
                        System.out.println("_______________________________");
                        for (int d = 1; d < dayCount; d++) {
                            System.out.println("Report Day " + d);
                            System.out.println("________________________________");
                            System.out.println("Player\tAmount+\tAmount-");
                            for (int i = 0; i < MAX_PLAYERS; i++) {
                                if (playersBets[d - 1][i][0] > 0) {
                                    System.out.println((i + 1) + "\t" + playersBets[d - 1][i][0] + "\t"
                                            + (playersBets[d - 1][i][2] > 0 ? playersBets[d - 1][i][2] : 0));
                                }
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
