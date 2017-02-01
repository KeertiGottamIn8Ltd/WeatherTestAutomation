Feature: As a User
  I should be in weather report site
  So that I can see weather for any city

  Scenario Outline: Check the city weather for 5 Days
    Given I am in WeatherSite
    When I enter city city as <city>
    And I click on <day>
    Then Intervalhours based reports are displayed for <day>
    And I click on <day>
    Then Intervalhours based reports are not displayed
    And I click on <day>
    Then I should see <noOfDays> days of weather
    And I should see <hoursInerval> of report
    And I see <noOfDays> reports for maximum temparatures
    And I see <noOfDays> reports for minimum temparatures
    And I see <noOfDays> reports for dominant wind speed
    And I see <noOfDays> reports for aggregate rainfall
    And I see <noOfDays> reports for dominant condition

    Examples:
      | city      | day       | noOfDays | hoursInerval |
      | Edinburgh | Tuesday   | 5        | 3            |
      | Glasgow   | Wednesday | 5        | 3            |
      | Edinburgh | Thursday  | 5        | 3            |
      | Glasgow   | Friday    | 5        | 3            |
      | Edinburgh | Saturday  | 5        | 3            |