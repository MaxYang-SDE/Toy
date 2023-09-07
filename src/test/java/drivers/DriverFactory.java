package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driverLocal = new ThreadLocal<>();

    private static WebDriver createWebDriver(String browserType) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        WebDriver driver;
        try {
            switch (browserType.toLowerCase()) {
                case "chrome": {
                    capabilities.setBrowserName("chrome");
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/"), capabilities);
                    break;
                }
                case "firefox": {
                    capabilities.setBrowserName("firefox");
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/"), capabilities);
                    break;
                }
                case "edge": {
                    capabilities.setBrowserName("edge");
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/"), capabilities);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("browser type is not supported!");
                }
            }
            driver.manage().window().maximize();
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return driver;
    }

    // will be called
    // 1) during the initialization of each page
    // 2) during the step definition
    // 3) after each test
    public static WebDriver getDriver() {
        return driverLocal.get();
    }

    // Will be called before each test
    public static WebDriver getDriver(String browserType) {
        if (driverLocal.get() == null) {
            driverLocal.set(createWebDriver(browserType));
        }
        return driverLocal.get();
    }

    public static void teardown() {
        if (driverLocal.get() != null) {
            driverLocal.get().quit();
            driverLocal.remove();
        }
    }
}
