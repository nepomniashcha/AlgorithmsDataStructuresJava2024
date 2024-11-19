
import GameEngine.Check.CounterChecker;
import GameEngine.Guess.GuessNumber;
import GameEngine.Guess.MultiDigitGuessNumber;
import Player.NewPlayer;

import java.util.HashMap;

public class Game<T extends NewPlayer> {
    public Game (T player, GuessNumber guessNumber) {
        Integer randomizedNumber = new MultiDigitGuessNumber().guess(1000, 9999);
        System.out.println("Good luck!");

        while (true) {
            System.out.println("Enter number:");
            String number = player.makeMove();
            Integer userNumber = Integer.parseInt(number);

            if (!userNumber.equals(randomizedNumber)) {
                System.out.println("Try again...");
                CounterChecker checker = new CounterChecker();
                HashMap<String, Integer> map = checker.countBullsAndCows(randomizedNumber, userNumber);

                System.out.println("Bulls: " + map.get("bulls"));
                System.out.println("Cows: " + map.get("cows"));
            } else {
                break;
            }
        }
        
        System.out.println("You win!");
        // scanner.close();
    }
}
