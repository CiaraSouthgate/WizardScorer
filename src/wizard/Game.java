package wizard;

import java.util.Scanner;

public class Game {
    private Player[] players;
    private int rounds;
    private Scanner scan;

    public Game(Player[] players) {
        scan = new Scanner(System.in);
        this.players = players;
        switch (players.length) {
            case 3:
                rounds = 20;
                break;
            case 4:
                rounds = 15;
                break;
            case 5:
                rounds = 12;
                break;
            case 6:
                rounds = 10;
                break;
        }
    }

    public void play() {
        for (int i = 0; i < rounds; i++) {
            int dealer = i % players.length;

            System.out.println("Round " + (i + 1));
            System.out.println("Dealer is " + players[dealer].getName() + ".");

            bid(i, dealer);
            actual(i, dealer);

            System.out.println("Scores:");
            for (Player p : players) System.out.println(p);
        }
        //TODO print final scores and winner
    }

    private void bid(int i, int dealer) {
        for (int j = 1; j <= players.length; j++) {
            Player current = players[(dealer + j) % players.length];

            System.out.println(current.getName() + "'s bid:");
            String input = scan.next();
            int bid = toInt(input);

            while (bid < 0 || bid > i + 1) {
                System.out.println("Invalid bid.");
                input = scan.next();
                bid = toInt(input);
            }

            current.setBid(bid);
        }
    }

    private void actual(int i, int dealer) {
        //TODO validate number of tricks entered before adjusting scores
        int count = 0;
        for (int j = 1; j <= players.length; j++) {
            Player current = players[(dealer + j) % players.length];

            System.out.println("How many tricks did " + current.getName() + " take?");
            String input = scan.next();
            int taken = toInt(input);

            while (taken < 0 || taken > i + 1) {
                System.out.println("Invalid quantity.");
                input = scan.next();
                taken = toInt(input);
            }

            int diff = Math.abs(taken - current.getBid());
            current.changeScore((diff == 0) ? (current.getBid() * 10) : (-(diff * 10)));
        }
    }

    public static int toInt(String s) {
        int result = -1;
        try {
            result = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid integer.");
        }
        return result;
    }

}
