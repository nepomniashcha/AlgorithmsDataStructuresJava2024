
import GameEngine.Check.Counter;
import GameEngine.Guess.GuessMultiDigitNumber;
import Player.User;

import java.util.HashMap;

public class BullsAndCows {
    public static void main(String[] args) {
        Integer computerZagadal = new GuessMultiDigitNumber().guess(1000, 9999);
        System.out.println("Enter number:");
        User myUser = new User();
        Integer number = myUser.makeMove();

        while (!number.equals(computerZagadal)) {
            Counter c = new Counter();
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
