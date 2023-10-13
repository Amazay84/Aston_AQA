package Aston_AQA;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WildberriesHomePage {
    private final WebDriver driver;
    private Actions actions;
    @FindBy (xpath = "//*[@id='searchInput']")
    private WebElement search;
    @FindBy (xpath = "//*[@id='applySearchBtn']")
    private WebElement searchBtn;
    @FindBy (xpath = "//*[@id='c161299502']/div/a")
    private WebElement firstProduct;
    @FindBy (xpath = "//*[@id=\"YzhlM2E3OWYtZjNiNy1jOGFiLThjNjctZDc5MTRiN2QyZmZl\"]/div/article[5]/div/a")
    private WebElement secondProduct;
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
       new WebDriverWait(driver, Duration.ofMillis(5000))
               .until(ExpectedConditions.elementToBeClickable(firstProduct)).click();
       return new WildberriesProductPage(driver);
    }

    public WildberriesProductPage selectSecondProduct() {
        new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.elementToBeClickable(secondProduct)).click();
        return new WildberriesProductPage(driver);
    }

    public WildberriesBasketPage goToBasket() {
        basket.click();
        return new WildberriesBasketPage(driver);
    }

    public void quit() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
