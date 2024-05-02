Feature: Pagination

	Background: Admin is on the Manage Program Page after logged in
    Given Admin is logged in 
    When Admin clicks on "Program" on the Navigation Bar
    Then Admin should be on Manage Program Page in program module



  @tag1
  Scenario: Verify Next page link
    Given Admin is on Manage Program page in program module
    When Admin clicks Next page link on the program table 
    Then Admin should see the Pagination has Next active link

  @tag2
  Scenario: Verify Last page link
    Given Admin is on Manage Program page in program module
    When Admin clicks Last page link
    Then Admin should see the last page record on the table with Next page link are disabled

    Scenario: Verify Previous page link
    Given Admin is on last page of Program table
    When Admin clicks Previous page link
    Then Admin should see the previous page record on the table with pagination has previous page link

    Scenario: Verify First page link
   Given Admin is on last page of Program table
    When Admin clicks First page link
    Then Admin should see the previous page record on the table with pagination has previous page link
  
    Scenario: Verify First page link
    Given Admin is on Previous Program page 
    When Admin clicks First page link
    Then Admin should see the very first page record on the table with Previous page link are disabled