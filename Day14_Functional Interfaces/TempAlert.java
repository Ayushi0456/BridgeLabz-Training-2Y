import java.util.function.Predicate;

public class TempAlert {
    public static void main(String[] args) {
        Predicate<Double> alert = t -> t > 40.0;

        double temp = 42.3;

        if(alert.test(temp))
            System.out.println("ALERT! High temperature.");
        else
            System.out.println("Temperature normal.");
    }
}
