Feature: Login Data Driven With Excel

  Scenario Outline: Succesfull login with Data Driven Excel
    Given the user navigates to the Login page
    Then user should be redirected to my account page by passing email and password with excel row "<row_index>"

    Examples:
      | row_index |
      | 1         |
      | 2         |
      | 3         |
      | 4         |
      |5          |