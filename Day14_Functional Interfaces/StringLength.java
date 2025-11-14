import java.util.function.Function;

public class StringLength {
    public static void main(String[] args) {
        Function<String, Integer> len = s -> s.length();

        String msg = "Hello Ayushi!";
        System.out.println("Length = " + len.apply(msg));
    }
}
