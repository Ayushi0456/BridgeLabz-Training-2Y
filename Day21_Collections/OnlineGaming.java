import java.util.*;

class Player {
    String name;

    public Player(String name) { this.name = name; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Player)) return false;
        return name.equals(((Player)o).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

class Match {
    String p1, p2;
    public Match(String p1, String p2) {
        this.p1 = p1; this.p2 = p2;
    }
    public String toString() { return p1 + " vs " + p2; }
}

class Score implements Comparable<Score> {
    String player;
    int points;

    public Score(String player, int points) {
        this.player = player;
        this.points = points;
    }

    public int compareTo(Score s) {
        return s.points - this.points; // descending
    }

    public String toString() {
        return player + " : " + points;
    }
}

public class OnlineGaming {
    public static void main(String[] args) {

        Set<Player> players = new HashSet<>();
        players.add(new Player("A"));
        players.add(new Player("B"));
        players.add(new Player("C"));

        Queue<Match> matches = new LinkedList<>();
        matches.add(new Match("A", "B"));
        matches.add(new Match("B", "C"));

        List<String> results = new ArrayList<>();
        TreeSet<Score> leaderboard = new TreeSet<>();

        while (!matches.isEmpty()) {
            Match m = matches.poll();
            System.out.println("Processing Match: " + m);

            // example result
            results.add(m.p1 + " won");

            // update scores
            leaderboard.add(new Score(m.p1, 10));
            leaderboard.add(new Score(m.p2, 5));
        }

        System.out.println("\nLeaderboard:");
        for (Score s : leaderboard) {
            System.out.println(s);
        }
    }
}

