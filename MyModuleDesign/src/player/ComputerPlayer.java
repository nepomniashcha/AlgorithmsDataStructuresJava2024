package player;

import java.util.*;
import game_engine.get_permutation.PermutationCalculator;

public class ComputerPlayer implements NewPlayer {
    private int currentDigit = 1; // Текущая цифра
    private ArrayList<Integer> detectedDigits = new ArrayList<>(); // Найденные цифры
    private boolean digitsDetected = false; // Флаг завершения нахождения цифр
    private Set<List<Integer>> permutations; // Все перестановки
    private List<List<Integer>> permutationList; // Перестановки в виде списка
    private int currentPermutationIndex = 0; // Индекс текущей перестановки

    // Экземпляр PermutationCalculator
    private final PermutationCalculator permutationCalculator = new PermutationCalculator();

    @Override
    public String makeMove() {
        if (!digitsDetected) {
            // Если цифры ещё не найдены, проверяем текущую цифру
            return getBulls(currentDigit);
        } else {
            // Если цифры найдены, проверяем каждую перестановку
            if (currentPermutationIndex < permutationList.size()) {
                // Берём текущую перестановку
                List<Integer> currentPermutation = permutationList.get(currentPermutationIndex);
                String guess = convertToString(currentPermutation);
                System.out.println("Компьютер проверяет перестановку: " + guess);
                currentPermutationIndex++; // Переходим к следующей перестановке
                return guess;
            } else {
                throw new IllegalStateException("Все перестановки проверены, но число не найдено.");
            }
        }
    }

    private String getBulls(int digit) {
        String move = String.valueOf(digit).repeat(4);
        System.out.println("Компьютер вводит число: " + move);
        return move;
    }

    public void analyzeResponse(HashMap<String, Integer> response) {
        if (!digitsDetected) {
            // Анализируем результат для текущей цифры
            int bulls = response.get("bulls");
            if (bulls > 0) {
                for (int i = 0; i < bulls; i++) {
                    detectedDigits.add(currentDigit); // Добавляем текущую цифру
                }
            }
            currentDigit++;

            // Если проверены все цифры от 1 до 9, начинаем перестановки
            if (currentDigit > 9) {
                digitsDetected = true;
                // Используем экземпляр PermutationCalculator для вычисления перестановок
                permutations = permutationCalculator.calculatePermutations(detectedDigits);
                permutationList = new ArrayList<>(permutations); // Конвертируем в список для индексированного доступа
                System.out.println("Все цифры найдены: " + detectedDigits);
                System.out.println("Всего перестановок: " + permutations.size());
            }
        }
    }

    // Преобразование списка цифр в строку
    private String convertToString(List<Integer> digits) {
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sb.append(digit);
        }
        return sb.toString();
    }

}