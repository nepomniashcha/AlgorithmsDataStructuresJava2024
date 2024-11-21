package player;

import data_processing.input.ConsoleInputData;

public class HumanPlayer implements NewPlayer {
    public String makeMove() {
        ConsoleInputData input = new ConsoleInputData();
        input.readData();
        return input.getData();
    }
}
