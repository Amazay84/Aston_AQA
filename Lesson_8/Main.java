import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
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
                                " | Repeat count: " + entry.getValue()));
    }
}
