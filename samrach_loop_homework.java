import java.util.Scanner;

public class samrach_loop_homework{
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String username = "samrach";
        int userpassword = 123;
        boolean loginSuccess = false;
        int attempts = 0;
        int maxAttempts = 3;

        while (!loginSuccess && attempts < maxAttempts) {
            System.out.print("Enter a Username: ");
            String user = scanner.next();
            System.out.print("Enter a Password: ");
            int password = scanner.nextInt();

            if (user.equals(username) && password == userpassword) {
                loginSuccess = true;
                System.out.println("\n\n");
                System.out.println("|==========================================|");
                System.out.println("|--->Login success                         |");                      
                System.out.println("|==========================================|");                      
                System.out.println(  "--->UserName: " + user);
                System.out.println(  "--->Password: " + password);
                System.out.println("============================================");
                System.out.println("\n\n");
            } else {
                attempts++;
                if (attempts >= maxAttempts) {
                    System.out.println("Too many failed attempts. Exiting.");
                    break;
                }
                if (!user.equals(username) && password == userpassword) {
                    System.out.println("Login not successful");
                    System.out.println("Invalid User name: " + user);
                } else if (user.equals(username) && password != userpassword) {
                    System.out.println("Login not successful");
                    System.out.println("Invalid User password: " + password);
                } else {
                    System.out.println("Login not successful");
                    System.out.println("Invalid username and password");
                }
            }
        }

        if (loginSuccess) {
            System.out.print(" ====>> Please input time to create students =>  ");
            int times = scanner.nextInt();       
            int totalStudents = 0;
            int passCount = 0;
            int failCount = 0;
            
            while (times > 0) {
                totalStudents++;
                
                System.out.println("-----------------------------");
                System.out.println("Student " + totalStudents + ":");
                
                int cplus = -1, ds = -1, eng = -1;

                while (cplus < 0 || cplus > 100) {
                    System.out.print("C++: ");
                    cplus = scanner.nextInt();
                    if (cplus < 0 || cplus > 100) {
                        System.out.println("Invalid score. Please enter a value between 0 and 100.");
                    }
                }
                while (ds < 0 || ds > 100) {
                    System.out.print("Ds: ");
                    ds = scanner.nextInt();
                    if (ds < 0 || ds > 100) {
                        System.out.println("Invalid score. Please enter a value between 0 and 100.");
                    }
                }

                while (eng < 0 || eng > 100) {
                    System.out.print("Eng: ");
                    eng = scanner.nextInt();
                    if (eng < 0 || eng > 100) {
                        System.out.println("Invalid score. Please enter a value between 0 and 100.");
                    }
                }

                int totalScore = cplus + ds + eng;
                double average = totalScore / 3.0;       
                System.out.println("Total score= " + totalScore);
                System.out.println("Average= " + average);
                if (average >= 50) {
                    passCount++;
                } else {
                    failCount++;
                }
                System.out.print("one more student (type: (Y) for add more student / (N) for stop add student): ");
                char moreStudents = scanner.next().charAt(0);
                if (moreStudents == 'n' || moreStudents == 'N') {
                    break;
                }
            }
            
            System.out.println("-----------------------------");
            System.out.println("Total student: " + totalStudents);
            System.out.println("Pass: " + passCount);
            System.out.println("Fail: " + failCount);
        }

        scanner.close();
    }
}
