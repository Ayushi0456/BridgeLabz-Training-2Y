public class trim {
    public static void main(String[] args) {
        String firstString = "   Hello ";
        String secondString = " World!   ";

        String trimmedFirst = firstString.trim();
        String trimmedSecond = secondString.trim();

        String concatenatedString = trimmedFirst.concat(trimmedSecond);

        System.out.println("Concatenated and trimmed string: " + concatenatedString);
    }
}
