import java.util.Scanner;

class Student {
    String name, id;
    char sex;
    float total, avg;
    int ds, c, eng;
}

public class studentmanagement {
    public static void main(String[] args) {
        Student[] stu = new Student[100];
        int i = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("|  \t 1.Add  \t 2.Delete \t 3.Display \t 4.Update \t  5.Sort  |"); 
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.print(" ====>> Please Choose one ( 1 - 5 ) => ");
            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    addStudent(stu, i, scanner);
                    i++;
                    break;
                case 2:
                    deleteStudent(stu, i, scanner);
                    break;
                case 3:
                    displayStudents(stu, i);
                    break;
                case 4:
                    updateStudent(stu, i, scanner);
                    break;
                case 5:
                    sortStudents(stu, i);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            System.out.println("Press Enter to continue...");
            scanner.nextLine();
            scanner.nextLine();
        }
    }

    public static void addStudent(Student[] stu, int index, Scanner scanner) {
        System.out.println("-----------------------<<<<<<<<<  Add Student >>>>>>>>>>-----------------------");
        System.out.println("- Student " + (index + 1));

        // Input student information
        System.out.print("\tPlease Input ID   = ");
        String id = scanner.next();

        // Check for duplicate IDs
        for (int j = 0; j < index; j++) {
            if (id.equals(stu[j].id)) {
                System.out.println("You can't Input the same ID!\n Please Try to Enter Again..");
                return;
            }
        }

        stu[index] = new Student();
        stu[index].id = id;

        System.out.print("\tPlease Input Name = ");
        stu[index].name = scanner.next();
        System.out.print("\tPlease Input Sex  = ");
        stu[index].sex = scanner.next().charAt(0);
        System.out.print("\tPlease Input DS   = ");
        stu[index].ds = scanner.nextInt();
        System.out.print("\tPlease Input C#   = ");
        stu[index].c = scanner.nextInt();
        System.out.print("\tPlease Input Eng  = ");
        stu[index].eng = scanner.nextInt();
        System.out.println("Data Added Successfully");

        // Calculate total and average marks
        stu[index].total = stu[index].ds + stu[index].c + stu[index].eng;
        stu[index].avg = stu[index].total / 3;
    }

    public static void deleteStudent(Student[] stu, int index, Scanner scanner) {
        System.out.println("\t[Delete Option]\n1.Delete By ID\n2.Delete By Name\nchoose:");
        int want = scanner.nextInt();

        switch (want) {
            case 1:
                // Delete by ID
                System.out.print("Which Student (ID) you want to delete?: ");
                String del = scanner.next();
                boolean found = false;

                for (int j = 0; j < index; j++) {
                    if (del.equals(stu[j].id)) {
                        found = true;
                        System.out.println("Are you sure to delete!![y/n]: ");
                        char sure = scanner.next().charAt(0);
                        if (sure == 'y' || sure == 'Y') {
                            for (int k = j; k < index - 1; k++) {
                                stu[k] = stu[k + 1];
                            }
                            index--;
                            System.out.println("Data Deleted Successfully!");
                        }
                        break;
                    }
                }
                if (!found)
                    System.out.println("Data not found");
                break;

            case 2:
                // Delete by name
                System.out.print("Which Student (Name) you want to delete?: ");
                String delName = scanner.next();
                int count = 0;

                for (int j = 0; j < index; j++) {
                    if (delName.equals(stu[j].name)) {
                        count++;
                        System.out.println("ID\tName\tSex\tDS\tC#\tEng\tTotal\tAverage\t\tResult");
                        System.out.print(stu[j].id + "\t" + stu[j].name + "\t" + stu[j].sex + "\t");
                        System.out.print(stu[j].ds + "\t" + stu[j].c + "\t" + stu[j].eng + "\t" + stu[j].total + "\t" + stu[j].avg + "\t");
                        if (stu[j].avg >= 50)
                            System.out.println("\tPass");
                        else
                            System.out.println("\tFail");
                    }
                }

                if (count == 0) {
                    System.out.println("Data not found");
                } else if (count == 1) {
                    System.out.println("Are you sure to delete!![y/n]: ");
                    char sure = scanner.next().charAt(0);
                    if (sure == 'y' || sure == 'Y') {
                        for (int j = 0; j < index; j++) {
                            if (delName.equals(stu[j].name)) {
                                for (int k = j; k < index - 1; k++) {
                                    stu[k] = stu[k + 1];
                                }
                                index--;
                                System.out.println("Data Deleted Successfully!");
                                break;
                            }
                        }
                    }
                } else {
                    System.out.print("Which Student (ID) you want to delete?: ");
                    String delID = scanner.next();
                    boolean foundID = false;
                    for (int j = 0; j < index; j++) {
                        if (delID.equals(stu[j].id) && delName.equals(stu[j].name)) {
                            foundID = true;
                            System.out.println("Are you sure to delete!![y/n]: ");
                            char sure = scanner.next().charAt(0);
                            if (sure == 'y' || sure == 'Y') {
                                for (int k = j; k < index - 1; k++) {
                                    stu[k] = stu[k + 1];
                                }
                                index--;
                                System.out.println("Data Deleted Successfully!");
                            }
                            break;
                        }
                    }
                    if (!foundID)
                        System.out.println("Data not found");
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void displayStudents(Student[] stu, int index) {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------   Display info student ----------------------------------");
        System.out.println("ID\tName\tSex\tDS\tC#\tEng\tTotal\tAverage\t\tResult");

        for (int j = 0; j < index; j++) {
            System.out.print(stu[j].id + "\t" + stu[j].name + "\t" + stu[j].sex + "\t");
            System.out.print(stu[j].ds + "\t" + stu[j].c + "\t" + stu[j].eng + "\t" + stu[j].total + "\t" + stu[j].avg + "\t");
            if (stu[j].avg >= 50)
                System.out.println("\tPass");
            else
                System.out.println("\tFail");
        }
    }

    public static void updateStudent(Student[] stu, int index, Scanner scanner) {
        System.out.println("\t[Update]");
        System.out.print("Which Student (ID) you want to Update?: ");
        String up = scanner.next();

        for (int j = 0; j < index; j++) {
            if (up.equals(stu[j].id)) {
                System.out.println("ID\tName\tSex\tDS\tC#\tEng\tTotal\tAverage\t\tResult");
                System.out.print(stu[j].id + "\t" + stu[j].name + "\t" + stu[j].sex + "\t");
                System.out.print(stu[j].ds + "\t" + stu[j].c + "\t" + stu[j].eng + "\t" + stu[j].total + "\t" + stu[j].avg + "\t");
                if (stu[j].avg >= 50)
                    System.out.println("\tPass");
                else
                    System.out.println("\tFail");

                System.out.print("Which Field= ");
                String field = scanner.next();

                switch (field.toLowerCase()) {
                    case "name":
                        System.out.print("Name: ");
                        stu[j].name = scanner.next();
                        break;
                    case "id":
                        System.out.print("ID: ");
                        stu[j].id = scanner.next();
                        break;
                    case "sex":
                        System.out.print("Sex: ");
                        stu[j].sex = scanner.next().charAt(0);
                        break;
                    case "ds":
                        System.out.print("DS: ");
                        stu[j].ds = scanner.nextInt();
                        break;
                    case "eng":
                        System.out.print("Eng: ");
                        stu[j].eng = scanner.nextInt();
                        break;
                    case "c":
                        System.out.print("C#: ");
                        stu[j].c = scanner.nextInt();
                        break;
                    default:
                        System.out.println("Wrong Field!");
                }

                // Recalculate total and average marks
                stu[j].total = stu[j].ds + stu[j].c + stu[j].eng;
                stu[j].avg = stu[j].total / 3;

                System.out.print("Do you want to update more?[Y/N]: ");
                char chooseUp = scanner.next().charAt(0);

                if (chooseUp == 'n' || chooseUp == 'N') {
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    scanner.nextLine();
                    return;
                }
            }
        }
        System.out.println("Data not found");
    }

    public static void sortStudents(Student[] stu, int index) {
        for (int x = 0; x < index; x++) {
            for (int j = 0; j + 1 < index - x; j++) {
                if (stu[j].avg > stu[j + 1].avg) {
                    Student temp = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = temp;
                } else if (stu[j].avg == stu[j + 1].avg && stu[j].name.compareTo(stu[j + 1].name) > 0) {
                    Student temp = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted Successfully!");
    }
}
