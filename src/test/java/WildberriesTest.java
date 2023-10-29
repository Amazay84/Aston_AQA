import Base.TestsConfig;
import WbPages.WildberriesBasketPage;
import WbPages.WildberriesElements;
import org.junit.jupiter.api.*;

public class WildberriesTest extends TestsConfig {

    @Test
    void smokeTest() {
        String firstProd = "PlayStation 5 1200A (Япония), 3-я ревизия, с дисководом";
        String secondProd = "Геймпад для PS5 DualSense Black, черная полночь";

        getHomePage().searchProduct(firstProd).clickSearchBtn().selectProduct(0).addToBasket()
                .clickQuantityBtn().backToHome()
                .searchProduct(secondProd).clickSearchBtn().selectProduct(0)
                .addToBasket().clickQuantityBtn().backToHome()
                .goToBasket()
                .getProductInform();
        WildberriesElements.getProductInfo().forEach((k, v) -> System.out.println(k + " | " + v));

        String expectedPrice = String.format("%.2fр.",WildberriesElements.getTotalPriceFromInfo());
        System.out.println(expectedPrice);
        System.out.println("---------");

        String actualPrice = WildberriesBasketPage.getTotalPrice().replaceAll(" ", "");
        System.out.println(actualPrice);
        System.out.println("-|-|-|-|-|");

        int totalCountAtAllAtBasket = Integer.parseInt(WildberriesBasketPage.getBasketItemsCount());
        int firstProductCountAtBasket = Integer.parseInt(WildberriesBasketPage.getProductCounters(0));
        int secondProductCountAtBasket = Integer.parseInt(WildberriesBasketPage.getProductCounters(1));
        System.out.println(WildberriesBasketPage.getBasketItemsCount());
        System.out.println("---------");
        System.out.println(WildberriesBasketPage.getProductCounters(0) +
                " | " + WildberriesBasketPage.getProductCounters(1));

        Assertions.assertTrue(WildberriesElements.getProductInfo().containsKey(secondProd));
        Assertions.assertTrue(WildberriesElements.getProductInfo().containsKey(firstProd));
        Assertions.assertTrue(actualPrice.equals(expectedPrice));
        Assertions.assertTrue(
                (firstProductCountAtBasket + secondProductCountAtBasket) == totalCountAtAllAtBasket);
    }
}
