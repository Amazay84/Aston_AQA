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
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class OnlinePaymentTest {
    private static WebDriver driver;
    Set<Cookie> coocies;

    private WebElement elementWithXpath(WebDriver driver, String text) {
        return driver.findElement(By.xpath(text));
    }

    private String buttonWithText(String text) {
        return "//button[text()=".concat("'").concat(text).concat("'").concat("]");
    }

    private String formWithId(String text) {
        return "//form//input[@id=".concat("'").concat(text).concat("'").concat("]");
    }

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
        coocies = driver.manage().getCookies();
        coocies.stream().forEach(c -> driver.manage().addCookie(c));
    }

    @AfterEach
    void teardown() {
        coocies.stream().forEach(c-> driver.manage().deleteCookie(c));
        driver.quit();
    }

    @Test
    void checkBlockNameTest() {
        List<WebElement> elements = driver.findElements(By.xpath("//section/div/h2"));
        String actual = elements.stream().map(WebElement::getText).collect(Collectors.joining());
        String expected = "Онлайн пополнение\n".concat("без комиссии");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findLogoPaySysTest() {
        List<WebElement> icons = driver.findElements(By.xpath("//section//ul/li/img"));
        assertAll(() -> assertTrue(icons.get(0).isDisplayed()),
                () -> assertTrue(icons.get(1).isDisplayed()),
                () -> assertTrue(icons.get(2).isDisplayed()),
                () -> assertTrue(icons.get(3).isDisplayed()),
                () -> assertTrue(icons.get(4).isDisplayed()),
                () -> assertTrue(icons.get(5).isDisplayed()));
    }

    @Test
    void serviceDetailsLincTest() {
        WebElement aboutService = driver.findElement(By.xpath("//section[@class = 'pay']//a"));
        aboutService.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        String title = driver.getTitle();
        String expected = "Порядок оплаты и безопасность интернет платежей";
        Assertions.assertEquals(expected, title);
    }

    @Test
    void continueButtonTest() {
        WebElement phone = elementWithXpath(driver, formWithId("connection-phone"));
        WebElement amount = elementWithXpath(driver, formWithId("connection-sum"));
        WebElement email = elementWithXpath(driver, formWithId("connection-email"));
        WebElement nextButton = driver.findElement(By.xpath(buttonWithText("Продолжить")));
        phone.click();
        phone.sendKeys("297777777");
        amount.click();
        amount.sendKeys("99");
        email.click();
        email.sendKeys("test@test.by");
        nextButton.click();
        WebDriver iFrame = driver.switchTo().frame(
                driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        List<WebElement> elements = new WebDriverWait(iFrame, Duration.ofMillis(5000))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//div[@class='header__payment']/p")));
        String actual = elements.stream().map(e -> e.getText()).collect(Collectors.joining("\n"));
        String expected = "99.00 BYN\n".concat("Оплата: Услуги связи Номер:375297777777");
        assertEquals(expected, actual);
    }
}
