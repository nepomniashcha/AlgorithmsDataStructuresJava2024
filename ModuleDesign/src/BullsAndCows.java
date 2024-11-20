import GameEngine.Guess.MultiDigitGuessNumber;
import Player.ComputerPlayer;
import Player.HumanPlayer;

public class BullsAndCows {
    public static void main(String[] args) {
        // new Game(new ComputerPlayer(), new MultiDigitGuessNumber());
        new Game(new HumanPlayer(), new MultiDigitGuessNumber());
    }
}
