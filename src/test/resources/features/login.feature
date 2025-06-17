Feature:  Login As Alumni on Pokari

  As an alumni user of Pokari
  i want to log in into my account on Pokari System

  @positive
  Scenario: Alumni successfully logs in with UGM Google account
  When user clicks on the "Profile" menu
  And user clicks the "Login with Google" button
  And user enters their UGM email and password on the Google Sign-In page
  Then system authenticates and redirects the user to the Register page

  @positive @negative
  Scenario Outline: Alumni completes registration with graduation year "<graduateYear>"
    Given user is on the Register page
    When user selects "Alumni" as the role
    Then user click on "Next" Button
    And system displays alumni data containing name and student ID
    And user enters the graduation year as "<graduateYear>"
    And user clicks the "Submit" button
    Then system <expectedOutcome>

    Examples:
      | graduateYear | expectedOutcome|
      | 2022         | "shows a validation error and does not proceed to the Profile page" |
      | 2026         | "shows a validation error and does not proceed to the Profile page"|
      | 2025         | "saves the alumni data and redirects to the Profile page" |

  @negative
  Scenario: Alumni failed to log in with non-UGM Google account
  When user clicks on the "Profile" menu
  And user clicks the "Login with Google" button
  And user enters their non-UGM email and password on the Google Sign-In page
  Then system authenticates the login attempt and shows an error message: “Only UGM Google are allowed to login”