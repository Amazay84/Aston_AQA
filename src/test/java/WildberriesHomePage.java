import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;
import java.util.List;

public class WildberriesHomePage extends WildberriesElements {
    private final WebDriver driver;
    private Actions actions;
    @FindBy(xpath = "//*[@class='card b-card']")
    private List<WebElement> products;
    @FindBy(xpath = "//*[@class='btn btn--primary b-card__btn btn-basket']")
    private List<WebElement> addToBasketButton;
    @FindBy(xpath = "//*[@class='quantity__plus']")
    private List<WebElement> quantityPlus;

    public WildberriesHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public WildberriesProductPage selectProduct(int itemNum) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,1000)");
        new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.visibilityOf(products.get(itemNum))).click();
        return new WildberriesProductPage(driver);
    }

    public WildberriesHomePage searchProduct(String productName) {
        new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.visibilityOf(searchField)).sendKeys(productName);
        return this;
    }

    public WildberriesHomePage clickSearchBtn() {
        new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.visibilityOf(searchField)).sendKeys(Keys.ENTER);
        return this;
    }

    public WildberriesHomePage setQuantity(int prodNum) {
        new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.visibilityOf(quantityPlus.get(prodNum))).click();
        return this;
    }

    public WildberriesBasketPage goToBasket() {
        new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.elementToBeClickable(basketBtn)).click();
        return new WildberriesBasketPage(driver);
    }

}
