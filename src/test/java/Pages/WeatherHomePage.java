package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import weather.SingletonWebDriver;

import java.util.List;

public class WeatherHomePage extends SingletonWebDriver {

    public void check(String id, String content, Integer count) throws InterruptedException {
        List<WebElement> list = driver.findElements(By.cssSelector(id));
        Integer counter = 0;
        for (WebElement ele : list) {
            for (Integer x = 1; x <= count; x++)
                if ((ele.getAttribute("data-test")).contentEquals(content + "-" + x)) {
                    counter++;
                }
        }
        if (counter != 5) Assert.fail();
    }
    public void checkADayWeather(String day){
        switch (day) {
            case "Monday":    {     clickADay("Mon");       break;      }
            case "Tuesday":   {     clickADay("Tue");       break;      }
            case "Wednesday": {     clickADay("Wed");       break;      }
            case "Thursday":  {     clickADay("Thu");       break;      }
            case "Friday":    {     clickADay("Fri");       break;      }
            case "Saturday":  {     clickADay("Sat");       break;      }
            case "Sunday":    {     clickADay("Sun");       break;      }
            default: {
                System.out.println("Since we didn't find any option to match we have to fail your Test , Sorry We can't click anything ");
                Assert.fail();
            }
        }
    }
   public void clickADay(String day){
        driver.findElement(By.xpath("//span[text()='"+day+"']")).click();
    }

   public void enterCityName(String cityName) {
       driver.findElement(By.id("city")).clear();
       driver.findElement(By.id("city")).sendKeys(cityName);
       driver.findElement(By.id("city")).sendKeys(Keys.RETURN);
   }

   public void loadPage(String pageName){
       switch (pageName) {
           case "WeatherSite": {     driver.get("http://localhost:3000/");      break;      }
           default: {
               System.out.println("Since we didn't find any option to match we have to fail your Test , Sorry we can't load anything");
               Assert.fail();
           } }
   }

   public void checkWeatherDetails(Integer noOfDays, String item) throws InterruptedException {
       switch (item) {
           case "maximum temparatures": {      check("#root>div>div>div .max", "maximum", noOfDays);            break;      }
           case "minimum temparatures": {      check("#root>div>div>div .min", "minimum", noOfDays);            break;      }
           case "dominant wind speed":  {      check("#root>div>div>div .speed", "speed", noOfDays);            break;      }
           case "aggregate rainfall":   {      check("#root>div>div>div .rainfall", "rainfall", noOfDays);      break;      }
           case "dominant condition":   {      check("#root>div>div>div .icon", "description", noOfDays);       break;      }
           default: {
               System.out.println("Since we didn't find any option to match we have to fail your Test , Sorry we can't check anything");
               Assert.fail();
           }
       }
   }

   public int checkIntervalHourlyReport(){
       Integer onlyOneReportDisplayedAnyTime = 0;
       List<WebElement> l = driver.findElements(By.className("details"));
       for (WebElement ele : l) {
           if (ele.getAttribute("style").contains("2000px")) {
               onlyOneReportDisplayedAnyTime = 1;
           }
       }
   return onlyOneReportDisplayedAnyTime;
   }
}
