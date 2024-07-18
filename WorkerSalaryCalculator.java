import java.util.Scanner;

public class WorkerSalaryCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of hours worked from the user
        System.out.print("Enter the number of hours worked: ");
        int workedHours = scanner.nextInt();
        
        double baseSalary = 150.0;
        double finalSalary = baseSalary;
        int requiredHours = 100;

        // Calculate the final salary based on the hours worked
        if (workedHours > requiredHours) {
            int overtimeHours = workedHours - requiredHours;

            if (overtimeHours <= 20) {
                finalSalary += overtimeHours * 2.0;
            } else {
                finalSalary += 20 * 2.0; // First 20 hours at 2 USD/hour
                finalSalary += (overtimeHours - 20) * 2.50; // Remaining hours at 2.50 USD/hour
            }
        } else if (workedHours < requiredHours) {
            int undertimeHours = requiredHours - workedHours;
            finalSalary -= undertimeHours * 1.0;
        }

        // Print the worker's report
        System.out.printf("Worker's Report:%n");
        System.out.printf("Base Salary: $%.2f%n", baseSalary);
        System.out.printf("Worked Hours: %d%n", workedHours);

        if (workedHours > requiredHours) {
            int overtimeHours = workedHours - requiredHours;
            System.out.printf("Overtime Hours: %d%n", overtimeHours);
            if (overtimeHours <= 20) {
                System.out.printf("Overtime Pay: $%.2f%n", overtimeHours * 2.0);
            } else {
                System.out.printf("Overtime Pay: $%.2f%n", 20 * 2.0 + (overtimeHours - 20) * 2.50);
            }
        } else if (workedHours < requiredHours) {
            int undertimeHours = requiredHours - workedHours;
            System.out.printf("Undertime Hours: %d%n", undertimeHours);
            System.out.printf("Penalty for Undertime: $%.2f%n", undertimeHours * 1.0);
        } else {
            System.out.printf("No Overtime or Undertime%n");
        }

        System.out.printf("Final Salary: $%.2f%n", finalSalary);
        
        scanner.close();
    }
}
