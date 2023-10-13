package Aston_AQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public abstract class AbstractWilberries {
    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;
    private ExpectedConditions ep;
    private WebElement product;

    public AbstractWilberries(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.manage().window().maximize();
    }
}
