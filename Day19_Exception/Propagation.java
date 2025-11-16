public class Propagation {

    static void methodB() {
        try {
            int x = Integer.parseInt("ABC"); 
        } catch (NumberFormatException e) {
            System.out.println("Handled NumberFormatException in methodB");
        }

        String s = null;
        s.length(); 
    }

    static void methodA() {
        try {
            methodB();
        } catch (Exception e) {
            System.out.println("Exception propagated to methodA: " + e);
        }
    }

    public static void main(String[] args) {
        methodA();
    }
}

