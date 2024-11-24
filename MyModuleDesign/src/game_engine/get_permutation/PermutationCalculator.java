package game_engine.get_permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationCalculator implements Permutation {
    // Метод для вычисления всех перестановок списка
    @Override
    public Set<List<Integer>> calculatePermutations(List<Integer> digits) {
        Set<List<Integer>> permutations = new HashSet<>();
        generatePermutations(new ArrayList<>(), digits, permutations);
        return permutations;
    }

    // Рекурсивный метод для генерации перестановок
    private void generatePermutations(List<Integer> prefix, List<Integer> remaining, Set<List<Integer>> result) {
        if (remaining.isEmpty()) {
            result.add(new ArrayList<>(prefix)); // Добавляем готовую перестановку
        } else {
            for (int i = 0; i < remaining.size(); i++) {
                // Копируем текущий список, исключая выбранный элемент
                List<Integer> newRemaining = new ArrayList<>(remaining);
                Integer current = newRemaining.remove(i);

                // Добавляем текущий элемент к префиксу
                List<Integer> newPrefix = new ArrayList<>(prefix);
                newPrefix.add(current);

                // Рекурсивный вызов
                generatePermutations(newPrefix, newRemaining, result);
            }
        }
    }
}


// линкед листы и used - правильно ли работало вопрос

    // public List<List<Integer>> calculatePermutations(List<Integer> digits) {
    //     List<List<Integer>> permutations = new ArrayList<>();
    //     generatePermutations(new ArrayList<>(), digits, new boolean[digits.size()], permutations);
    //     return permutations;
    // }

    // // Рекурсивный метод для генерации перестановок
    // private void generatePermutations(
    //         List<Integer> prefix, List<Integer> digits, boolean[] used, List<List<Integer>> result) {
    //     if (prefix.size() == digits.size()) {
    //         result.add(new ArrayList<>(prefix)); // Добавляем готовую перестановку
    //         return;
    //     }

    //     for (int i = 0; i < digits.size(); i++) {
    //         // Пропускаем уже использованные элементы
    //         if (used[i]) {
    //             continue;
    //         }

    //         // Пропускаем дубликаты на одном уровне рекурсии
    //         if (i > 0 && digits.get(i).equals(digits.get(i - 1)) && !used[i - 1]) {
    //             continue;
    //         }

    //         // Используем текущий элемент
    //         used[i] = true;
    //         prefix.add(digits.get(i));

    //         // Рекурсивно обрабатываем оставшиеся элементы
    //         generatePermutations(prefix, digits, used, result);

    //         // Отменяем выбор текущего элемента
    //         used[i] = false;
    //         prefix.remove(prefix.size() - 1);
    //     }
    // }