package Player;

import DataProcessing.Input.ConsoleInputData;

public class User implements NewPlayer {
    public Integer makeMove() {
        ConsoleInputData input = new ConsoleInputData();
        input.readData();
        return input.getData();
    }
}