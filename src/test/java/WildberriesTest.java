import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
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
        driver.get("https://www.wildberries.by/");
    }

    @BeforeEach
    void setWait() {

        driver.manage().timeouts().scriptTimeout(Duration.ofMillis(5000));
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    void smokeTest() {
        homePage.searchProduct("playstation 5").clickSearchBtn().selectProduct(0).addToBasket()
                .clickQuantityBtn().backToHome()
                .searchProduct("playstation 5 геймпад").clickSearchBtn().selectProduct(0)
                .addToBasket().clickQuantityBtn().backToHome()
                .goToBasket()
                .getProductInform();
        WildberriesElements.getProductInfo().forEach((k, v) -> System.out.println(k + " | " + v));
        String expectedPrice = String.format("%.2fр.",WildberriesElements.getTotalPriceFromInfo());
        System.out.println(expectedPrice);
        System.out.println("---------");
        String actualPrice = WildberriesBasketPage.getTotalPrice().replaceAll(" ", "");
        System.out.println(actualPrice);
        String firstProd = "Геймпад для PS5 DualSense Black";
        String secondProd = "PlayStation 5 1200A (Япония), 3-я ревизия, с дисководом";
        Assertions.assertAll(() -> Assertions.assertTrue(WildberriesElements.getProductInfo().containsKey(firstProd)),
                () -> Assertions.assertTrue(WildberriesElements.getProductInfo().containsKey(secondProd)),
                () -> Assertions.assertTrue(actualPrice.equals(expectedPrice)));
    }
}
