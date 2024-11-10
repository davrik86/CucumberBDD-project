@api
  Feature: Get list of API

    Scenario: Get List of invoces
      Given I'm logged in Successfully
      When I perform GET operation for "api/v1/invoices" endpoint
      Then I should get 200 status code
      And I should get list of invoces
