public class arrayexception {
    public static void main(String[] args) {
        Number[] numbers = new Integer[3];
        
        try {
            System.out.println("Trying to store a Double into an Integer array...");
            numbers[0] = new Double(10.5); 
        } catch (ArrayStoreException e) {
            System.out.println("Exception caught: " + e.getMessage());
            System.out.println("An object was stored in an array that it is not compatible with.");
        }
    }
}
