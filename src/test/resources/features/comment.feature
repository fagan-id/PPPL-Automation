Feature:  Commenting on Job Vacancy Post by Alumni

  As an alumni user of Pokari
  I want to register and post a comment on a job vacancy post shared by alumni
  So that I can ask questions or share feedback about the job opportunity

  Background:
    Given user is on the Pokari page

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

  @positive
  Scenario: Alumni views the details of a post
      Given user is on the Profile page and logged in as an alumni
      When user clicks on the "Posts" menu
      And The user clicks on one of the posts
      Then The user is redirected to the details page of that post

  @positive @negative
  Scenario Outline: Alumni commenting on a job vacancy post with input "<comment>"
    Given The user is on the job vacancy post detail page
    When The user clicks on the comment input field
    And The user types a <comment> into the input field
    And The user clicks the "Send" button
    Then The system <expectedOutcome>

    Examples:
      | comment       | expectedOutcome|
      | "Hai"         | "displays the new comment in the comment section on the right side of the post" |
      | "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Na"         | "displays an error message saying "Maximum 1000 character allowed. You’ve typed (number of character that user typed)"|

  @positive
  Scenario: Alumni views the list of posts they have commented on
    Given The user has previously commented on one or more job vacancy posts
    When The user clicks on the "Posts" menu
    And The user clicks the "My Commented Posts" button
    Then The user is redirected to a list of job vacancy posts they have commented on



    #  @positive
#  Scenario: Alumni commenting on a job vacancy post
#    Given The user is on the job vacancy post detail page
#    When The user clicks on the comment input field
#    And The user types a comment into the input field
#    And The user clicks the "Send" button
#    Then The system displays the new comment in the comment section on the right side of the post
#
#   @negative
#   Scenario: Alumni is  commenting with text exceeding 1000 characters
#     Given The user is on the job vacancy post detail page
#     When The user clicks on the comment input field
#     And The user types a comment longer than 1000 characters
#     Then The system displays an error message saying "Maximum 1000 character allowed. You’ve typed (number of character that user typed)"
#     And The "Send" button becomes disabled



