package GameEngine.Check;

import java.util.ArrayList;
import java.util.HashMap;

import GameEngine.IntoArray.IntegerIntoArray;

public class CounterChecker implements Checker {
    private ArrayList<Integer> computer_number = new ArrayList<>();
    private ArrayList<Integer> user_number = new ArrayList<>();
    private HashMap<String, Integer> map = new HashMap<>();

    public HashMap<String, Integer> countBullsAndCows(Integer num1, Integer num2) {
        computer_number = new IntegerIntoArray().toArray(num1);
        user_number = new IntegerIntoArray().toArray(num2);

        int bulls = 0;
        for (int i = 0; i < computer_number.size(); i++) {
            if (computer_number.get(i).equals(user_number.get(i))) {
                bulls++;
                computer_number.set(i, -1);
                user_number.set(i, -2);
            }
        }

        int cows = 0;
        for (int i = 0; i < user_number.size(); i++) {
            if (user_number.get(i) != -2 && computer_number.contains(user_number.get(i))) {
                cows++;
                computer_number.set(computer_number.indexOf(user_number.get(i)), -1);
            }
        }
        
        map.put("bulls", bulls);
        map.put("cows", cows);
        return map;
    }
}
