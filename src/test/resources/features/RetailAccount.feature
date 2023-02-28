Feature: Retail Account page

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'milad.milo@gmail.com' and password 'Milad.1234'
    And User click on login button
    Then User should be logged in into Account

  @updateName
  Scenario: Verify User can Update profile information
    When User click on Account option
    And User Update name 'MiLAD' and phone '651111111'
    And User click on Update button
    Then User profile information should be updated

  @updatePassword
  Scenario: Verify User can Update password
    When User click on Account option
    And User enter below information
      | previousPassword | newPassword | confirmPassword |
      | Milad.1234        | Milad.123  | Milad.123      |
    And User click on Change Password button
    Then a message should be displayed 'Password Updated Successfully'

  @addPayment
  Scenario: Verify User can add a payment method
    When User click on Account option
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 4042298247387247 | Milad      |               8 |           2027 |          676 |
    And User click on Add your card button
    Then message should be displayed 'Payment Method added successfully'

  @editPayment
  Scenario: : Verify User can edit Debit or Credit card
    When User click on Account option
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber | nameOnCard | expirationMonth | expirationYear | securityCode |
      | value      | value      | value           | value          | value        |
    And user click on Update Your Card button
    Then a message should be displayed ‘Payment Method updated Successfully’
