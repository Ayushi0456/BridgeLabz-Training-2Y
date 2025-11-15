public class ShoppingCart {
    public static void main(String[] args) {

        String[] priceStrings = {"100", "250", "ABC", "50", "xyz", "300"};

        int totalPrice = 0;

        for (String p : priceStrings) {
            try {
                int price = Integer.parseInt(p);

                totalPrice += price;

            } catch (NumberFormatException e) {
                System.out.println("Invalid price found: " + p + " (Skipping...)");
            }
        }

        System.out.println(totalPrice);
    }
}

