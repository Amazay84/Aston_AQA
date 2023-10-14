import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WildberriesBasketPage {
    private WebDriver driver;
    @FindBy (xpath = "//*[@class='count__plus plus']")
    private WebElement plusBtn;
    @FindBy (xpath = "//input[@type='number']")
    private WebElement inputQuantityField;
    @FindBy (xpath = "//*[@alt='Wildberries']")
    private WebElement homePageBtn;
    public WildberriesBasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.get("https://www.wildberries.ru/lk/basket");
    }

    public WildberriesBasketPage setQuantity() {
        new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.elementToBeClickable(plusBtn)).click();
        return this;
    }

    public WildberriesBasketPage setQuantityCount(String quantity) {
        new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.elementToBeClickable(inputQuantityField)).sendKeys(quantity);
        return this;
    }

    public WildberriesHomePage backToHome() {
        new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.elementToBeClickable(homePageBtn)).click();
        return new WildberriesHomePage(driver);
    }
}
