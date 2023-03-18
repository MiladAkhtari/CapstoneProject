Feature: Retail SignIn feature

  Background: 
    Given User is on retail website
    When User click on Sign in option

  @testCase
  Scenario: Verify user can sign in into Retail Application
    And User enter email 'milo12@gmail.com' and password 'Milo.1234'
    And User click on login button
    Then User should be logged in into Account

  @testCase2
  Scenario: Verify user can create an account into Retail Website
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name | email | password  | confirmPassword |
      | name | email | Milad.123 | Milad.123       |
    And User click on signUp button
    Then User should be logged into Account page
