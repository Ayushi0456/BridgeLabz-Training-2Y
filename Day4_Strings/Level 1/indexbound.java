public class indexbound{
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        
        try {
            System.out.println("Trying to access an element outside the array bounds...");
            System.out.println(numbers[2]); 
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
            System.out.println("An array index was used that is either negative or greater than or equal to the size of the array.");
        }
    }
}
