import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //first task
        String str = "ехал грека через реку видит грека в реке рак сунул грека руку в реку рак за руку греку цап";
        String[] arr = str.split(" ");
        List<String> arrList = Arrays.asList(arr);

        Map<String, Integer> listMap = new HashMap<>();
        for (String s : arrList) {
            if (listMap.containsKey(s)) {
                listMap.put(s, listMap.get(s) + 1);
            } else {
                listMap.put(s, 1);
            }
        }

        listMap.entrySet().
                forEach(entry ->
                        System.out.println("Word: " + entry.getKey() +
                                " | Repetition count: " + entry.getValue()));
        System.out.println("-----------------------------------------------------------------");

        for (int i = 0; i < arrList.size(); i++) {
            if (!arrList.subList(0, i).contains(arrList.get(i))) {
                System.out.printf("Word \"%s\" has repeated %d times.\n", arrList.get(i),
                        Collections.frequency(arrList, arrList.get(i)));
            }
        }
        System.out.println("--------------------------------------------------------------");

        //second task

        TelephoneDirectory td = new TelephoneDirectory();
        td.add("Ivanov: +375298889998");
        td.add("Ivanov: +375296888999");
        td.add("Petrov: +375298989898");
        td.add("Petrov: +375299898989");
        td.add("Petrov: +375299898989");
        td.add("Sidorov: +375299090909");
        td.add("Sidorov: +375290009999");
        td.add("");
        td.add("Sidorov: ");
        td.add(" +375290009999");

        System.out.println(td.get("Ivanov"));
        System.out.println(td.get("Petrov"));
        System.out.println(td.get("Sidorov"));
    }
}
