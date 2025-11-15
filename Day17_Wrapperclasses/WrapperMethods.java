public class WrapperMethods {
    public static void main(String[] args) {

        int num = Integer.parseInt("123");
        double pi = Double.parseDouble("3.14");
        boolean flag = Boolean.parseBoolean("true");
        String binary = Integer.toBinaryString(10);
        boolean isDigit = Character.isDigit('5');
        Character ch = Character.toUpperCase('a');
        System.out.println(num);
        System.out.println(pi);
        System.out.println(flag);
        System.out.println(binary);
        System.out.println(isDigit);
        System.out.println(ch);
    }
}

