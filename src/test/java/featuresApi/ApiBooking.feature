Feature:
  Verify API request for get booking

  @Api
  Scenario: To verify Rest service -GET method
    Given User want to execute booking endpoint
    When User submit the GET request with id
    Then User should get 200 status code