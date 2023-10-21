import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CalcMainScreen extends CalcElements {
    private AndroidDriver<AndroidElement> driver;
    private String expr;
    private String exprRes;

    public CalcMainScreen(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofMillis(5000)), this);
        this.driver = driver;
    }

    public CalcMainScreen add(AndroidElement firstTerm, AndroidElement secondTerm) {
        waitVisible(driver, firstTerm).click();
        waitVisible(driver, getPlus()).click();
        waitVisible(driver, secondTerm).click();
        waitVisible(driver, getEqual()).click();
        expr = waitVisible(driver, getExpression()).getAttribute("content-desc");
        exprRes = waitVisible(driver, getEqual()).getAttribute("text");
        return this;
    }
    public CalcMainScreen sub(AndroidElement firstTerm, AndroidElement secondTerm) {
        waitVisible(driver, firstTerm).click();
        waitVisible(driver, getMinus()).click();
        waitVisible(driver, secondTerm).click();
        waitVisible(driver, getEqual()).click();
        expr = waitVisible(driver, getExpression()).getAttribute("content-desc");
        exprRes = waitVisible(driver, getEqual()).getAttribute("text");
        return this;
    }

    public CalcMainScreen multiply(AndroidElement firstTerm, AndroidElement secondTerm) {
        waitVisible(driver, firstTerm).click();
        waitVisible(driver, getMultiply()).click();
        waitVisible(driver, secondTerm).click();
        waitVisible(driver, getEqual()).click();
        expr = waitVisible(driver, getExpression()).getAttribute("content-desc");
        exprRes = waitVisible(driver, getEqual()).getAttribute("text");
        return this;
    }

    public CalcMainScreen divide(AndroidElement firstTerm, AndroidElement secondTerm) {
        waitVisible(driver, firstTerm).click();
        waitVisible(driver, getDivide()).click();
        waitVisible(driver, secondTerm).click();
        waitVisible(driver, getEqual()).click();
        expr = waitVisible(driver, getExpression()).getAttribute("content-desc");
        exprRes = waitVisible(driver, getEqual()).getAttribute("text");
        return this;
    }

    public String getExpr() {
        return expr;
    }

    public String getExprRes() {
        return exprRes;
    }
}
