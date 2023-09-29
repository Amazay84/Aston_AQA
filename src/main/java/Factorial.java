import java.util.stream.LongStream;

public class Factorial {
    public long calc(int f) {
        if (f < 2) {
            return 1;
        }
        return LongStream.rangeClosed(2, f).
                reduce((l1, l2) -> l1 * l2).
                getAsLong();
    }
}
