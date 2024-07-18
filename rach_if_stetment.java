import java.util.Scanner;

public class rach_if_stetment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Input letter
        System.out.print("Enter a letter: ");
        char letter = scanner.next().charAt(0);

        // Input boolean
        System.out.print("Enter a boolean (true/false): ");
        boolean flag = scanner.nextBoolean();

        // Number check
        if (number > 0) {
            System.out.println("The number is positive.");
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }

        // Letter check
        if (Character.isUpperCase(letter)) {
            System.out.println("The letter is uppercase.");
        } else if (Character.isLowerCase(letter)) {
            System.out.println("The letter is lowercase.");
        } else {
            System.out.println("The character is not a letter.");
        }

        // Boolean check
        if (flag) {
            System.out.println("The boolean is true.");
        } else {
            System.out.println("The boolean is false.");
        }

        // Close the scanner
        scanner.close();
    }
}
