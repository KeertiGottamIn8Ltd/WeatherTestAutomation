package weather;

import Pages.WeatherHomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class StepDef1 extends WeatherHomePage {


    @When("^I am in (.*)$")
    public void load_page(String pageName) {
        loadPage(pageName);
    }

    @When("^I enter city city as (.*)$")
    public void enter_city(String cityName) {
        enterCityName(cityName);
    }

    @When("^I click on (.*)$")
    public void click_a_day(String day) throws InterruptedException {
        checkADayWeather(day);
    }

    @Then("^I should see (.*) days of weather$")
    public void days_of_weather(Integer noOfDays) throws InterruptedException {
        List<WebElement> p = driver.findElements(By.cssSelector("div span.name"));
        if (p.size() != noOfDays)
            Assert.fail();
    }

    @Then("^Intervalhours based reports are displayed for (.*)$")
    public void hoursly_reports_displayed(String day) {
        if (checkIntervalHourlyReport() != 1) Assert.fail();
    }

    @Then("^Intervalhours based reports are not displayed$")
    public void hourly_report_not_displayed() throws InterruptedException {
        if (checkIntervalHourlyReport() != 0) Assert.fail();
    }

    @Then("^I should see (.*) of report")
    public void check_hours_reports(Integer hoursInterval) throws InterruptedException {
        List<WebElement> list = driver.findElements(By.cssSelector("div span.hour"));
        List<Integer> hours = new ArrayList<Integer>();

        for (WebElement ele : list) {
            String text = ele.getText();
            if (text.trim().length() > 0) {
                hours.add(Integer.parseInt(text.trim()));
            }
        }

        for (Integer i = 0; i < hours.size(); i++) {
            if (i < hours.size() - 1)
                if ((((hours.get(i + 1))) / 100 - ((hours.get(i))) / 100) != hoursInterval)
                    Assert.fail();
        }
    }

    @And("^I see (.*) reports for (.*)$")
    public void check_hourly_reports_for_a_day(Integer noOfDays, String item) throws InterruptedException {
        checkWeatherDetails(noOfDays, item);
    }

}