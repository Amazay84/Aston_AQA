import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class CalcMainScreen extends CalcElements {
    private AppiumDriver driver;

    public CalcMainScreen(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofMillis(5000)), this);
        this.driver = driver;
    }

    public CalcMainScreen add(WebElement firstTerm, WebElement secondTerm) {
        waitVisible(driver, firstTerm).click();
        waitVisible(driver, getPlus()).click();
        waitVisible(driver, secondTerm).click();
        waitVisible(driver, getEqual()).click();
        return this;
    }
    public CalcMainScreen sub(WebElement firstTerm, WebElement secondTerm) {
        waitVisible(driver, firstTerm).click();
        waitVisible(driver, getMinus()).click();
        waitVisible(driver, secondTerm).click();
        waitVisible(driver, getEqual()).click();
        return this;
    }

    public CalcMainScreen multiply(WebElement firstTerm, WebElement secondTerm) {
        waitVisible(driver, firstTerm).click();
        waitVisible(driver, getMultiply()).click();
        waitVisible(driver, secondTerm).click();
        waitVisible(driver, getEqual()).click();
        return this;
    }

    public CalcMainScreen divide(WebElement firstTerm, WebElement secondTerm) {
        waitVisible(driver, firstTerm).click();
        waitVisible(driver, getDivide()).click();
        waitVisible(driver, secondTerm).click();
        waitVisible(driver, getEqual()).click();
        return this;
    }


}
