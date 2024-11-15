package GameEngine.Check;

import java.util.ArrayList;
import java.util.HashMap;

public class CounterChecker implements Checker {
    private ArrayList<Integer> computerNumber = new ArrayList<>();
    private ArrayList<Integer> userNumber = new ArrayList<>();
    private HashMap<String, Integer> map = new HashMap<>();

    public HashMap<String, Integer> countBullsAndCows(Integer num1, Integer num2) {
        Integer copyComputerNumber = num1;
        Integer copyUserNumber = num2;

        while (copyComputerNumber != 0 && copyUserNumber != 0) {
            computerNumber.add(copyComputerNumber % 10);
            userNumber.add(copyUserNumber % 0);
            copyComputerNumber /= 10;
            copyUserNumber /= 10;
        }

        int bulls = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                bulls++;
                computerNumber.set(i, -1);
                userNumber.set(i, -2);
            }
        }

        int cows = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (userNumber.get(i) != -2 && computerNumber.contains(userNumber.get(i))) {
                cows++;
                computerNumber.set(computerNumber.indexOf(userNumber.get(i)), -1);
            }
        }
        
        map.put("bulls", bulls);
        map.put("cows", cows);
        return map;
    }
}
