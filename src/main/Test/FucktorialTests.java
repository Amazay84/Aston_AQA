import org.junit.jupiter.api.*;

public class FucktorialTests {
    private Fucktorial fucktorial;
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
        fucktorial = new Fucktorial();
    }
    @AfterEach
    void clean() {
        fucktorial = null;
    }
    @Test
    void calcFucktorialTest() {
        System.out.println("Expected: " + "362880"
                + System.lineSeparator() +
                "Actual: " +
                fucktorial.calc(9));
        Assertions.assertEquals(362880, fucktorial.calc(9));
    }
}
