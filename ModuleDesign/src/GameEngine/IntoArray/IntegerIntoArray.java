package GameEngine.IntoArray;

import java.util.ArrayList;

public class IntegerIntoArray implements IntoArray {
    private ArrayList<Integer> arrayNumber = new ArrayList<>();

    public ArrayList<Integer> toArray(Integer num) {
        Integer copyNum = num;

        while (copyNum > 0) {
            arrayNumber.add(copyNum % 10);
            copyNum /= 10;
        }

        return arrayNumber;
    }
}
