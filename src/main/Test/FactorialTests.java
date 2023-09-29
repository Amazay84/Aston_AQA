import org.junit.jupiter.api.*;

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
    void initialise() {
        factorial = new Factorial();
    }
    @AfterEach
    void clean() {
        factorial = null;
    }
    @Test
    void calcFucktorialTest() {
        System.out.println("Expected: " + "362880"
                + System.lineSeparator() +
                "Actual: " +
                factorial.calc(9));
        Assertions.assertEquals(362880, factorial.calc(9));
    }
}
