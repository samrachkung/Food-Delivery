import java.util.Random;
import java.util.Scanner;

public class Rach_homework_Random2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = -1, cols = -1;

        while (rows < 0 || rows > 100) {
            System.out.print("Enter the number of rows (0-100): ");
            rows = scanner.nextInt();
            if (rows < 0 || rows > 100) {
                System.out.println("Invalid input. Please enter a number between 0 and 100.");
            }
        }

        while (cols < 0 || cols > 100) {
            System.out.print("Enter the number of columns (0-100): ");
            cols = scanner.nextInt();
            if (cols < 0 || cols > 100) {
                System.out.println("Invalid input. Please enter a number between 0 and 100.");
            }
        }

        int[][] array = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter the number for position (" + "Row : "+ i + ", " + "Col : " + j + "): ");
                array[i][j] = scanner.nextInt();
            }
        }

        Random rand = new Random();
        int randomRow = rand.nextInt(rows);
        int randomCol = rand.nextInt(cols);

        System.out.println("Randomly selected number: " + array[randomRow][randomCol]);

        scanner.close();
    }
}
