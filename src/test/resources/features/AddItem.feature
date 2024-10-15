@crater @regression @addItem
Feature: Add item
  Asa user I want to add an item to the list of items

@smoke
Scenario: happy path for login
  Given user is logged in successfully
  And user is in item page
  When the user clicks on the Add Item button
  And user fills out follwing Item Name, Item Description, Item price "12.99", selects Unit "grams"
  And user clicks Save item button
  Then the item should be listed in Items tabel



# Below is the an example of manual test case  for teh gherkin example abowe
#  Navigate to the Items page.
#  Click on the Add Item button.
#  Enter the item name.
#  Enter the item description.
#  Enter the item price “12.99.
#  Select the item unit “grams”
#  Click the Save Item button.
#  Verify that the new item is listed in the items table.
