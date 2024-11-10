@db-test
  Feature: Add new invoice

    Scenario: Add new invoice
      Given user is logged in successfully
      And user is on the Invoces page
      And user lick on the Add New Invoice button.
      When user selects a client from New Customer dropdown, and Item from Item dropdown
      And enter a quantity of "2" , enter price "4.99"
      And clicks on Save Invoce button
      Then verify teh invoce is saved in invoces list
      And total matches to added items and their quantities
      And the invoice should added to the database