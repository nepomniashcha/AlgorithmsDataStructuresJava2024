package DataProcessing.Input;

import java.util.Scanner;

public class ConsoleInputData implements InputData {
    private Integer number;
    public void readData() {
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
    }
    public Integer getData() {
        return this.number;
    }
}
