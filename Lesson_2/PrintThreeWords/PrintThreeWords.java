package PrintThreeWords;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintThreeWords {
    private ArrayList<String > list = new ArrayList<>(Arrays.asList("Orange", "Banana", "Apple"));

    public void printThreeWords() {
        list.stream().forEach(System.out::println);
    }
}
