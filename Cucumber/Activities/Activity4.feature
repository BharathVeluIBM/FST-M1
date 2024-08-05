@activity4
Feature: Data driven test without Example

Scenario: Testing with Data from Scenario
    Given User is Entered into the Login page
    When User enters "admin" and "password"
    Then Read the title of the page and confirmation message
    And browser Close