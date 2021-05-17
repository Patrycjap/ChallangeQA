Feature:
  As a user with created account
  I should not be logged to the system with invalid credentials

  @InvalidLogin
  Scenario Outline: Login a user with invalid credentials
    Given the user is on login page
    When she provides the email as <email>
    And she provides the password as <password>
    And she click login
    Then she should not be logged to the application
    Examples:
    | email | password|
    |patrycjapostek@gmail.com | test|
    |patrycjaposte@gmail.com |Testing123|