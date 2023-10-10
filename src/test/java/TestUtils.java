import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public interface TestUtils {
     default WebElement elementWithXpath(WebDriver driver, String text) {
         return driver.findElement(By.xpath(text));
    }

    default String labelWithText(String text) {
        return "//label[text()=".concat("'").concat(text).concat("'").concat("]");
    }

    default String buttonWithText(String text) {
        return "//button[text()=".concat("'").concat(text).concat("'").concat("]");
    }

    default WebElement waitUntilBecomeVisible(WebDriver driver, String selector) {
        return new WebDriverWait(driver, Duration.ofMillis(10000))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }

    default List<WebElement> waitUntilBecomeVisibleAll(WebDriver driver, String selector) {
        return new WebDriverWait(driver, Duration.ofMillis(10000))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(selector)));
    }

    default String formWithId(String text) {
        return "//form//input[@id=".concat("'").concat(text).concat("'").concat("]");
    }

    default WebElement elementWithCss(WebDriver driver, String text) {
        return driver.findElement(By.cssSelector(text));
    }

}
