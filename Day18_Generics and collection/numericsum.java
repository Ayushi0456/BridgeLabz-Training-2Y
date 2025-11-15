import java.util.*;

class NumericSum {
    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) sum += n.doubleValue();
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumNumbers(List.of(1, 2, 3, 4)));
        System.out.println(sumNumbers(List.of(2.5, 3.5, 1.0)));
    }
}

