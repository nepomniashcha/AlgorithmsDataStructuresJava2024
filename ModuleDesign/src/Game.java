
import GameEngine.Check.CounterChecker;
import GameEngine.Guess.GuessNumber;
import GameEngine.Guess.MultiDigitGuessNumber;
import Player.NewPlayer;

import java.util.HashMap;

public class Game {
    public Game (NewPlayer myUser, GuessNumber guessNumber) {
        Integer randomizedNumber = new MultiDigitGuessNumber().guess(1000, 9999);
        System.out.println("Enter number:");
        Integer number = myUser.makeMove();

        while (!number.equals(randomizedNumber)) {
            CounterChecker c = new CounterChecker();
            HashMap<String, Integer> map = c.countBullsAndCows(randomizedNumber, number);

            System.out.println("Bulls: " + map.get("bulls"));
            System.out.println("Cows: " + map.get("cows"));

            System.out.println("Enter number:");
            number = myUser.makeMove();
        }
        System.out.println("You win!");
        // scanner.close();
    }
}
