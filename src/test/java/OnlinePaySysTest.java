import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlinePaySysTest implements TestUtils {
    private static WebDriver driver;
    private Set<Cookie> cookies;
    private WebElement selectArrow;
    private List<WebElement> payFormSelect;
    private final String XPATH_SELECTOR = "//section//button/span[@class='select__arrow']";
    private final String PAY_FORM_SELECTOR = "//section//ul[@class='select__list']/li";
    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        cookies = driver.manage().getCookies();
        cookies.stream().forEach(c -> driver.manage().addCookie(c));
        selectArrow = waitUntilBecomeVisible(driver, XPATH_SELECTOR);
        selectArrow.click();
        payFormSelect = waitUntilBecomeVisibleAll(driver, PAY_FORM_SELECTOR);
    }

    @AfterEach
    void teardown() {
        cookies.stream().forEach(c -> driver.manage().deleteCookie(c));
        driver.quit();
    }

    @Test
    void connectionServicesNotesTest() {
        payFormSelect.get(0).click();
        WebElement phone = elementWithXpath(driver, formWithId("connection-phone"));
        WebElement sum = elementWithXpath(driver, formWithId("connection-sum"));
        WebElement email = elementWithXpath(driver, formWithId("connection-email"));
        assertAll(() -> assertEquals("Номер телефона", phone.getAttribute("placeholder")),
                () -> assertEquals("Сумма", sum.getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", email.getAttribute("placeholder")));
    }

    @Test
    void internetServicesNotesTest() {
        payFormSelect.get(1).click();
        WebElement subscriberNum = elementWithXpath(driver, formWithId("internet-phone"));
        WebElement sum = elementWithXpath(driver, formWithId("connection-sum"));
        WebElement email = elementWithXpath(driver, formWithId("internet-email"));
        assertAll(() -> assertEquals("Номер абонента", subscriberNum.getAttribute("placeholder")),
                () -> assertEquals("Сумма", sum.getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", email.getAttribute("placeholder")));
    }

    @Test
    void installmentServicesNotesTest() {
        payFormSelect.get(2).click();
        WebElement scoreInstalment = elementWithXpath(driver, formWithId("score-instalment"));
        WebElement sum = elementWithXpath(driver, formWithId("instalment-sum"));
        WebElement email = elementWithXpath(driver, formWithId("instalment-email"));
        assertAll(() -> assertEquals("Номер счета на 44", scoreInstalment.getAttribute("placeholder")),
                () -> assertEquals("Сумма", sum.getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", email.getAttribute("placeholder")));
    }
    @Test
    void debtServicesNotesTest() {
        payFormSelect.get(2).click();
        WebElement accountNum = elementWithXpath(driver, formWithId("score-arrears"));
        WebElement sum = elementWithXpath(driver, formWithId("arrears-sum"));
        WebElement email = elementWithXpath(driver, formWithId("arrears-email"));
        assertAll(() -> assertEquals("Номер счета на 2073", accountNum.getAttribute("placeholder")),
                () -> assertEquals("Сумма", sum.getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", email.getAttribute("placeholder")));
    }
}
