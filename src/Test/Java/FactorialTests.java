import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTests {
    private Factorial factorial;
    @BeforeAll
    static void startMsg() {
        System.out.println("Start TEST");
    }
    @AfterAll
    static void endMsg() {
        System.out.println("End TEST");
    }
    @BeforeEach
    void setUp() {
        factorial = new Factorial();
    }
    @AfterEach
    void tearDown() {
        factorial = null;
    }
    @Test
    void groupAssertions() {
        assertAll("factorial",
                () -> {
            assertEquals(1, factorial.calc(0));
                    System.out.println(factorial.calc(0));
                },
                () -> {
            assertEquals(1, factorial.calc(1));
                    System.out.println(factorial.calc(1));
                },
                () -> {
            assertEquals(2, factorial.calc(2));
                    System.out.println(factorial.calc(2));
                },
                () -> {
            assertEquals(362880, factorial.calc(9));
                    System.out.println(factorial.calc(9));
                }
        );
    }


}
