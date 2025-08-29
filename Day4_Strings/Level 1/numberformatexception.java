public class numberformatexception {
    public static void main(String[] args) {
        String invalidNumber = "abc";

        try {
            System.out.println("Trying to convert a non-numeric string to an integer...");
            int number = Integer.parseInt(invalidNumber);
        } catch (NumberFormatException e) {
            System.out.println("Exception caught: " + e.getMessage());
            System.out.println("The program tried to convert a string into a numeric format, but the string did not contain a valid number.");
        }
    }
}
