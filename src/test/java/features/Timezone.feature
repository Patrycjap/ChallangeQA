Feature:
  As a logged user to the system
  I should be able to change timezone for current session

  @Timezone
  Scenario: Set Minsk timezone for current session
    Given the user is on login page
    And she provides the email as patrycjapostek@gmail.com
    And she provides the password as Testing123
    And she click login
    When she click timezone configuration from user menu
    And she select timezone
    And she check apply only for current session
    And she save timezone settings
    Then she should see changed timezone in user menu as Minsk
    And she click logout
    And she provides the email as patrycjapostek@gmail.com
    And she provides the password as Testing123
    And she click login
    Then she should see changed timezone in user menu as Madrid
