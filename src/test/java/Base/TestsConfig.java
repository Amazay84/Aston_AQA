package Base;

import WbPages.WildberriesBasketPage;
import WbPages.WildberriesElements;
import WbPages.WildberriesHomePage;
import WbPages.WildberriesProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.HashMap;

public abstract class TestsConfig {
    private static WildberriesHomePage homePage;
    private static WildberriesProductPage productPage;
    private static WildberriesBasketPage basketPage;
    private static WebDriver driver;

    public static WildberriesHomePage getHomePage() {
        return homePage;
    }

    public static WildberriesProductPage getProductPage() {
        return productPage;
    }

    public static WildberriesBasketPage getBasketPage() {
        return basketPage;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new WildberriesHomePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://www.wildberries.by/");
    }

//    @BeforeEach
//    void setWait() {
//
//        driver.manage().timeouts().scriptTimeout(Duration.ofMillis(5000));
//    }

    @AfterEach
    void setClean() {
        WildberriesElements.setProductInfo(new HashMap<>());
    }
    @AfterAll
    static void tearDown() {
        driver.quit();
    }

}
