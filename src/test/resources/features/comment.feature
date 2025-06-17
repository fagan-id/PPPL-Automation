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
      | "Bagaimana proses seleksinya?"         | "displays the new comment in the comment section on the right side of the post" |
      | "Terima kasih banyak atas informasi lowongan kerja yang telah dibagikan. Saya sangat menghargai inisiatif alumni dalam membagikan kesempatan ini kepada sesama alumni dan mahasiswa. Saya ingin bertanya lebih lanjut mengenai posisi yang ditawarkan. Apakah posisi ini terbuka untuk fresh graduate atau lebih ditujukan bagi kandidat yang sudah memiliki pengalaman kerja sebelumnya? Selain itu, saya juga ingin mengetahui apakah proses seleksi akan dilakukan secara daring atau luring, serta kira-kira berapa lama waktu yang dibutuhkan untuk mendapatkan kabar lebih lanjut setelah mengirimkan lamaran. Bila memungkinkan, saya juga ingin meminta informasi lebih rinci mengenai deskripsi pekerjaan harian dan struktur tim kerja di perusahaan ini. Sebagai alumni yang baru lulus, saya ingin mempersiapkan diri dengan sebaik mungkin. Mohon bantuannya, dan sekali lagi saya sangat mengapresiasi postingan ini. Semoga informasi ini bermanfaat juga bagi alumni lainnya. Terima kasih dan sukses selalu untuk semuanya!"| "displays an error message saying 'Maximum 1000 character allowed'"|

  @positive
  Scenario: Alumni views the list of posts they have commented on
    Given The user has previously commented on one or more job vacancy posts
    When The user clicks on the "Posts" menu
    And The user clicks the "My Commented Posts" button
    Then The user is redirected to a list of job vacancy posts they have commented on




