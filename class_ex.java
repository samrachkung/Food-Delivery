class User {
    
    String Name;
    String sex;
    int age;

    void displayDetails() {
        System.out.println("Name: " + Name);
        System.out.println("Sex: " + sex);
        System.out.println("age: " + age);
    }
}
public class class_ex {
    public static void main(String[] args) {   
        User user = new User();      
        user.Name = "Samrach";
        user.sex = "male";
        user.age = 21;
        user.displayDetails();
    }
}
