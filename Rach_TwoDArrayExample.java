import java.util.Scanner;

public class Rach_TwoDArrayExample {
    public static void main(String[] args) {
      
        int[][] array = new int[3][3];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 9 integers for the 2D array:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("The 2D array is:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
