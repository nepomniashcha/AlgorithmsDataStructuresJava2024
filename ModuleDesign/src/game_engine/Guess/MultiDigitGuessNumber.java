package game_engine.Guess;
import java.lang.Math;

public class MultiDigitGuessNumber implements GuessNumber {
    @Override
    public Integer guess(Integer a, Integer b) {
        return (int) (Math.random() * (b - a + 1) + a);
    }
}
