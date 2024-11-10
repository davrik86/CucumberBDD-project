@addItemDBval
  Feature: Add Item and validate trough DB

    Scenario: happy path for login
      Given user is logged in successfully
      And user is in item page
      When the user clicks on the Add Item button
      And user fills out follwing Item Name, Item Description, Item price "12.99", selects Unit "grams"
      And user clicks Save item button
      Then the item should be listed in Items tabel
      And validate data is in DB