import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class CalcTest {
    private static AndroidDriver driver;
    private static CalcMainScreen calc;
    @BeforeAll
    public static void setup() {
        driver = MobileFactory.getAndroidDriver();
        calc = new CalcMainScreen(driver);
    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
