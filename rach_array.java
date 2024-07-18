import java.util.Scanner;

public class rach_array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[5];
        int[] nmber = new int[5];
        nmber[0] = 10;
        nmber[1] = 20;
        nmber[2] = 30;
        nmber[3] = 40;
        nmber[4] = 50;

        System.out.println("Please enter 5 integers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number for index " + i + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Output using for loop:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element at index " + i + ": " + numbers[i]);
        }

        System.out.println("Output using for-each loop:");
        for (int num : numbers) {
            System.out.println("Element: " + num);
        }
        scanner.close();
    }
}
