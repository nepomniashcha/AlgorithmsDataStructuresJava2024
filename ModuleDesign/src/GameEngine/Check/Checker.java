package GameEngine.Check;

import java.util.HashMap;

public interface Checker {
    // boolean 
    // public Integer countBulls(Integer num);
    // public Integer countCows(Integer num);
    public HashMap<String, Integer> countBullsAndCows(Integer num1, Integer num2);
}
