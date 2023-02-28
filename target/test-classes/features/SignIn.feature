Feature: Retail SignIn feature

  Background: 
    Given User is on retail website
    When User click on Sign in option

  @smokeTest @signIn
  Scenario: Verify user can sign in into Retail Application
    And User enter email 'phantom.test@gmail.com' and password 'Tek@12345'
    And User click on login button
    Then User should be logged in into Account

  @dryRun @signUp @smokeTest
  Scenario: Verify user can create an account into Retail Website
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name  | email            | password  | confirmPassword |
      | MILAD | miloAkh@gmail.com | Milad.123 | Milad.123       |
    And User click on signUp button
    Then User should be logged into Account page
