@crater @regression
Feature: Successfully views and navigate to invoice page

@smoke
  Scenario: Invoces test
    Given user is logged in successfully
    And user is on the Invoces page
    Then The Invoces label should be dispalyed
    And the user clicks on a spesific invoce page
    Then the invoce should be dispalyed on right side

@smoke
Scenario: Add new invoice
  Given user is logged in successfully
  And user is on the Invoces page
  And user lick on the Add New Invoice button.
  When user selects a client from New Customer dropdown, and Item from Item dropdown
  And enter a quantity of "2" , enter price "4.99"
  And clicks on Save Invoce button
  Then verify teh invoce is saved in invoces list
  And total matches to added items and their quantities




#  Navigate to the Invoices page.
#  Click on the Add New Invoice button.
#  Select a client from the New Customer dropdown.
#  Select an Item from the Item dropdowns
#  Enter a quantity of 2
#  Enter a Price 4.99
#  Click the Save Invoice button.
#  Verify the invoice is saved and listed in the invoices list.
#  Verify the invoice total matches the added items and their quantities.
