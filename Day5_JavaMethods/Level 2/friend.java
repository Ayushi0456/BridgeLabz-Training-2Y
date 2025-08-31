import java.util.*;

public class friend {
    public static int findYoungest(int[] ages) {
        int min = ages[0];
        for (int a : ages) if (a < min) min = a;
        return min;
    }

    public static int findTallest(int[] heights) {
        int max = heights[0];
        for (int h : heights) if (h > max) max = h;
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[3];
        int[] heights = new int[3];
        String[] names = {"Amar", "Akbar", "Anthony"};

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height (cm) of " + names[i] + ": ");
            heights[i] = sc.nextInt();
        }

        int youngest = findYoungest(ages);
        int tallest = findTallest(heights);

        for (int i = 0; i < 3; i++) {
            if (ages[i] == youngest) System.out.println("Youngest: " + names[i]);
            if (heights[i] == tallest) System.out.println("Tallest: " + names[i]);
            sc.close();
        }
    }
}

