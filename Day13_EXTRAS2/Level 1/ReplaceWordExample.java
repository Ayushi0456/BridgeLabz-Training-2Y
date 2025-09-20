import java.util.Scanner;

public class ReplaceWordExample {

    public static String replaceWord(String sentence, String oldWord, String newWord) {
        return sentence.replaceAll("\\b" + oldWord + "\\b", newWord);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();

        System.out.println("Enter the word to replace:");
        String oldWord = sc.next();

        System.out.println("Enter the new word:");
        String newWord = sc.next();

        String updatedSentence = replaceWord(sentence, oldWord, newWord);

        System.out.println("Updated sentence: " + updatedSentence);

        sc.close();
    }
}

