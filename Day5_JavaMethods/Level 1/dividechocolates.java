import java.util.Scanner;

public class dividechocolates {
    public static int[] distributeChocolates(int chocolates, int children) {
        int each = chocolates / children;
        int remaining = chocolates % children;
        return new int[]{each, remaining};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter chocolates and children: ");
        int choco = sc.nextInt(), kids = sc.nextInt();

        int[] res = distributeChocolates(choco, kids);
        System.out.println("Each child gets " + res[0] + ", Remaining = " + res[1]);
        sc.close();
    }
}

