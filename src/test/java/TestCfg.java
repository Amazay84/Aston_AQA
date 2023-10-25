import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public abstract class TestCfg {
    protected static AndroidDriver<AndroidElement> driver;
    protected static CalcMainScreen calc;
    protected String expectedExpr;
    protected String expectedExprRes;
    protected String actualExpr;
    protected String actualExprRes;

    public static void initDrv() {
        driver = MobileFactory.getAndroidDriver();
        calc = new CalcMainScreen(driver);
//        driver.register(new CustomRep());
    }
    @BeforeAll
    public static void setup() {
        initDrv();
        calc.clear().clear();
    }

    @AfterEach
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
        calc.closeCalcApp();
    }
}
