package pageObjectModels;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public BasePage() {
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    protected void waitUntilVisible(By locator) {
        new WebDriverWait(getDriver(), 15).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitUntilClickable(By locator) {
        new WebDriverWait(getDriver(), 15).until(ExpectedConditions.elementToBeClickable(locator));
    }
}
