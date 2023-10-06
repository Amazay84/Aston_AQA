package Aston_AQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        File txt = new File("src/main/resources/data/chromeTest.txt");
        List<String> attr = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(txt))) {
            attr = br.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        attr.stream().forEach(System.out::println);
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
//        WebDriver driver;
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
//        driver.get("https://www.mts.by/");
//
//        WebElement element = driver.findElement(By.xpath("//section/div/div[2]/ul/li[6]/img"));
//        String result = element.getAttribute("src");
//
//        System.out.println(result);
//        driver.quit();
    }
}