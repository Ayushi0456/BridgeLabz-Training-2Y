import java.util.Scanner;

public class SubstringOccurrence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String mainString = scanner.nextLine();

        System.out.print("Enter the substring to search: ");
        String subString = scanner.nextLine();

        int count = 0;
        int index = 0;

        while ((index = mainString.indexOf(subString, index)) != -1) {
            count++;
            index += subString.length(); 

        System.out.println("The substring \"" + subString + "\" occurs " + count + " times.");

        scanner.close();
    }
}
}

