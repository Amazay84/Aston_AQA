import Aston_AQA.Factorial;
import org.testng.Assert;
import org.testng.annotations.*;

public class FactorialTest {
    private static Factorial factorial;

    @BeforeClass
    static void startMsg() {
        System.out.println("Start TEST");
    }
    @AfterClass
    static void endMsg() {
        System.out.println("End TEST");
    }
    @BeforeMethod
    public static void setUp() {
        factorial = new Factorial();
    }
    @AfterMethod
    public static void tearDown() {
        factorial = null;
    }
    @Test
    public void factorialNullTest() {
        System.out.println("Factorial of 0: " + factorial.calc(0));
        Assert.assertEquals(1, factorial.calc(0));
    }
    @Test
    public void factorialOneTest() {
        System.out.println("Factorial of 1: " + factorial.calc(1));

        Assert.assertEquals(1, factorial.calc(1));
    }
    @Test
    public void factorialTwoTest() {
        System.out.println("Factorial of 2: " + factorial.calc(2));

        Assert.assertEquals(2, factorial.calc(2));
    }

    @Test
    public void factorialValueTest() {
        System.out.println("Factorial of 9: " + factorial.calc(9));

        Assert.assertEquals(362880, factorial.calc(9));
    }
}
