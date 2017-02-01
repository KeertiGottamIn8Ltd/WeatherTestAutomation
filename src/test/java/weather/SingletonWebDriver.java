package weather;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SingletonWebDriver {
    protected static WebDriver driver;

    protected static WebDriver getDriverInstance() {
        if (null == driver) {
            driver = new FirefoxDriver();
        }
        return driver;

    }


}
