public class charat{
    public static void main(String[] args) {
        String originalString = "hello";
        String newString = "";

        for (int i = 0; i < originalString.length(); i++) {
            newString += originalString.charAt(i);
        }

        System.out.println("Original String: " + originalString);
        System.out.println("New String: " + newString);
        System.out.println("Do the strings match? " + originalString.equals(newString));
    }
}
