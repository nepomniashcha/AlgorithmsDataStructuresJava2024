package player;

import java.util.*;
import game_engine.get_permutation.PermutationCalculator;

public class ComputerPlayer implements NewPlayer {
    private int currentDigit = 1;
    private ArrayList<Integer> detectedDigits = new ArrayList<>();
    private boolean digitsDetected = false;
    private Set<List<Integer>> permutations;
    private List<List<Integer>> permutationList;
    private int currentPermutationIndex = 0;

    @Override
    public String makeMove() {
        if (!digitsDetected) {
            return getBulls(currentDigit);
        } else {
            if (currentPermutationIndex < permutationList.size()) {
                List<Integer> currentPermutation = permutationList.get(currentPermutationIndex);
                String guess = convertToString(currentPermutation);
                System.out.println("Permutation: " + guess);
                currentPermutationIndex++;
                return guess;
            } else {
                throw new IllegalStateException("Something went wrong...");
            }
        }
    }

    private String getBulls(int digit) {
        String move = String.valueOf(digit).repeat(4);
        System.out.println("Let's check the number " + move);
        return move;
    }

    public void analyzeResponse(HashMap<String, Integer> response) {
        if (!digitsDetected) {
            int bulls = response.get("bulls");
            if (bulls > 0) {
                for (int i = 0; i < bulls; i++) {
                    detectedDigits.add(currentDigit);
                }
            }
            currentDigit++;

            if (currentDigit > 9) {
                if (detectedDigits.size() < 4) {
                    int length = 4 - detectedDigits.size();
                    for (int i = 0; i < length; i++) {
                        detectedDigits.add(0); 
                    }
                }
                digitsDetected = true;
                permutations = new PermutationCalculator().calculatePermutations(detectedDigits);
                permutationList = new ArrayList<>(permutations);
                System.out.println("All the digits were found: " + detectedDigits);
            }
        }
    }

    private String convertToString(List<Integer> digits) {
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sb.append(digit);
        }
        return sb.toString();
    }

}