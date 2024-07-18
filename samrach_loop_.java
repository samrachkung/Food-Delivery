import java.util.Scanner;

public class samrach_loop_{
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String username = "samrach";
        int userpassword = 123;
        System.out.print("Enter a Username: ");
        String user = scanner.next();
        System.out.print("Enter a Password: ");
        int password = scanner.nextInt();
        if (user.equals(username) && password == userpassword) {
            System.out.println("\n\n");
            System.out.println("|==========================================|");
            System.out.println("|--->Login success                         |");                      
            System.out.println("|==========================================|");                      
            System.out.println(  "--->UserName: " + user);
            System.out.println(  "--->Password: " + password);
            System.out.println("============================================");
            System.out.println("\n\n");
            System.out.print(" ====>> Please input time to create students => ");
            int times = scanner.nextInt();       
            int totalStudents = 0;
            int passCount = 0;
            int failCount = 0;
            
            while (times>0) {
                totalStudents++;
                
                System.out.println("-----------------------------");
                System.out.println("Student " + totalStudents + ":");
                
                int cplus, ds, eng;

                System.out.print("C++: ");
                cplus = scanner.nextInt();
                System.out.print("Ds: ");
                ds = scanner.nextInt();
                System.out.print("Eng: ");
                eng = scanner.nextInt();
                
                int totalScore = cplus+ ds + eng;
                double average = totalScore / 3.0;       
                System.out.println("Total score= " + totalScore);
                System.out.println("Average= " + average);
                if (average >= 50) {
                    passCount++;
                } else {
                    failCount++;
                }
                System.out.print("one more student (type:Y/N): ");
                char moreStudents = scanner.next().charAt(0);
                if (moreStudents == 'n' || moreStudents == 'N') {
                    break;
                }
            }
            
            System.out.println("-----------------------------");
            System.out.println("Total student: " + totalStudents);
            System.out.println("Pass: " + passCount);
            System.out.println("Fail: " + failCount);
           
        } else if (!user.equals(username) && password == userpassword) {
            System.out.println("Login not successful");
            System.out.println("Invalid User name: " + user);
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
        } else if (user.equals(username) && password != userpassword) {
            System.out.println("Login not successful");
            System.out.println("Invalid User password: " + password);
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
        } else {
            System.out.println("Login not successful");
            System.out.println("Invalid username and password");
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
        }
        scanner.close();
    }
}
