package DataProcessing.Input;

import java.util.Scanner;

public class ConsoleInputData implements InputData {
    private String data;

    @Override
    public void readData() {
        Scanner scanner = new Scanner(System.in);
        try {
            String input = scanner.nextLine();

            if (!input.matches("[1-9][0-9]{3}")) {
                throw new IllegalArgumentException("Only four-digit number (hint: it doesn't begin with zero)!");
            }

            this.data = input;
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            System.out.flush();
        }
    }

    public String getData() {
        return this.data;
    }
}
