package Aston_AQA;

import java.util.stream.LongStream;

public class Factorial {
    public long calc(int f) {
        if (f < 2) {
            return 1;
        }
        return LongStream.rangeClosed(2, f).
                reduce((f1, f2) -> f1 * f2).
                getAsLong();
    }
}
