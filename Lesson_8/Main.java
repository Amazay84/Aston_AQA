import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //first task
        String str = "ехал грека через реку видит грека в реке рак сунул грека руку в реку рак за руку греку цап";
        String[] arr = str.split(" ");
        List<String> arrList = Arrays.asList(arr);
        Map<String, Integer> listMap = new HashMap<>();

//        arrList.forEach(s -> listMap.put(k, listMap.getOrDefault(s, 0) + 1));
//        arrList.forEach(s -> listMap.compute(s, (k, v) -> v == null ? 1 : v + 1));

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

        //second task

        TelephoneDirectory td = new TelephoneDirectory();
        td.add("Ivanov: +375298889998");
        td.add("Ivanov: +375296888999");
        td.add("Petrov: +375298989898");
        td.add("Petrov: +375299898989");
        td.add("Petrov: +375299898989");
        td.add("Sidorov: +375299090909");
        td.add("Sidorov: +375290009999");
        System.out.println(td.get("Ivanov"));
        System.out.println(td.get("Petrov"));
        System.out.println(td.get("Sidorov"));
    }
}
