import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WildberriesHomePage {
    private final WebDriver driver;
    private Actions actions;
    @FindBy (xpath = "//*[@id='searchInput']")
    private WebElement search;
    @FindBy (xpath = "//*[@id='applySearchBtn']")
    private WebElement searchBtn;
    @FindBy (xpath = "//article/div/a")
    private List<WebElement> products;
    @FindBy (xpath = "//*[contains(text(), 'Добавить в корзину')]")
    private WebElement addToBasketButton;
    @FindBy (xpath = "//*[@id='basketContent']")
    private WebElement basket;

    public WildberriesHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public WildberriesHomePage useSearchField() {
        new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(search)).click();
        return this;
    }
    public WildberriesHomePage searchProduct(String text) {
        new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.elementToBeClickable(search)).sendKeys(text);
        return this;
    }

    public WildberriesHomePage searchBtnClick() {
        new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
        return this;
    }
    public WildberriesHomePage acceptSearch() {
        new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.elementToBeClickable(search)).
                sendKeys(Keys.ENTER);
        return this;
    }
    public WildberriesProductPage selectFirstProduct() {
        driver.manage().timeouts().scriptTimeout(Duration.ofMillis(5000));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        new WebDriverWait(driver, Duration.ofMillis(5000))
               .until(ExpectedConditions.elementToBeClickable(products.get(1))).click();
       return new WildberriesProductPage(driver);
    }

    public WildberriesProductPage selectSecondProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.elementToBeClickable(products.get(2))).click();
        return new WildberriesProductPage(driver);
    }
    public WildberriesProductPage selectThirdProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.elementToBeClickable(products.get(3))).click();
        return new WildberriesProductPage(driver);
    }


    public WildberriesBasketPage goToBasket() {
        basket.click();
        return new WildberriesBasketPage(driver);
    }

    public void quit() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
