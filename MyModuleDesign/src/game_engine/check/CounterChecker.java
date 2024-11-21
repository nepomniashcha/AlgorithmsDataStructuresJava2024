package game_engine.check;

import java.util.ArrayList;
import java.util.HashMap;

public class CounterChecker implements Checker {
    @Override
    public HashMap<String, Integer> countBullsAndCows(Integer num1, Integer num2) {
        ArrayList<Integer> computerNumber = getDigits(num1);
        ArrayList<Integer> userNumber = getDigits(num2);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("bulls", countBulls(computerNumber, userNumber));
        map.put("cows", countCows(computerNumber, userNumber));
        return map;
    }
    private int countBulls(ArrayList<Integer> computer, ArrayList<Integer> user) {
        int bulls = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(user.get(i))) {
                bulls++;
                computer.set(i, -1);
                user.set(i, -2);
            }
        }
        return bulls;
    }
    private int countCows(ArrayList<Integer> computer, ArrayList<Integer> user) {
        int cows = 0;
        for (int num : user) {
            if (num != -2 && computer.contains(num)) {
                cows++;
                computer.set(computer.indexOf(num), -1);
            }
        }
        return cows;
    }
    private ArrayList<Integer> getDigits(Integer number) {
        ArrayList<Integer> digits = new ArrayList<>();
        while (number != 0) {
            digits.add(number % 10);
            number /= 10;
        }
        for (int i = 0, j = digits.size() - 1; i < j; i++) {
            digits.add(i, digits.remove(j));
        }
        return digits;
    }
}

// private ArrayList<Integer> computerNumber = new ArrayList<>();
// private ArrayList<Integer> userNumber = new ArrayList<>();
// private HashMap<String, Integer> map = new HashMap<>();

// public HashMap<String, Integer> countBullsAndCows(Integer num1, Integer num2) {
//     Integer copyComputerNumber = num1;
//     Integer copyUserNumber = num2;

//     while (copyComputerNumber != 0 && copyUserNumber != 0) {
//         computerNumber.add(copyComputerNumber % 10);
//         userNumber.add(copyUserNumber % 10);
//         copyComputerNumber /= 10;
//         copyUserNumber /= 10;
//     }

//     int bulls = 0;
//     for (int i = 0; i < computerNumber.size(); i++) {
//         if (computerNumber.get(i).equals(userNumber.get(i))) {
//             bulls++;
//             computerNumber.set(i, -1);
//             userNumber.set(i, -2);
//         }
//     }

//     int cows = 0;
//     for (int i = 0; i < userNumber.size(); i++) {
//         if (userNumber.get(i) != -2 && computerNumber.contains(userNumber.get(i))) {
//             cows++;
//             computerNumber.set(computerNumber.indexOf(userNumber.get(i)), -1);
//         }
//     }
    
//     map.put("bulls", bulls);
//     map.put("cows", cows);
//     return map;
// }