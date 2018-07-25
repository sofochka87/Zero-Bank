@negativeScenarios
Feature: Negative Log In

  Scenario: Blank User ID
    Given The user on the home page
    Then Home page should be displayed
    When The user clicks on sing in button
    Then Sign in page should be displayed
    And The user logs in with blank user ID
    Then Error Message should be displayed

  Scenario: Blank Password
    Given The user on the home page
    Then Home page should be displayed
    When The user clicks on sing in button
    Then Sign in page should be displayed
    And The user logs in with blank password
    Then Error Message should be displayed


  Scenario: Invalid user ID
    Given The user on the home page
    Then Home page should be displayed
    When The user clicks on sing in button
    Then Sign in page should be displayed
    And The user logs in with invalid user ID
    Then Error Message should be displayed


  Scenario: Invalid password
    Given The user on the home page
    Then Home page should be displayed
    When The user clicks on sing in button
    Then Sign in page should be displayed
    And The user logs in with invalid password
    Then Error Message should be displayed


  Scenario: Wrong credentials
    Given The user on the home page
    Then Home page should be displayed
    When The user clicks on sing in button
    Then Sign in page should be displayed
    And The user logs in with wrong credentials
    Then Error Message should be displayed
 
