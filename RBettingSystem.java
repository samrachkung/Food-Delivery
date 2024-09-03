import java.util.Scanner;

public class RBettingSystem {
    public static void main(String[] args) {
        int PLAYERS = 100;
        int BETS = 10;
        int WINNING_NUMBER = 20;

        int[][] betNumbers = new int[PLAYERS][BETS];
        double[][] betAmounts = new double[PLAYERS][BETS];
        int[] betCounts = new int[PLAYERS];
        int[] winnerIds = new int[PLAYERS];
        double[] winnerAmounts = new double[PLAYERS];
        int winnerCount = 0;

        Scanner scanner = new Scanner(System.in);
        int playerCount = 0;

        while (true) {
            System.out.println("Player " + (playerCount + 1) + ":");
            System.out.print("How many numbers you bet: ");
            int betCount = scanner.nextInt();
            betCounts[playerCount] = betCount;

            for (int i = 0; i < betCount; i++) {
                while (true) {
                    System.out.print("num" + (i + 1) + ": ");
                    int number = scanner.nextInt();
                    boolean duplicate = false;
                    for (int j = 0; j < i; j++) {
                        if (betNumbers[playerCount][j] == number) {
                            duplicate = true;
                            break;
                        }
                    }
                    if (duplicate) {
                        System.out.println("duplicate number");
                        continue;
                    }
                    betNumbers[playerCount][i] = number;
                    break;
                }
                System.out.print("price" + (i + 1) + ": ");
                double price = scanner.nextDouble();
                betAmounts[playerCount][i] = price;
            }

            playerCount++;
            if (playerCount >= PLAYERS) {
                break;
            }
            System.out.print("One more player (y/n): ");
            String morePlayers = scanner.next();
            if (!morePlayers.equalsIgnoreCase("y")) {
                break;
            }
        }

        System.out.println("Result= " + WINNING_NUMBER);

        for (int i = 0; i < playerCount; i++) {
            for (int j = 0; j < betCounts[i]; j++) {
                if (betNumbers[i][j] == WINNING_NUMBER) {
                    winnerIds[winnerCount] = i + 1;
                    winnerAmounts[winnerCount] = betAmounts[i][j] * 80;
                    winnerCount++;
                }
            }
        }

        if (winnerCount == 0) {
            System.out.println("No winner");
        } else {
            System.out.println("Winner list");
            System.out.println("Player\tAmount");
            for (int i = 0; i < winnerCount; i++) {
                System.out.println(winnerIds[i] + "\t" + winnerAmounts[i] + "$");
            }
        }

        scanner.close();
    }
}
