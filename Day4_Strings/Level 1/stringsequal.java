public class stringsequal {
    public static void main(String[] args) {
        String originalString = "vibrato";
        String substringResult = originalString.substring(0, 4);
        System.out.println("Original string: " + originalString);
        System.out.println("Substring 'vibe': " + substringResult);

        String anotherString = "vibe";
        System.out.println("Are the substrings equal? " + substringResult.equals(anotherString));
        System.out.println("Length of 'vibe' is: " + substringResult.length());
    }
}
