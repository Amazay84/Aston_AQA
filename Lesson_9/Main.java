import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StreamOps ops = new StreamOps();
        System.out.println(StreamOps.getEvenCount(ops.initList(20)));
        System.out.println(StreamOps.getStrFirst("Highload", "High", "Load", "Highload"));
        System.out.println(StreamOps.getStrLast("Highload", "High", "Load", "Highload1"));
        System.out.println(StreamOps.
                getStrPredicateCount("High", "Highload", "High", "Load", "Highload1"));
        System.out.println(Arrays.toString(StreamOps.
                stringToArr(new ArrayList<>(Arrays.asList("f10", "f15", "f2", "f4", "f4")))));
    }
}
