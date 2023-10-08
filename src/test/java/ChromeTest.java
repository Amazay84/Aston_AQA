import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ChromeTest {
    private static WebDriver driver;

    private WebElement elementWithXpath(WebDriver driver, String text) {
        WebElement element = driver.findElement(By.xpath(text));
        return element;
    }

    private String labelWithText(String text) {
        return "//label[text()=".concat("'").concat(text).concat("'").concat("]");
    }

    private String buttonWithText(String text) {
        return "//button[text()=".concat("'").concat(text).concat("'").concat("]");
    }

//    private WebElement elementWithCss(WebDriver driver, String text) {
//        WebElement element = driver.findElement(By.cssSelector(text));
//        return element;
//    }
    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://www.mts.by/");
        WebElement phone = elementWithXpath(driver, "//*[@id='connection-phone']");
        WebElement amount = elementWithXpath(driver, "//*[@id='connection-sum']");
        WebElement email = elementWithXpath(driver, "//*[@id='connection-email']");
        phone.click();
        phone.sendKeys("297777777");
        amount.click();
        amount.sendKeys("99");
        email.click();
        email.sendKeys("test@test.by");
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void continueButtonTest() {
        WebElement nextButton = elementWithXpath(driver, buttonWithText("Продолжить"));
        nextButton.click();
        WebDriver iFrame = driver.switchTo().frame(elementWithXpath(driver, "//iframe[@class='bepaid-iframe']"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> elements = iFrame.findElements(
                By.xpath("//div[@class='header__payment']/p"));
        WebElement iPayButton = elementWithXpath(iFrame, "//app-card-page//button/text()");
        boolean iInputCardNum = elementWithXpath(iFrame, labelWithText("Номер карты")).isDisplayed();

        assertAll(() -> assertEquals("Оплатить 99.00 BYN", iPayButton.getText()),
                () -> assertTrue(iInputCardNum));


//        iFrame.findElement(By.xpath("//svg-icon[@class='header__close-icon']")).click();
//        Assertions.assertEquals("BePaidWidget", head.getText());
    }
}
