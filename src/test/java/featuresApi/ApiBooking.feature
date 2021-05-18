Feature:
  Verify API request for get booking

  @Api1
  Scenario: To verify Rest service -GET method
    Given User want to execute booking endpoint
    When User submit the GET request with id
    Then User should get 200 status code

  @Api2
  Scenario: To verify Rest service -Delete method
#    Given User post the auth link
#    When User submit the Delete request with id
    Then User should get 200 status code for Delete