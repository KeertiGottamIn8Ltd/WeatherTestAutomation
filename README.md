WeatherTestAutomation

Weather Test Automation is a Acceptance test automation framwork developed to test the weatehr webapplication using Selenium Webdriver, Cucumber, Java. Junit, Maven. The whole test automation project is biult with to cover the current requirements and possible solution to reuse for furutre requirement at most extense. 

Installation and Running
Used 

Selenium-Java 2.53.1,Junit 4.12, 
Cucumber-Java8 1.2.4, 
JDK 1.8
IntelliJ IDEA Community 2016.2
Maven Build Project.

Import or Load Project

1. Go to Github https://github.com/KeertiGottamIn8Ltd/WeatherTestAutomation
2. Git clone - https://github.com/KeertiGottamIn8Ltd/WeatherTestAutomation.git Or Download. 
3. Open any IDE like IntelliJ or Eclipse
4. Import the cloned/downloaded project as MVN Project.
5. Make sure all the plugins needed in the IDE  and let the load the whole project.
6. Select the Feature file and run it. 

Note: Make sure before you run the Tests run your application. 

Example

Gherkin for any requireement is as below. 

Feature: As a User
 
 Given I should be in weather report site   
    So that I can see weather for any city
       
   
   Scenario Outline: Check the city weather for 5 Days
    
    Given I am in WeatherSite
    
    When I enter city city as <city>
    
    And I click on <day>
    
Examples:
  
  | city      | day       |
  
  | Edinburgh | Tuesday   | 
  
  | Glasgow   | Wednesday | 

The above example expalins how to do we write a feaure file to display the Weather of a city on Selected Day basis. 

**This is just an example, its not actual test. Actual tests are in the /resources folder.

Documentation

I have added only SRC , POM.xml, README.md files only so that anyone can import to any IDE and create as Maven project. 
Used Page Object Model as a Design pattern of the project so that we can abstract and reuse the code efficiently.
Tried to refactor as much as we can reuse at the same time maintained the reaability of the code.
How to contribute
Have an idea? Found something wrong? Send me the list of them and will try the fix for those. I also accept contributions (via GitHub pull requests)!

Where is this project used?
If you are using this code in one of your projects, mention it. 

License
In8ltd.co.uk © Keerti Gottam
