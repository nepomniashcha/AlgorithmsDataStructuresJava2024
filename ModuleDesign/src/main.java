import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Integer computerZagadal = (int) (Math.random() * (9999 - 1000 + 1) + 1000);
        System.out.println(computerZagadal);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        Integer number = scanner.nextInt();

        while (!number.equals(computerZagadal)) {
            Integer copy_computerZagadal = computerZagadal;
            Integer copy_user_number = number;

            ArrayList<Integer> computer_number = new ArrayList<>();
            ArrayList<Integer> user_number = new ArrayList<>();

            while (copy_computerZagadal > 0) {
                computer_number.add(copy_computerZagadal % 10);
                user_number.add(copy_user_number % 10);
                copy_computerZagadal /= 10;
                copy_user_number /= 10;
            }

            int bulls = 0, cows = 0;
            for (int i = 0; i < computer_number.size(); i++) {
                for (int j = 0; j < user_number.size(); j++) {
                    if (computer_number.get(i).equals(user_number.get(i)) && i == j) {
                        bulls++;
                    }
                    if (computer_number.get(i).equals(user_number.get(i)) && i != j) {
                        cows++;
                    }
                }
            }

            System.out.println("Bulls: " + bulls);
            System.out.println("Cows: " + cows);
            bulls = cows = 0;
            System.out.println("Enter number:");
            number = scanner.nextInt();
        }
        System.out.println("You win!");
        scanner.close();
    }
}
