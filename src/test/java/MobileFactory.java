import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class MobileFactory {
    public static AndroidDriver getAndroidDriver() {
        AndroidDriver driver = null;
        try {
            URL url = new URL("http://127.0.0.0:4723/wd/hub");
            driver =  new AndroidDriver(url, MobileCapabilities.getAndroidCapabilities());
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        return driver;
    }
}
