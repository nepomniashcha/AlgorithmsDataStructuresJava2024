package GameEngine.Guess;
import java.lang.Math;

public class MultiDigitGuessNumber implements GuessNumber {
    public Integer guess(Integer a, Integer b) {
        return (int) (Math.random() * (b - a + 1) + a);
    }
}
