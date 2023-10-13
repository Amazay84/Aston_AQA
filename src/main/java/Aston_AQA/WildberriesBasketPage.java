package Aston_AQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WildberriesBasketPage {
    private WebDriver driver;
    public WildberriesBasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.get("https://www.wildberries.ru/lk/basket");
    }

}
