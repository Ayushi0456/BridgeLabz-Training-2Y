public class stringbound {
    public static void main(String[] args) {
        String text = "Java";

        try {
            System.out.println("Trying to access an element outside the string bounds...");
            System.out.println(text.charAt(4)); 
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
            System.out.println("A string index was used that is either negative or greater than or equal to the string's length.");
        }
    }
}
