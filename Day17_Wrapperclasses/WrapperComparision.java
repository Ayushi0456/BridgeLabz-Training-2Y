public class WrapperComparision {
    public static void main(String[] args) {

        Integer a = 100;
        Integer b = 100;

        Integer c = 200;
        Integer d = 200;

        
        System.out.println("a == b: " + (a == b)); 
        System.out.println("c == d: " + (c == d)); 

    
        System.out.println("a.equals(b): " + a.equals(b)); 
        System.out.println("c.equals(d): " + c.equals(d)); 

        System.out.println("\nExplanation:");
        System.out.println("100 is within the Integer cache range (-128 to 127), so a and b reference the same object.");
        System.out.println("200 is outside the cache range, so c and d are different objects.");
    }
}

