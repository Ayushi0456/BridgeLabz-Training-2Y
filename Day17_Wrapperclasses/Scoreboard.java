public class Scoreboard {

    public static void main(String[] args) {
        Integer[] scores = {10, null, 25, 15, null, 30, 20};

        int notPlayedCount = 0;
        int totalScore = 0;

        for (Integer score : scores) {

            if (score == null) {
                notPlayedCount++;  
            } else {
                totalScore += score; 
            }
        }

        System.out.println(scores.length);
        System.out.println(notPlayedCount);
        System.out.println(totalScore);
    }
}

