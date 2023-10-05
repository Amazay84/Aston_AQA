import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ChromeTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setupSystem() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
    }

    @BeforeEach
    public void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://www.mts.by/");
    }

    @Test
    void checkBlockName() {
       List<WebElement> elements = driver.findElements(By.xpath("//section/div/h2"));
       String actual = elements.stream().map(s -> s.getText()).collect(Collectors.joining());
       String expected = "Онлайн пополнение\n".concat("без комиссии");
       Assertions.assertEquals(expected, actual);
    }
}
