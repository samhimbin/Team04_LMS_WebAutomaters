Feature: Logout function

  Background: Verify admin is able to land on home page with invalid URL

  Scenario: Verify Logout button function
    Given Admin is in dashboard page
    When Admin click Logout button on navigation bar
    Then Admin should land on login in page