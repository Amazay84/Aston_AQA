import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WildberriesProductPage {
    WebDriver driver;
    @FindBy(xpath = "//*[@class='price-block__final-price']")
    private WebElement price;
    @FindBy (xpath = "//*[@data-link='text{:selectedNomenclature^goodsName}']")
    private WebElement productName;

    @FindBy (xpath = "//*[text()='Добавить в корзину']")
    private List<WebElement> addToBasketBtn;
    @FindBy (xpath = "//*[@alt='Wildberries']")
    private WebElement homePageBtn;
    @FindBy (xpath = "//*[@id='basketContent']")
    private WebElement basket;


    public WildberriesProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String getPriceVal() {
        return price.getText();
    }
    public String getProductName() {
        return productName.getText();
    }
    public WildberriesProductPage addToBasket() {
        new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.elementToBeClickable(addToBasketBtn.get(1))).click();
        return this;
    }
    public WildberriesHomePage backToHome() {
        new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.elementToBeClickable(homePageBtn)).click();
        return new WildberriesHomePage(driver);
    }
    public WildberriesBasketPage goToBasket() {
        basket.click();
        return new WildberriesBasketPage(driver);
    }

}
