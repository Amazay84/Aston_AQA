package Aston_AQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://www.mts.by/");

        List<WebElement> elements = driver.findElements(By.xpath("//section/div/h2"));
        String elem = elements.stream().map(s -> s.getText()).collect(Collectors.joining());
        System.out.println(elem);
        String result = "Онлайн пополнение\n" +
                "без комиссии";
    }
}