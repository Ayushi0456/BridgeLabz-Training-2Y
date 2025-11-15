import java.util.ArrayList;

public class WrapperCollection{
    public static void main(String[] args) {

        double[] price = {10.5, 20.0, 35.75, 5.5};

        ArrayList<Double> priceList = new ArrayList<>();

        for (double p : price ) {
            priceList.add(p);   

        double highest = priceList.get(0);
        double sum = 0;

        for (Double pL: priceList ) {
            if (pL > highest) {
                highest = pL;
            }
            sum += p; 
        }

        double average = sum / priceList.size();

        System.out.println("Price List: " + priceList);
        System.out.println("Highest Price: " + highest);
        System.out.println("Average Price: " + average);
    }
}
}

