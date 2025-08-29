import java.util.Scanner;

public class scannernextexample{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the first word: ");
        String firstWord = scanner.next();
        
        System.out.println("Enter the second word: ");
        String secondWord = scanner.next();

        System.out.println("First word: " + firstWord);
        System.out.println("Second word: " + secondWord);

        System.out.println("Are the words equal? " + firstWord.equals(secondWord));

        scanner.close();
    }
}
