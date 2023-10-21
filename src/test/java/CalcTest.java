import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalcTest {
    private static AndroidDriver driver;
    private static CalcMainScreen calc;
//    private static InitDriver initDriver;
    @BeforeAll
    public static void setup() {
        driver = MobileFactory.getAndroidDriver();
        calc = new CalcMainScreen(driver);
//        driver = InitDriver.initialize();
//        calc = new CalcMainScreen(driver);

    }
    @BeforeEach
    public void setInitDriver() {
    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
    @Test
    public void multiplyTest() {
        calc.multiply(calc.getNine(), calc.getEight()).getEqual();
        String expectedExpr = calc.getExpr();
        String expectedExprRes = calc.getExprRes();
        System.out.println(expectedExpr + "\n" + expectedExprRes);
    }
}
