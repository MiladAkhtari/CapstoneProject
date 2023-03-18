Feature: Retail Account page

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'milad.milo@gmail.com' and password 'Milad.1234'
    And User click on login button
    Then User should be logged in into Account

  @testCase3
  Scenario: Verify User can Update profile information
    When User click on Account option
    And User Update name 'Emad' and phone '9687950877'
    And User click on Update button
    Then User profile information should be updated

  @testCase4
  Scenario: Verify User can Update password
    When User click on Account option
    And User enter below information
      | previousPassword | newPassword | confirmPassword |
      | Milad.1234        | Milad.123  | Milad.123      |
    And User click on Change Password button
    Then a message should be displayed 'Password Updated Successfully'

  @testCase5
  Scenario: Verify User can add a payment method
    When User click on Account option
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 4042298247387245 | Milad      |               8 |           2027 |          676 |
    And User click on Add your card button
    Then message should be displayed 'Payment Method added successfully'

  @testCase6
  Scenario: : Verify User can edit Debit or Credit card
    When User click on Account option
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 4042298247387288 | emad       |               3 |           2028 |          123 |
    And user click on Update Your Card button
    Then A message should be displayed 'Payment Method updated Successfully'

  @testCase7
  Scenario: Verify User can remove Debit or Credit card
    When User click on Account option
    And User click on remove option of card section
    Then payment details should be removed

  @testCase8
  Scenario: Verify User can add an Address
    When User click on Account option
    And User click on Add address option
    And user fill address form with below information
      | country       | fullName | phoneNumber | streetAddress | apt | city      | state      | zipCode |
      | United States | milad    |  6193134554 | 321 laa       |  10 | san diego | California |   92021 |
    And User click Add Your Address button
    Then a Message should be displayed 'Address Added Successfully'

  @testCase9
  Scenario: Verify User can edit an Address added on account
    When User click on Account option
    And User click on edit address option
    And user fill new address form with below information
      | country       | fullName | phoneNumber | streetAddress  | apt | city      | state      | zipCode |
      | United States | emad     |  6193134533 | 513 la rue way |  11 | san diego | California |   92920 |
    And User click update Your Address button
    Then a message should be displayed. 'Address Updated Successfully'

  @testCase10
  Scenario: Verify User can remove Address from Account
    When User click on Account option
    And User click on remove option of Address section
    Then Address details should be removed
