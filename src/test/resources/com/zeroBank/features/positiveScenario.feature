Feature: PositiveScenario 

@PositiveScenario
Scenario: Positive log in
Given The user on the home page
Then Home page should be displayed
When The user clicks on sing in button
Then Sign in page should be displayed
Then The user logs in with valid credentials
And Account activity page should be displayed
Then The user log out 


