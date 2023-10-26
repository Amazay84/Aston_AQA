import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestCfg {
    protected static AndroidDriver<AndroidElement> driver;
    protected static CalcMainScreen calc;
    protected String expectedExpr;
    protected String expectedExprRes;
    protected String actualExpr;
    protected String actualExprRes;

    public static void initDrv() {
        driver = MobileFactory.getAndroidDriver();
        calc = new CalcMainScreen(driver);
    }
    @BeforeAll
    public static void setup() {
        initDrv();
        calc.clear().clear();
    }

    @BeforeEach
    public void tearDown() {
        actualExpr = "";
        actualExprRes = "";
        expectedExpr = "";
        expectedExprRes = "";
        calc.clear().clear();
        System.out.println("----------");
    }

    @AfterAll
    public static void teardown() {
        driver.close();
        driver.quit();
    }
}
