
Feature: ISMads Application test
  I want to use this template for my feature file

  @tag1
  Scenario: Validate the application login successfully
    Given User opens Chrome browser
    When User enter username and password and login
    Then user clicks on Login button
    Then validate user login successfully 
    Then close the browser
   
  Scenario: Validate the application in login successfully
    Given User opens Chrome browser
    When User enter invalid username and password and login
    Then user clicks on Login button
    Then validate user not able to logged 
    Then close the browser
 
