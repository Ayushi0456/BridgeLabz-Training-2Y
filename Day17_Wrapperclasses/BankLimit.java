public class BankLimit {

    public static double getRemainingLimit(Double dailyLimit, double usedAmount) {
        if (dailyLimit == null) {
            return 0.0;
        }
        double remaining = dailyLimit - usedAmount;
        if (remaining < 0) {
            return 0.0;
        }

        return remaining;
    }

    public static void main(String[] args) {

        Double limit1 = 5000.0;
        double used1 = 1200.50;

        double remaining1 = getRemainingLimit(limit1, used1);
        System.out.println("Remaining Limit (Case 1): " + remaining1);

        Double limit2 = null;
        double used2 = 300;

        double remaining2 = getRemainingLimit(limit2, used2);
        System.out.println("Remaining Limit (Case 2 - null): " + remaining2);

        Double limit3 = 2000.0;
        double used3 = 2500.0;

        double remaining3 = getRemainingLimit(limit3, used3);
        System.out.println("Remaining Limit (Case 3 - negative): " + remaining3);
    }
}

