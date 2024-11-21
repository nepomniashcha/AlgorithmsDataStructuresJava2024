package data_processing.input;

import java.util.Scanner;

public class ConsoleInputData implements InputData {
    private String data;

    @Override
    public void readData() {
        Scanner scanner = new Scanner(System.in);
        try {
            String input = scanner.nextLine();

            while (true) {
                if (!input.matches("^[0-9]{4}$")) {
                    System.out.println("Only four-digit number is accepted. Please enter your number again:");
                    input = scanner.nextLine();
                    continue;
                }
            
                if (!input.matches("^[1-9][0-9]{3}$")) {
                    System.out.println("0 as a first digit... Please enter your number again:");
                    input = scanner.nextLine();
                    continue;
                }
                break;
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
