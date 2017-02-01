package weather;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import static weather.SingletonWebDriver.driver;
import static weather.SingletonWebDriver.getDriverInstance;


public class DriverProvider  {
    @Before
    public void init() {
        driver = getDriverInstance();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }

}

