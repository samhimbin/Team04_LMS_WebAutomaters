Feature: Sorting (Data Ordering) Validation
Background: Ascending order

  Scenario: Validates Sorting (data ordering) on the Program Data table
      Given Admin is on Manage Program Page after clicking Program on the navigation bar
      And the data is in ascending order on the table based on Program Name column
      And the data is in ascending order on the table based on Program Description column
      And the data is in ascending order on the table based on Program Status column

    When Admin clicks the sort icon of program name column
      And Admin clicks the sort icon of program description column
      And Admin clicks the sort icon of program status column

    Then The data get sorted on the table based on the program name column values in ascending order
      And The data get sorted on the table based on the program name column values in descending order
      And The data get sorted on the table based on the program description column values in ascending order
      And The data get sorted on the table based on the program description column values in descending order
      And The data get sorted on the table based on the program status column values in ascending order
      And The data get sorted on the table based on the program status column values in descending order
