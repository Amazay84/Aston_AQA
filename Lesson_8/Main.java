import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //first task
        String[] arr = {"Hello", "Java", "Hello", "World", "Goodbye", "Welcome", "Java", "Friday",
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

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
        td.add("Ivanov: 999888999");
        td.add("Ivanov: 888999888");
        td.add("Petrov: 8989898989");
        td.add("Petrov: 9898989898");
        td.add("Petrov: 9898989898");
        td.add("Sidorov: 9090909090");
        td.add("Sidorov: 000999999000");
        System.out.println(td.get("Ivanov"));
        System.out.println(td.get("Petrov"));
        System.out.println(td.get("Sidorov"));
    }
}
