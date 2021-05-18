Feature:
  As a user with created account
  I want to be able to login to the system with valid credentials

  @ValidLogin
  Scenario: Login a user with valid credentials
    Given the user is on login page
    When she provides the email as patrycjapostek@gmail.com
    And she provides the password as Testing123
    And she click login
    Then she should see domain menu

#  @RecoveryPassword
#  Scenario: After recovery a password user should be redirected to the login page
#    Given the user is on login page
#    When she click forgot password link
#    And  she provides the recovery email as patrycjapostek@gmail.com
#    And she click send button
#    Then she should be redirect to login page