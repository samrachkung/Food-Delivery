import java.util.Scanner;

class Student {
    String name, id;
    char sex;
    int age, score;
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Student[] stu = new Student[100];
        int numStudents = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println(
                    "----------------------------------------------------------------------------------------------------");
            System.out.println("|  \t 1.Add  \t 2.Delete \t 3.Display \t 4.Update \t  5.Sort  \t 6.Search |");
            System.out.println(
                    "----------------------------------------------------------------------------------------------------");
            System.out.print(" ====>> Please Choose one ( 1 - 6 ) => ");
            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    addStudent(stu, numStudents, scanner);
                    numStudents++;
                    break;
                case 2:
                    numStudents = deleteStudent(stu, numStudents, scanner);
                    break;
                case 3:
                    displayStudents(stu, numStudents, scanner);
                    break;
                case 4:
                    updateStudent(stu, numStudents, scanner);
                    break;
                case 5:
                    sortStudents(stu, numStudents, scanner);
                    break;
                case 6:
                    searchStudent(stu, numStudents, scanner);
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

        System.out.print("\tPlease Input ID   = ");
        String id = scanner.next();
        for (int j = 0; j < index; j++) {
            if (id.equals(stu[j].id)) {
                System.out.println("You can't input the same ID! Please try to enter again.");
                return;
            }
        }

        stu[index] = new Student();
        stu[index].id = id;

