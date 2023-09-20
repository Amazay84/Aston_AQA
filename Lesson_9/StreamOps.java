import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOps {
    private List<Integer> numbers;

    public StreamOps() {
    }

    public List<Integer> initList(int count) {
        numbers = new ArrayList<>();
        if (count < 0) {
            return new ArrayList<>();
        } else {
            for (int i = 0; i < count; i++) {
                numbers.add((int) (Math.random() * 100));
            }
        }
        return numbers;
    }

    public static long getEvenCount(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).count();
    }

    public static long getStrPredicateCount(String predicate, String... arg) {
        return Arrays.stream(arg).filter(s -> s.contains(predicate)).count();
    }

    public static String getStrFirst(String... arg) {
        return Arrays.stream(arg).findFirst().orElse("0");
    }

    public static String getStrLast(String... arg) {
        return Arrays.stream(arg).skip(arg.length - 1).findAny().orElse("0");
    }

    public static String[] stringToArr(List<String> strings) {
        return strings.stream().
                map(s -> Integer.parseInt(s.substring(1, s.length()))).
                sorted((o1, o2) -> o1 - o2).
                map(s -> ("f".concat(String.valueOf(s)))).
                collect(Collectors.toList()).
                toArray(new String[strings.size()]);
    }
}
