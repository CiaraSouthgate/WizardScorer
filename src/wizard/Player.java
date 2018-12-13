package wizard;

public class Player implements Comparable<Player>{
    private final String name;
    private int score;
    private int bid;

    public Player(String setName) {
        name = setName;
        score = 0;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getBid() {
        return bid;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void changeScore(int n) {
        score += n;
    }

    public int compareTo(Player other) {
        if (score > other.getScore()) {
            return 1;
        } else if (score < other.getScore()) {
            return -1;
        }
        return 0;
    }

    public String toString() {
        return name + ": " + score;
    }
}
