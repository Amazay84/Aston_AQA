import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChromeTest {
    private static WebDriver driver;

//    @BeforeAll
//    public static void setupSystem() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
//    }
//
//    @BeforeEach
//    public void setupDriver() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
//        driver.get("https://www.mts.by/");
//    }
//    @AfterEach
//    public void tearDown() {
//        driver.quit();
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
       String actual = elements.stream().map(s -> s.getText()).collect(Collectors.joining());
       String expected = "Онлайн пополнение\n".concat("без комиссии");
       Assertions.assertEquals(expected, actual);
    }

    @Test
    void findLogoPaySys() {
        WebElement element1 = driver.findElement(By.xpath("//section/div/div[2]/ul/li[1]/img"));
        String actual1 = element1.getAttribute("src");
        String expected1 =
                "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg";
        WebElement element2 = driver.findElement(By.xpath("//section/div/div[2]/ul/li[2]/img"));
        String actual2 = element2.getAttribute("src");
        String expected2 =
                "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg";
        WebElement element3 = driver.findElement(By.xpath("//section/div/div[2]/ul/li[3]/img"));
        String actual3 = element3.getAttribute("src");
        String expected3 =
                "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg";
        WebElement element4 = driver.findElement(By.xpath("//section/div/div[2]/ul/li[4]/img"));
        String actual4 = element4.getAttribute("src");
        String expected4 =
                "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg";
        WebElement element5 = driver.findElement(By.xpath("//section/div/div[2]/ul/li[5]/img"));
        String actual5 = element5.getAttribute("src");
        String expected5 =
                "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg";
        WebElement element6 = driver.findElement(By.xpath("//section/div/div[2]/ul/li[6]/img"));
        String actual6 = element6.getAttribute("src");
        String expected6 =
                "https://www.mts.by/local/templates/new_design/assets/html/images/pages/index/pay/mir.svg";
        assertAll("Element didn't found",
                () -> assertEquals(expected1, actual1),
                () -> assertEquals(expected2, actual2),
                () -> assertEquals(expected3, actual3),
                () -> assertEquals(expected4, actual4),
                () -> assertEquals(expected5, actual5),
                () -> assertEquals(expected6, actual6));
    }
}
