import java.util.Scanner;

public class purchase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter unit price (INR): ");
        double unitPrice = sc.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        double total = unitPrice * quantity;
        System.out.println("Total purchase price = INR " + total + " (Quantity: " + quantity + ", Unit Price: " + unitPrice + ")");
    }
}

    

