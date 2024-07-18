import java.util.Scanner;

public class homework {
    public static void main(String[] args) {
       
        final double EXCHANGE_RATE = 4000.0; 
        
      
        Scanner scanner = new Scanner(System.in);
        
       
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        
       
        System.out.print("Enter price of the product ($): ");
        double price = scanner.nextDouble();
        
      
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        
      
        double amount = price * quantity;
        
      
        System.out.print("Enter money given ($): ");
        double moneyGiven = scanner.nextDouble();
        
       
        double changeDollars = moneyGiven - amount;
        
    
        int changeRiels = (int) (changeDollars * EXCHANGE_RATE);

        System.out.println("\nProduct: " + productName);
        System.out.println("Price = $" + price);
        System.out.println("Qty = " + quantity);
        System.out.println("Amount = $" + String.format("%.1f", amount));
        System.out.println("Money = $" + moneyGiven);
        System.out.println("Change$ = $" + String.format("%.1f", changeDollars));
        System.out.println("ChangeRiels = " + changeRiels + " riels");
        scanner.close();
    }
}
