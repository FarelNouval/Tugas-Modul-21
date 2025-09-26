Feature: Login Functionality
  As a user, I want to login to the website so that I can access secure pages.

  Scenario: Positive Test - Successful login with valid credentials
    Given I am on the login page
    When I enter valid username "tomsmith"
    And I enter valid password "SuperSecretPassword!"
    And I click the login button
    Then I should see success message containing "You logged into a secure area!"

  Scenario: Negative Test - Failed login with invalid credentials
    Given I am on the login page
    When I enter invalid username "wronguser"
    And I enter invalid password "wrongpass"
    And I click the login button
    Then I should see error message containing "Your username is invalid!"

  Scenario: Boundary Test - Login with empty username
    Given I am on the login page
    When I enter empty username
    And I enter valid password "SuperSecretPassword!"
    And I click the login button
    Then I should see error message containing "Your username is invalid!"

  Scenario: Boundary Test - Login with very long username
    Given I am on the login page
    When I enter very long username "a".repeat(100)  # Gherkin mendukung expression sederhana
    And I enter valid password "SuperSecretPassword!"
    And I click the login button
    Then I should see error message or handle long input appropriately  # Sesuaikan berdasarkan situs