Feature: User Registration
  As a new user
  I want to register an account
  So that I can access the application

  Scenario: Successful user registration with valid data
    Given the user is on the registration page
    When the user enters valid registration data
    And the user submits the registration form
    Then the user should see a successful registration message
