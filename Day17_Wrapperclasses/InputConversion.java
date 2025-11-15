public class InputConversion {

    public static int safeParseIntStringInput(String input) {
        try {
            return Integer.parseInt(input);   
        } catch (NumberFormatException e) {
            return -1; 
        }
    }

    public static void main(String[] args) {

        
        String[] testInputs = {"1", "2", "3", "a", "b", "c", "4", "5", ".6", "0"};

        for (String value : testInputs) {
            int result = safeParseIntStringInput(value);
            System.out.println("Input: " + value + " --> Output: " + result);
        }
    }
}

