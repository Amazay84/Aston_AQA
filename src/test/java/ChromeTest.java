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

public class ChromeTest {
    private static WebDriver driver;

    private WebDriverWait wait;
    private Set<Cookie> coocies;

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
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        coocies = driver.manage().getCookies();
        coocies.stream().forEach(c -> driver.manage().addCookie(c));
        WebElement phone = elementWithXpath(driver, "//*[@id='connection-phone']");
        WebElement amount = elementWithXpath(driver, "//*[@id='connection-sum']");
        WebElement email = elementWithXpath(driver, "//*[@id='connection-email']");
        WebElement nextButton = elementWithXpath(driver, buttonWithText("Продолжить"));
        phone.click();
        phone.sendKeys("297777777");
        amount.click();
        amount.sendKeys("99");
        email.click();
        email.sendKeys("test@test.by");
        nextButton.click();
    }

    @AfterEach
    void teardown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
    void propsSownTest() {
        WebDriver iFrame = driver.switchTo().frame(elementWithXpath(driver, "//iframe[@class='bepaid-iframe']"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> elements = iFrame.findElements(
                By.xpath("//div[@class='header__payment']/p"));
        assertAll(() -> assertEquals("99.00 BYN", elements.get(0).getText()),
                () -> assertEquals("Оплата: Услуги связи Номер:375297777777", elements.get(1).getText()));
    }

    @Test
    void iFramePayButtonTest() {
        WebDriver iFrame = driver.switchTo().frame(elementWithXpath(driver, "//iframe[@class='bepaid-iframe']"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        wait = new WebDriverWait(iFrame, Duration.ofMillis(5000));
//        boolean isPayButtonLoaded = new WebDriverWait(iFrame, Duration.ofMillis(3000))
//                .until(ExpectedConditions.attributeContains(By.xpath("//app-card-page" +
//                buttonWithText("Оплатить  99.00 BYN")), "text()", "Оплатить  99.00 BYN"));
        WebElement iPayButton = elementWithXpath(iFrame, "//app-card-page" +
                buttonWithText("Оплатить  99.00 BYN"));
//        assertTrue(isPayButtonLoaded);
        assertEquals("Оплатить  99.00 BYN", iPayButton.getText());
    }

    @Test
    void iFrameInputFieldsTextTest() {
        WebDriver iFrame = driver.switchTo().frame(elementWithXpath(driver, "//iframe[@class='bepaid-iframe']"));
        WebElement isInputCardNumShown = elementWithXpath(iFrame, labelWithText("Номер карты"));
        WebElement isInputThermOfUsageShown = elementWithXpath(iFrame, labelWithText("Срок действия"));
        WebElement isInputCVCShown = elementWithXpath(iFrame, labelWithText("CVC"));
        WebElement isInputCardHolderNameShown = elementWithXpath(iFrame, labelWithText("Имя держателя (как на карте)"));

        assertAll(() -> assertEquals("Номер карты", isInputCardNumShown.getText()),
                () -> assertEquals("Срок действия", isInputThermOfUsageShown.getText()),
                () -> assertEquals("CVC", isInputCVCShown.getText()),
                () -> assertEquals("Имя держателя (как на карте)", isInputCardHolderNameShown.getText()));

    }

    @Test
    void paySysIconsTest() {
        WebDriver iFrame = driver.switchTo().frame(elementWithXpath(driver, "//iframe[@class='bepaid-iframe']"));
        wait = new WebDriverWait(iFrame, Duration.ofMillis(5000));
        List<WebElement> icons = wait
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//app-input//img")));
        assertAll(() -> assertTrue(icons.get(0).isDisplayed()),
                () -> assertTrue(icons.get(1).isDisplayed()),
                () -> assertTrue(icons.get(2).isDisplayed()),
                () -> assertTrue(icons.get(3).isDisplayed()),
                () -> assertTrue(icons.get(4).isDisplayed()));
    }

    @Test
    void connectionServicesNotesTest() {
        List<WebElement> payFormSelect = driver.findElements(
                By.xpath("//section//ul[@class='select__list']/li"));
        payFormSelect.get(0).click();
        WebElement phone = elementWithXpath(driver, "//form//input[@id='connection-phone']");
        WebElement amount = elementWithXpath(driver, "//form//input[@id='connection-sum']");
        WebElement email = elementWithXpath(driver, "//form//input[@id='connection-email']");

    }
}
