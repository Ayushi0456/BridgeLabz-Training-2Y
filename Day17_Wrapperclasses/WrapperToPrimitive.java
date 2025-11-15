public class WrapperToPrimitive {
    public static void main(String[] args) {
        
        Double obj = 45.67;

        double primitiveDouble = obj.doubleValue();

        int primitiveInt = (int) obj.doubleValue();

        System.out.println("Wrapper Double object: " + obj);
        System.out.println("Primitive double: " + primitiveDouble);
        System.out.println("Primitive int (after casting): " + primitiveInt);
    }
}
