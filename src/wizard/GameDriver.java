package wizard;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("How many players (3-6)?");
        String input = scan.next();
        int numPlayers = Game.toInt(input);

        while (!(numPlayers >= 3 && numPlayers <= 6)) {
            System.out.println("Player count must be between 3 and 6.");
            input = scan.next();
            numPlayers = Game.toInt(input);
        }

        numPlayers = Integer.parseInt(input);
        Player[] players = new Player[numPlayers];

        System.out.println("Enter the names of the players, beginning with the start player " +
                "and continuing in play order.");

        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player(scan.next());
        }

        Game game = new Game(players);
        game.play();
    }
}
