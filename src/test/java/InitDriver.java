import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class InitDriver {
    private static AndroidDriver<WebElement> driver;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    public static AndroidDriver<WebElement> initialize() {
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, "com.miui.calculator");
        try {
            driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        return driver;
    }
}
