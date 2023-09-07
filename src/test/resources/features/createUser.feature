Feature: Create User functionality

  Background: Log in as an admin
    Given I am on the login page
    When I enter the valid credential
    And click the login button
    Then I should be directed to the dashboard page

  Scenario Outline: Create a user
    Given I am on the create user page
    When I select user role <userRole>
    And I enter employee name
    And I select status <userStatus>
    And I enter username
    And I enter password <password>
    And I enter confirm password <password>
    And click the save button
    Then I should be directed to the admin page
    When I enter the username
    And I click the search button
    Then I should find the same user
    Examples:
      | userRole | userStatus | password |
      | "Admin"  | "Enabled"  | "12345abc"  |
      | "ESS"  | "Disabled"  | "12345abc"  |