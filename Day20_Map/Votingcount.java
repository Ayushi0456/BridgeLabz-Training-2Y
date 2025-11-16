import java.util.*;

public class Votingcount {

    public static void main(String[] args) {
        Map<String, Integer> votes = new HashMap<>();
        String[] voteSequence = {
            "Alice", "Bob", "Charlie", "Alice", "Bob",
            "Alice", "Charlie", "Alice", "Bob", "Alice"
        };

        System.out.println("Processing votes...\n");

        for (String candidate : voteSequence) {
            votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        }

        System.out.println("Total Votes:");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        String winner = null;
        int maxVotes = -1;

        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        System.out.println("\nWinner of the election: " + winner);
        System.out.println("Votes received: " + maxVotes);
    }
}

