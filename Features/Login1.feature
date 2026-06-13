Feature: Login with valid credentials

  # Scenario: Successful Login with valid credentials
  # Given the user navigates to the Login page
  # When the user enters email as "praveenabollam@gmail.com" and password as "test@123"
  # And the user clicks on the login button
  # Then user should be redirected to my account page
  
  Scenario Outline: Successful Login with Data driven
    Given the user navigates to the Login page
    When the user enters email as "<email>" and password as "<password>"
    And the user clicks on the login button
    Then user should be redirected to my account page

    Examples:
      | email                     | password |
      | praveenabollam@gmail.com  | test@123 |
      | vasanth23@gmail.com       | test@123 |
