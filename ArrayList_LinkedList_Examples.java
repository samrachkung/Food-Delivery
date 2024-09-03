import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayList_LinkedList_Examples {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        System.out.println("First fruit: " + fruits.get(0));

        fruits.remove(1);

        System.out.println("Fruits in the list:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        System.out.println("Number of fruits: " + fruits.size());
 
        LinkedList<String> animals = new LinkedList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Horse");

        System.out.println("First animal: " + animals.get(0));

        animals.remove(1);

        System.out.println("Animals in the list:");
        for (String animal : animals) {
            System.out.println(animal);
        }

        System.out.println("Number of animals: " + animals.size());
    }
}
