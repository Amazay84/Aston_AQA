import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class CalcElements {
    @FindBy(id = "")
    private WebElement plus;
    @FindBy (id = "")
    private WebElement minus;
    @FindBy (id = "")
    private WebElement multiply;
    @FindBy (id = "")
    private WebElement divide;
    @FindBy (id = "")
    private WebElement one;
    @FindBy (id = "")
    private WebElement two;
    @FindBy (id = "")
    private WebElement three;
    @FindBy (id = "")
    private WebElement four;
    @FindBy (id = "")
    private WebElement five;
    @FindBy (id = "")
    private WebElement six;
    @FindBy (id = "")
    private WebElement seven;
    @FindBy (id = "")
    private WebElement eight;
    @FindBy (id = "")
    private WebElement nine;
    @FindBy (id = "")
    private WebElement zero;

    public WebElement getEqual() {
        return equal;
    }

    @FindBy (id = "")
    private WebElement equal;

    public WebElement getPlus() {
        return plus;
    }

    public WebElement getMinus() {
        return minus;
    }

    public WebElement getMultiply() {
        return multiply;
    }

    public WebElement getDivide() {
        return divide;
    }

    public WebElement getOne() {
        return one;
    }

    public WebElement getTwo() {
        return two;
    }

    public WebElement getThree() {
        return three;
    }

    public WebElement getFour() {
        return four;
    }

    public WebElement getFive() {
        return five;
    }

    public WebElement getSix() {
        return six;
    }

    public WebElement getSeven() {
        return seven;
    }

    public WebElement getEight() {
        return eight;
    }

    public WebElement getNine() {
        return nine;
    }

    public WebElement getZero() {
        return zero;
    }

    public WebElement waitVisible(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(element));
    }

}
