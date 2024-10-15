@crater @regression

Feature: View Expenses
@expenses
  Scenario: Validating Expxpenses, Home/ Expenses labels are dispalyed
    Given user is logged in successfully
    And User is on Expenses page
    Then User should view Expenses Label , and "Home/Expenses" label are displayed on the page
    And  URL should end with "expenses"

@newExpenses
  Scenario: New Expenses
    Given user is logged in successfully
    And User is on Expenses page
    And User clicks on Add Expenses button
    When Useer selectes category from the dropdown as "primetech" and customer "Garfield"
    And enters the expense amount as “59900”, and payment mode "Cash"
    And User enters a note "This is a Test Note" and clicks the Save button.
    Then User should verify that the expence is added



#  Navigate to the Expenses page.
#  Click on the Add Expense button.
#  Select an expense category from the dropdown as “primetech”.
#  Enter the expense amount as “599”.
#  Select customer as “Ben”
#  Select Payment Mode as “Cash”
#  Select the expense date.
#  Click the Save button.
#  Enter a Note as “This is a Test Note”
#  Verify the expense is added and listed in the expenses list.
