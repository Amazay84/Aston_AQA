import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

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
    void checkBlockName() {
        List<WebElement> elements = driver.findElements(By.xpath("//section/div/h2"));
        if (elements.isEmpty()) {
            throw new NoSuchElementException();
        }
        String actual = elements.stream().map(WebElement::getText).collect(Collectors.joining());
        String expected = "Онлайн пополнение\n".concat("без комиссии");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findLogoPaySys() {
        WebElement element1 = driver.findElement(By.xpath("//section/div/div[2]/ul/li[1]/img"));
        WebElement element2 = driver.findElement(By.xpath("//section/div/div[2]/ul/li[2]/img"));
        WebElement element3 = driver.findElement(By.xpath("//section/div/div[2]/ul/li[3]/img"));
        WebElement element4 = driver.findElement(By.xpath("//section/div/div[2]/ul/li[4]/img"));
        WebElement element5 = driver.findElement(By.xpath("//section/div/div[2]/ul/li[5]/img"));
        WebElement element6 = driver.findElement(By.xpath("//section/div/div[2]/ul/li[6]/img"));
        assertAll(() -> assertTrue(element1.isDisplayed()),
                () -> assertTrue(element2.isDisplayed()),
                () -> assertTrue(element3.isDisplayed()),
                () -> assertTrue(element4.isDisplayed()),
                () -> assertTrue(element5.isDisplayed()),
                () -> assertTrue(element6.isDisplayed()));
    }


}
