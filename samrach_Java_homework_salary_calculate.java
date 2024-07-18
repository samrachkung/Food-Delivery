import java.util.Scanner;

public class samrach_Java_homework_salary_calculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = "samrach";
        int userpassword = 123;
        int staffWorkingHoursPerMonth = 100;
        int salary = 150;
        int staffWorkingHours;
        System.out.print("Enter a Username: ");
        String user = scanner.next();
        System.out.print("Enter a Password: ");
        int password = scanner.nextInt();
        if (user.equals(username) && password == userpassword) {
            System.out.println("\n\n");
            System.out.println("============================================");
            System.out.println("|--->Login success                         |");                      
            System.out.println(  "|--->UserName: " + user                    );
            System.out.println(  "|--->Password: " + password);
            System.out.println("============================================");
            System.out.println("\n\n\n");
            System.out.println("=====< > Welcome to Staff Salary Calculation Program < >=====");
            System.out.println("\n\n");
            System.out.print("\nEnter the number of hours that staff worked: ");
            staffWorkingHours = scanner.nextInt();
            if (staffWorkingHours == 100) {
                System.out.println("\n");
                System.out.println("Your base salary is : $" + salary);
                System.out.println("Your base requiredHours is : " + staffWorkingHoursPerMonth + "h");
                System.out.println("Your total working hours this month is : " + staffWorkingHours + "h");
                System.out.println("Your salary this month is $: " + salary);
            } else if (staffWorkingHours > 100) {
                System.out.println("\n");
                int staffHourCalculated = staffWorkingHours - staffWorkingHoursPerMonth;
                if (staffHourCalculated <= 20) {
                    System.out.println("\n");
                    int staffSalaryCalculated = salary + (staffHourCalculated * 2);
                    int totalHours = staffWorkingHours;
                    System.out.println("Your base salary is : $" + salary);
                    System.out.println("Your base requiredHours is : " + staffWorkingHoursPerMonth + "h");
                    System.out.println("Your total working hours this month is : " + totalHours + "h");
                    System.out.println("Your total salary this month is $: " + staffSalaryCalculated);
                } else if (staffHourCalculated >= 20) {
                    System.out.println("\n");
                    double staffSalaryCalculated = (int) salary + ((int) staffHourCalculated * 2.5);
                    int totalHours = staffWorkingHours;
                    System.out.println("Your base salary is : $" + salary);
                    System.out.println("Your base requiredHours is : " + staffWorkingHoursPerMonth + "h");
                    System.out.println("Your total working hours this month is : " + totalHours + "h");
                    System.out.println("Your total salary this month is : $" + staffSalaryCalculated);
                }
            } else {
                System.out.println("\n");
                int staffSalaryCalculated = salary - (staffWorkingHoursPerMonth - staffWorkingHours);
                System.out.println("Your base salary is : $" + salary);
                System.out.println("Your base requiredHours is : " + staffWorkingHoursPerMonth + "h");
                System.out.println("Your total working hours this month is : " + staffWorkingHours + "h");
                System.out.println("Your salary this month is : $" + staffSalaryCalculated);
            }
        } else if (!user.equals(username) && password == userpassword) {
            System.out.println("Login not successful");
            System.out.println("Invalid User name: " + user);
        } else if (user.equals(username) && password != userpassword) {
            System.out.println("Login not successful");
            System.out.println("Invalid User password: " + password);
        } else {
            System.out.println("Login not successful");
            System.out.println("Invalid username and password");
        }
        scanner.close();
    }
}
