package Aston_AQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WildberriesProductPage {
    WebDriver driver;
    @FindBy(xpath = "//*[@class='price-block__final-price']")
    private WebElement price;

    @FindBy (xpath = "//*[@data-link='text{:selectedNomenclature^goodsName}']")
    private WebElement productName;

    @FindBy (xpath = "//*[text()='Добавить в корзину']")
    private WebElement addToBasketBtn;

    public WildberriesProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String getPrice() {
        return price.getText();
    }
    public String getProductName() {
        return productName.getText();
    }
    public WildberriesProductPage addToBasket() {
        addToBasketBtn.click();
        return this;
    }
}
