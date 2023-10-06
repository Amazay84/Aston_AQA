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

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChromeTest {
    private static WebDriver driver;

    public static String getData(int index) {
        File txt = new File("src/main/resources/data/chromeTest.txt");
        List<String> attr = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(txt))) {
            attr = br.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attr.get(index);
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
        String actual1 = element1.getAttribute("src");
        String expected1 = getData(0);
        WebElement element2 = driver.findElement(By.xpath("//section/div/div[2]/ul/li[2]/img"));
        String actual2 = element2.getAttribute("src");
        String expected2 = getData(1);
        WebElement element3 = driver.findElement(By.xpath("//section/div/div[2]/ul/li[3]/img"));
        String actual3 = element3.getAttribute("src");
        String expected3 = getData(2);
        WebElement element4 = driver.findElement(By.xpath("//section/div/div[2]/ul/li[4]/img"));
        String actual4 = element4.getAttribute("src");
        String expected4 = getData(3);
        WebElement element5 = driver.findElement(By.xpath("//section/div/div[2]/ul/li[5]/img"));
        String actual5 = element5.getAttribute("src");
        String expected5 = getData(4);
        WebElement element6 = driver.findElement(By.xpath("//section/div/div[2]/ul/li[6]/img"));
        String actual6 = element6.getAttribute("src");
        String expected6 = getData(5);
        assertAll("Element didn't found",
                () -> assertEquals(expected1, actual1),
                () -> assertEquals(expected2, actual2),
                () -> assertEquals(expected3, actual3),
                () -> assertEquals(expected4, actual4),
                () -> assertEquals(expected5, actual5),
                () -> assertEquals(expected6, actual6));
    }
}
