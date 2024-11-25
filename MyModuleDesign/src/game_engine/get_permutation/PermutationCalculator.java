package game_engine.get_permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationCalculator implements Permutation {
    @Override
    public Set<List<Integer>> calculatePermutations(List<Integer> digits) {
        Set<List<Integer>> permutations = new HashSet<>();
        generatePermutations(new ArrayList<>(), digits, permutations);
        return permutations;
    }
    private void generatePermutations(List<Integer> prefix, List<Integer> remaining, Set<List<Integer>> result) {
        if (remaining.isEmpty()) {
            result.add(new ArrayList<>(prefix));
        } else {
            for (int i = 0; i < remaining.size(); i++) {
                if (prefix.isEmpty() && remaining.get(i) == 0) {
                    continue;
                }
    
                List<Integer> newRemaining = new ArrayList<>(remaining);
                Integer current = newRemaining.remove(i);
    
                List<Integer> newPrefix = new ArrayList<>(prefix);
                newPrefix.add(current);
    
                generatePermutations(newPrefix, newRemaining, result);
            }
        }
    }
    
}