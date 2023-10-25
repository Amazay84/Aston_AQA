import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class TestListener implements TestWatcher {
    @Override
    public void testSuccessful(ExtensionContext context) {
        Allure.getLifecycle().addAttachment("The reason of trst failing.", "image/png", "png"
                , ((TakesScreenshot) TestCfg.driver).getScreenshotAs(OutputType.BYTES));
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.getLifecycle().addAttachment("The reason of trst failing.", "image/png", "png"
                , ((TakesScreenshot) TestCfg.driver).getScreenshotAs(OutputType.BYTES));
    }
}
