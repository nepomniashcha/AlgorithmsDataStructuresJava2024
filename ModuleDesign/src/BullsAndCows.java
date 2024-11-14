
import GameEngine.Check.CounterChecker;
import GameEngine.Guess.MultiDigitGuessNumber;
import Player.HumanPlayer;

import java.util.HashMap;

public class BullsAndCows {
    public static void main(String[] args) {
        Integer computerZagadal = new MultiDigitGuessNumber().guess(1000, 9999);
        System.out.println("Enter number:");
        HumanPlayer myUser = new HumanPlayer();
        Integer number = myUser.makeMove();

        while (!number.equals(computerZagadal)) {
            CounterChecker c = new CounterChecker();
            HashMap<String, Integer> map = c.countBullsAndCows(computerZagadal, number);

            System.out.println("Bulls: " + map.get("bulls"));
            System.out.println("Cows: " + map.get("cows"));

            System.out.println("Enter number:");
            number = myUser.makeMove();
        }
        System.out.println("You win!");
        // scanner.close();
    }
}
