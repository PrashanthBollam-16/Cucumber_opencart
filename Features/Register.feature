Feature: User Account Registeration

  Scenario: Sucessfull user Registration
    Given user is on the registration page
    When user gives all the required details like
      | firstName | John       |
      | lastName  | Kenedy     |
      | telephone | 9866705275 |
      | password  | test@123   |
      | cnfpassword  | test@123 |
    And user selects the privacy chechbox
    And user selects the continue button
    Then user should be successfully registred
