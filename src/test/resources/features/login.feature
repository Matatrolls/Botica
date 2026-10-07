Feature: Login
  As a registered platform user
  I want to log in with my credentials
  So that I can access my dashboard and profile

  Background:
    Given the user is on the login page

  Scenario: Successful login with valid credentials
    When the user enters their credentials and clicks the login button
    Then the user should be redirected to their dashboard

  Scenario Outline: Failed login attempts
    When the user enters their email "<email>" and password "<password>"
    Then they should see the error message "<error_message>"

    Examples:
      | email                  | password     |  |
      | invalid_email@test.com | Password123* |  |
      | usuario@ejemplo.com    | WrongPass    |  |
      |                        | Password123* |  |
      | usuario@ejemplo.com    |              |  |