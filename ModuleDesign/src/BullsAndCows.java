import game_engine.Guess.MultiDigitGuessNumber;
import player.ComputerPlayer;
import player.HumanPlayer;

public class BullsAndCows {
    public static void main(String[] args) {
        // new Game(new ComputerPlayer(), new MultiDigitGuessNumber());
        new Game(new HumanPlayer(), new MultiDigitGuessNumber());
    }
}
