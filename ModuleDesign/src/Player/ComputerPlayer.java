package Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DataProcessing.Input.ConsoleInputData;

public class ComputerPlayer implements NewPlayer {
    // private ArrayList<Integer> number = new ArrayList<>();

    // public Integer makeMove() {
    //     System.out.println(1111);
    //     while (true) {
    //         Scanner scanner = new Scanner(System.in);
    //         String line1 = scanner.nextLine();
    //         String line2 = scanner.nextLine();
    //         int bulls = Integer.parseInt(line1.split(": ")[1]);
    //         int cows = Integer.parseInt(line2.split(": ")[1]);

    //         for (int i = 2; i < 10; i++) {
    //             System.out.println(i * 1000 + i * 100 + i * 10 + i);
    //             line1 = scanner.nextLine();
    //             line2 = scanner.nextLine();
    //             bulls = Integer.parseInt(line1.split(": ")[1]);
    //             cows = Integer.parseInt(line2.split(": ")[1]);

    //             if (bulls == 4) {break;}
    //         }


    //         for (int i = 0; i < 9; i++) {
    //             for (int j = 0; j < 9; j++) {
    //                 for (int k = 0; k < 9; k++) {
    //                     for (int l = 0; l < 9; l++) {
    //                         i * 1000 + j * 100 + k * 10 + l;
                            
    //                     }
    //                 }
    //             }
    //         }
    //     }

    //     return 1;
    // }


    public String makeMove() {
        Scanner scanner = new Scanner(System.in);
        String secret = scanner.nextLine();

        // Перебор "1111", "2222", ...
        StringBuilder foundDigits = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            String guess = String.valueOf(i).repeat(secret.length());
            int bulls = countBulls(secret, guess);

            if (bulls > 0) {
                foundDigits.append(String.valueOf(i).repeat(bulls));
            }

            if (foundDigits.length() == secret.length()) {
                break; // Если все цифры найдены, прекращаем поиск
            }
        }

        // Генерация перестановок найденных цифр
        List<String> permutations = generatePermutations(foundDigits.toString());

        // Перебор перестановок до совпадения
        for (String perm : permutations) {
            if (countBulls(secret, perm) == secret.length()) {
                return perm;
            }
        }
    }

    private static int countBulls(String secret, String guess) {
        int bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }
        }
        return bulls;
    }

    // Метод для генерации перестановок заданного набора цифр
    private static List<String> generatePermutations(String input) {
        List<String> result = new ArrayList<>();
        permute(input.toCharArray(), 0, result);
        return result;
    }

    // Рекурсивная функция для создания перестановок
    private static void permute(char[] chars, int index, List<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            permute(chars, index + 1, result);
            swap(chars, i, index); // Отмена изменений для следующей итерации
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
