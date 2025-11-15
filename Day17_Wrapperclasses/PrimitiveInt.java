import java.util.Scanner;

public class PrimitiveInt {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int primitiveValue = sc.nextInt();          

        Integer objectValue = Integer.valueOf(primitiveValue); 

        System.out.println("Primitive value: " + primitiveValue);
        System.out.println("Object (Integer) value: " + objectValue);

        sc.close();
    }
}
