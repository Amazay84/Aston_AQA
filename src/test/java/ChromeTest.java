import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class ChromeTest {
    private static WebDriver driver;

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
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void checkBlockNameTest() {
        List<WebElement> elements = driver.findElements(By.xpath("//section/div/h2"));
        if (elements.isEmpty()) {
            throw new NoSuchElementException();
        }
        String actual = elements.stream().map(WebElement::getText).collect(Collectors.joining());
        String expected = "Онлайн пополнение\n".concat("без комиссии");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findLogoPaySysTest() {
        WebElement visa = driver.findElement(By.xpath("//section/div/div[2]/ul/li[1]/img"));
        WebElement verifiedByVisa = driver.findElement(By.xpath("//section/div/div[2]/ul/li[2]/img"));
        WebElement MasterCard = driver.findElement(By.xpath("//section/div/div[2]/ul/li[3]/img"));
        WebElement masterCardSecureCode = driver.findElement(
                By.xpath("//section/div/div[2]/ul/li[4]/img"));
        WebElement belCard = driver.findElement(By.xpath("//section/div/div[2]/ul/li[5]/img"));
        WebElement mir = driver.findElement(By.xpath("//section/div/div[2]/ul/li[6]/img"));
        assertAll(() -> assertTrue(visa.isDisplayed()),
                () -> assertTrue(verifiedByVisa.isDisplayed()),
                () -> assertTrue(MasterCard.isDisplayed()),
                () -> assertTrue(masterCardSecureCode.isDisplayed()),
                () -> assertTrue(belCard.isDisplayed()),
                () -> assertTrue(mir.isDisplayed()));
    }

    @Test
    void serviceDetailsLincTest() {
        WebElement aboutService = driver.findElement(By.xpath("//section[@class = 'pay']/div/a"));
        aboutService.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        String title = driver.getTitle();
        String expected = "Порядок оплаты и безопасность интернет платежей";
        Assertions.assertEquals(expected, title);
    }

    @Test
    void continueButtonTest() {
        WebElement phone = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        WebElement amount = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        WebElement email = driver.findElement(By.xpath("//*[@id=\"connection-email\"]"));
        WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        phone.click();
        phone.sendKeys("297777777");
        amount.click();
        amount.sendKeys("99");
        email.click();
        email.sendKeys("test@test.by");
        nextButton.click();
        WebDriver iFrame = driver.switchTo().frame(
                driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        try {
            Thread.sleep(3000);//не исправлять, тут какя-то магия
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> elements = iFrame.findElements(
                By.xpath("//div[@class='header__payment']/p"));
        elements.stream().forEach(e -> System.out.println(e.getText()));
        iFrame.findElement(By.xpath("//svg-icon[@class='header__close-icon']")).click();
//        iFrame.close();
//        WebElement head = wait.until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("/html/head/title[text()='BePaidWidget']")));
//
//        Assertions.assertEquals("BePaidWidget", head.getText());
    }
}
