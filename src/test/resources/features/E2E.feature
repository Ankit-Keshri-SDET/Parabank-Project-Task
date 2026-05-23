Feature: Register a new User into the website
  As a new User
  I want to register myself into the bank
  So that I can use all the banking features and maintain my account

  Background:
    Given Given User is on the home page

  @Regression
  Scenario Outline: TC_001_To Verify new user is registered with the bank
    When User clicks on Register link
    And User enters "<first_name>", "<last_name>", "<address>", "<city>", "<state>", "<zipCode>", "<phone>", "<ssn>" in the register form
    And User enters "<user_name>", "<password>", "<confirm_password>" in the form
    And User clicks on Register button
    Then User verifies the greet message on the page
    And User verifies the "<Success_Message>" on the page
    When User clicks on Logout link
    Then User is on the home page

    Examples:
      | first_name | last_name | address     | city     | state     | zipCode | phone     | ssn | user_name            | password    | confirm_password | Success_Message |
      | NEW        | TESTER    | NEW ADDRESS | NEW CITY | NEW STATE | 561781  | 987615541 | 789 | taskbdd123@gmail.com | tasknew@123 | tasknew@123      |                 |

  @Smoke
  Scenario Outline: TC_002_To Verify User is able to login and check his account balance on the dashboard page
    When User enters "<user_name>", "<password>" in the login input field
    And User clicks on Login button
    Then User verifies Dashboard page is displayed
    And User verifies the balance and available amount on the page
    And User verifies total amount on the page
    When User clicks on Logout link
    Then User is on the home page

    Examples:
      | user_name           | password    |
      | taskbdd12@gmail.com | tasknew@123 |


