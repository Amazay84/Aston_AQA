import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
public class CalcMainScreen extends CalcElements {
    private WebDriver driver;

    public CalcMainScreen(WebDriver driver) {
        PageFactory.initElements(driver, this);
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
