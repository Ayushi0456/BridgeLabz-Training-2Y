public class stringsplit {
    public static void main(String[] args) {
        String sentence = "Java programming is fun";
        String[] words = sentence.split(" ");
        
        System.out.println("Original sentence: " + sentence);
        System.out.println("Words after splitting:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
