package Player;

import GameEngine.Check.CounterChecker;
import java.util.*;

public class ComputerPlayer implements NewPlayer {
    private List<Integer> digitsToGuess; // Список возможных цифр
    private Map<Integer, Integer> correctDigits; // Хранит правильно угаданные цифры и их количество
    private List<String> permutations; // Список возможных комбинаций
    private Iterator<String> permutationIterator; // Итератор для перебора комбинаций
    private int currentDigit; // Текущая цифра для перебора
    private int totalBulls; // Суммарное количество "быков"

    public ComputerPlayer() {
        this.digitsToGuess = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        this.correctDigits = new HashMap<>();
        this.permutations = new ArrayList<>();
        this.permutationIterator = null;
        this.currentDigit = 1; // Начинаем с "1111"
        this.totalBulls = 0;
    }

    @Override
    public String makeMove() {
        // Если все цифры найдены, начинаем генерировать и перебирать перестановки
        if (totalBulls == 4 && (permutationIterator == null || !permutationIterator.hasNext())) {
            generatePermutations();
            permutationIterator = permutations.iterator();
        }

        // Если перебираем перестановки
        if (permutationIterator != null && permutationIterator.hasNext()) {
            return permutationIterator.next();
        }

        // Генерация числа для проверки
        StringBuilder guess = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            guess.append(currentDigit);
        }
        currentDigit++;
        return guess.toString();
    }

    public void updateFeedback(int bulls, int cows) {
        // Если получили хотя бы одного "быка", добавляем текущую цифру в корректные
        if (bulls > 0) {
            correctDigits.put(currentDigit - 1, bulls);
            totalBulls += bulls;
        }
    }

    private void generatePermutations() {
        // Генерируем все перестановки из найденных цифр
        List<Integer> digits = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : correctDigits.entrySet()) {
            digits.addAll(Collections.nCopies(entry.getValue(), entry.getKey()));
        }

        Set<String> uniquePermutations = new HashSet<>();
        permute(digits, 0, uniquePermutations);
        permutations = new ArrayList<>(uniquePermutations);
    }

    private void permute(List<Integer> digits, int index, Set<String> result) {
        if (index == digits.size() - 1) {
            StringBuilder perm = new StringBuilder();
            for (int digit : digits) {
                perm.append(digit);
            }
            result.add(perm.toString());
        } else {
            for (int i = index; i < digits.size(); i++) {
                Collections.swap(digits, i, index);
                permute(digits, index + 1, result);
                Collections.swap(digits, i, index);
            }
        }
    }
}
