import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public long getEvenCount(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).count();
    }

    public long getStrCount(String predicate, String... arg) {
        return Arrays.stream(arg).filter(s -> s.contains(predicate)).count();
    }
}
