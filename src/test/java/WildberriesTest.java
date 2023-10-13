import Aston_AQA.WildberriesBasketPage;
import Aston_AQA.WildberriesHomePage;
import Aston_AQA.WildberriesProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WildberriesTest {
    private static WildberriesHomePage homePage;
    private static WildberriesProductPage productPage;
    private static WildberriesBasketPage basketPage;
    private static WebDriver driver;
    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new WildberriesHomePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://www.wildberries.ru/");
    }

    @BeforeEach
    void setWait() {
        driver.manage().timeouts().scriptTimeout(Duration.ofMillis(5000));
    }
    @AfterAll
    static void tearDown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        homePage.quit();
    }
    @Test
    void smokeTest() {
        homePage.goToBasket();
    }

    }
