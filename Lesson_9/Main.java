import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //first task
        StreamOps ops = new StreamOps();
        System.out.println(StreamOps.getEvenCount(ops.initList(20)));
        System.out.println(StreamOps.getStrFirst("Highload", "High", "Load", "Highload"));
        System.out.println(StreamOps.getStrLast("Highload", "High", "Load", "Highload1"));
        System.out.println(StreamOps.
                getStrPredicateCount("High", "Highload", "High", "Load", "Highload1"));
        System.out.println(Arrays.toString(StreamOps.
                stringToArr(new ArrayList<>(Arrays.asList("f10", "f15", "f2", "f4", "f4")))));

        System.out.println("------------------------------------------------------------------");
        //second task
        List<String> inputList = new ArrayList<>();
        Students students = new Students();
        System.out.println(students.getMansAverageAge());
        students.timeToArmy();
        System.out.println("------------------------------------------------------------------");
        //last task
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            if (input.equals("")) {
                break;
            }
            inputList.add(input);
        }
        inputList.stream().filter(s -> s.startsWith("f")).forEach(System.out::println);
    }
}