        System.out.print("\tPlease Input Name = ");
        stu[index].name = scanner.next();
        System.out.print("\tPlease Input Sex  = ");
        stu[index].sex = scanner.next().charAt(0);
        System.out.print("\tPlease Input Age  = ");
        stu[index].age = scanner.nextInt();
        System.out.print("\tPlease Input Score = ");
        stu[index].score = scanner.nextInt();
        System.out.println("Student data added successfully.");
    }

    public static int deleteStudent(Student[] stu, int index, Scanner scanner) {
        System.out.println("\t[Delete Option]\n1.Delete By ID\n2.Delete By Name\nChoose: ");
        int want = scanner.nextInt();

        switch (want) {
            case 1:
                System.out.print("Which Student (ID) you want to delete?: ");
                String del = scanner.next();
                boolean found = false;

                for (int j = 0; j < index; j++) {
                    if (del.equals(stu[j].id)) {
                        found = true;
                        System.out.println("Are you sure to delete? [y/n]: ");
                        char sure = scanner.next().charAt(0);
                        if (sure == 'y' || sure == 'Y') {
                            for (int k = j; k < index - 1; k++) {
                                stu[k] = stu[k + 1];
                            }
                            index--;
                            System.out.println("Data deleted successfully!");
                        }
                        break;
                    }
                }
                if (!found)
                    System.out.println("Data not found");
                break;

            case 2:
                System.out.print("Which Student (Name) you want to delete?: ");
                String delName = scanner.next();
                int count = 0;

                for (int j = 0; j < index; j++) {
                    if (delName.equals(stu[j].name)) {
                        count++;
                        displayStudentInfo(stu[j]);
                    }
                }

                if (count == 0) {
                    System.out.println("Data not found");
                } else if (count == 1) {
                    System.out.println("Are you sure to delete? [y/n]: ");
                    char sure = scanner.next().charAt(0);
                    if (sure == 'y' || sure == 'Y') {
                        for (int j = 0; j < index; j++) {
                            if (delName.equals(stu[j].name)) {
                                for (int k = j; k < index - 1; k++) {
                                    stu[k] = stu[k + 1];
                                }
                                index--;
                                System.out.println("Data deleted successfully!");
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
                            System.out.println("Are you sure to delete? [y/n]: ");
                            char sure = scanner.next().charAt(0);
                            if (sure == 'y' || sure == 'Y') {
                                for (int k = j; k < index - 1; k++) {
                                    stu[k] = stu[k + 1];
                                }
                                index--;
                                System.out.println("Data deleted successfully!");
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
        return index;
    }

    public static void displayStudents(Student[] stu, int index, Scanner scanner) {
        System.out.println("Choose Display Option:");
        System.out.println("1: Display All Students\n2: Display By Sex\n3: Display By Result (Pass/Fail)");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Displaying All Students:");
                System.out.println("ID\tName\tSex\tAge\tScore\tResult");
                for (int j = 0; j < index; j++) {
                    displayStudentInfo(stu[j]);
                }
                break;

            case 2:
                displayBySex(stu, index);
                break;

            case 3:
                displayByResult(stu, index);
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void displayBySex(Student[] stu, int index) {
        System.out.println("Displaying students by Sex:");

        System.out.println("\nMale Students:");
        System.out.println("ID\tName\tSex\tAge\tScore\tResult");
        for (int j = 0; j < index; j++) {
            if (stu[j].sex == 'M' || stu[j].sex == 'm') {
                displayStudentInfo(stu[j]);
            }
        }

        System.out.println("\nFemale Students:");
        System.out.println("ID\tName\tSex\tAge\tScore\tResult");
        for (int j = 0; j < index; j++) {
            if (stu[j].sex == 'F' || stu[j].sex == 'f') {
                displayStudentInfo(stu[j]);
            }
        }
    }

    public static void displayByResult(Student[] stu, int index) {
        System.out.println("Displaying students by Result:");
        System.out.println("\nPassing Students:");
        System.out.println("ID\tName\tSex\tAge\tScore\tResult");
        for (int j = 0; j < index; j++) {
            if (stu[j].score >= 50) {
                displayStudentInfo(stu[j]);
            }
        }
        System.out.println("\nFailing Students:");
        System.out.println("ID\tName\tSex\tAge\tScore\tResult");
        for (int j = 0; j < index; j++) {
            if (stu[j].score < 50) {
                displayStudentInfo(stu[j]);
            }
        }
    }

    public static void updateStudent(Student[] stu, int index, Scanner scanner) {
        System.out.println("\t[Update]");
        System.out.print("Which Student (ID) you want to Update?: ");
        String up = scanner.next();

        for (int j = 0; j < index; j++) {
            if (up.equals(stu[j].id)) {
                System.out.println("ID\tName\tSex\tAge\tScore\tResult");
                System.out.print(stu[j].id + "\t" + stu[j].name + "\t" + stu[j].sex + "\t");
                System.out.print(stu[j].age + "\t" + stu[j].score + "\t");
                if (stu[j].score >= 50)
                    System.out.println("\tPass");
                else
                    System.out.println("\tFail");

                System.out.print("Which Field (name, sex, age, score): ");
                String field = scanner.next();

                switch (field.toLowerCase()) {
                    case "name":
                        System.out.print("Name: ");
                        stu[j].name = scanner.next();
                        break;
                    case "sex":
                        System.out.print("Sex: ");
                        stu[j].sex = scanner.next().charAt(0);
                        break;
                    case "age":
                        System.out.print("Age: ");
                        stu[j].age = scanner.nextInt();
                        break;
                    case "score":
                        System.out.print("Score: ");
                        stu[j].score = scanner.nextInt();
                        break;
                    default:
                        System.out.println("Invalid Field!");
                }

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

    public static void sortStudents(Student[] stu, int index, Scanner scanner) {
        System.out.println("\t[Sort]");
        System.out.println("1.Sort By ID\n2.Sort By Name\n3.Sort By Score");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                sortByID(stu, index);
                break;
            case 2:
                sortByName(stu, index);
                break;
            case 3:
                sortByScore(stu, index);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void sortByID(Student[] stu, int index) {
        System.out.println("\tSorting by ID...");
        for (int i = 0; i < index - 1; i++) {
            for (int j = 0; j < index - 1 - i; j++) {
                if (stu[j].id.compareTo(stu[j + 1].id) > 0) {
                    Student temp = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = temp;
                }
            }
        }
        System.out.println("Students sorted by ID.");
    }

    public static void sortByName(Student[] stu, int index) {
        System.out.println("\tSorting by Name...");
        for (int i = 0; i < index - 1; i++) {
            for (int j = 0; j < index - 1 - i; j++) {
                if (stu[j].name.compareTo(stu[j + 1].name) > 0) {
                    Student temp = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = temp;
                }
            }
        }
        System.out.println("Students sorted by Name.");
    }

    public static void sortByScore(Student[] stu, int index) {
        System.out.println("\tSorting by Score...");
        for (int i = 0; i < index - 1; i++) {
            for (int j = 0; j < index - 1 - i; j++) {
                if (stu[j].score < stu[j + 1].score) {
                    Student temp = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = temp;
                }
            }
        }
        System.out.println("Students sorted by Score.");
    }

    public static void searchStudent(Student[] stu, int index, Scanner scanner) {
        System.out.println("\t[Search Option]\n1.Search By ID\n2.Search By Name");
        int want = scanner.nextInt();

        switch (want) {
            case 1:
                System.out.print("Which Student (ID) you want to Search?: ");
                String search = scanner.next();
                for (int j = 0; j < index; j++) {
                    if (search.equals(stu[j].id)) {
                        System.out.println("Student found:");
                        displayStudentInfo(stu[j]);
                        return;
                    }
                }
                System.out.println("Data not found");
                break;

            case 2:
                System.out.print("Which Student (Name) you want to Search?: ");
                String searchName = scanner.next();
                boolean found = false;
                for (int j = 0; j < index; j++) {
                    if (searchName.equals(stu[j].name)) {
                        if (!found) {
                            System.out.println("Student(s) found:");
                            found = true;
                        }
                        displayStudentInfo(stu[j]);
                    }
                }
                if (!found)
                    System.out.println("Data not found");
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }


    

    public static void displayStudentInfo(Student student) {
        System.out.println(student.id + "\t" + student.name + "\t" + student.sex + "\t" + student.age + "\t"
                + student.score + "\t" + (student.score >= 50 ? "Pass" : "Fail"));
    }
}
