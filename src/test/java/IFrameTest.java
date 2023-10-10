import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class IFrameTest implements TestUtils {
    private static WebDriver driver;
    WebDriver iFrame;
    private WebDriverWait wait;
    private Set<Cookie> cookies;
    private final String XPATH_IFRAME = "//iframe[@class='bepaid-iframe']";
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
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        cookies = driver.manage().getCookies();
        cookies.stream().forEach(c -> driver.manage().addCookie(c));
        WebElement phone = elementWithXpath(driver, formWithId("connection-phone"));
        WebElement amount = elementWithXpath(driver, formWithId("connection-sum"));
        WebElement email = elementWithXpath(driver, formWithId("connection-email"));
        WebElement nextButton = elementWithXpath(driver, buttonWithText("Продолжить"));
        phone.click();
        phone.sendKeys("297777777");
        amount.click();
        amount.sendKeys("99");
        email.click();
        email.sendKeys("test@test.by");
        nextButton.click();
        iFrame = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(XPATH_IFRAME)));
    }

    @AfterEach
    void teardown() {
        cookies.stream().forEach(c -> driver.manage().deleteCookie(c));
        driver.quit();
    }

    @Test
    void propsSownTest() {
        List<WebElement> elements = waitUntilBecomeVisibleAll(iFrame, "//div[@class='header__payment']/p");
        assertAll(() -> assertEquals("99.00 BYN", elements.get(0).getText()),
                () -> assertEquals("Оплата: Услуги связи Номер:375297777777", elements.get(1).getText()));
    }

    @Test
    void iFramePayButtonTest() {
        WebElement iPayButton = waitUntilBecomeVisible(
                iFrame, "//app-card-page" + buttonWithText(" Оплатить  99.00 BYN "));
        assertEquals("Оплатить 99.00 BYN", iPayButton.getText());
    }

    @Test
    void iFrameInputFieldsTextTest() {
        WebElement isInputCardNumShown = waitUntilBecomeVisible(iFrame, labelWithText("Номер карты"));
        WebElement isInputThermOfUsageShown = waitUntilBecomeVisible(iFrame, labelWithText("Срок действия"));
        WebElement isInputCVCShown = elementWithXpath(iFrame, labelWithText("CVC"));
        WebElement isInputCardHolderNameShown =
                waitUntilBecomeVisible(iFrame,  labelWithText("Имя держателя (как на карте)"));
        assertAll(() -> assertEquals("Номер карты", isInputCardNumShown.getText()),
                () -> assertEquals("Срок действия", isInputThermOfUsageShown.getText()),
                () -> assertEquals("CVC", isInputCVCShown.getText()),
                () -> assertEquals("Имя держателя (как на карте)", isInputCardHolderNameShown.getText()));

    }

    @Test
    void paySysIconsTest() {
        List<WebElement> icons = waitUntilBecomeVisibleAll(iFrame, "//app-input//img");
        assertAll(() -> assertTrue(icons.get(0).isDisplayed()),
                () -> assertTrue(icons.get(1).isDisplayed()),
                () -> assertTrue(icons.get(2).isDisplayed()),
                () -> assertTrue(icons.get(3).isDisplayed()),
                () -> assertTrue(icons.get(4).isDisplayed()));
    }
}
