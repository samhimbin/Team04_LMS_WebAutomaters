@dash
Feature: Dashboard Page

  Background: Admin gives the correct LMS portal URL
	Given Admin is in Home Page
    When Admin enter valid credentials and clicks login button
  
  #1
  Scenario: Verify after login  admin lands on manage program as dashboard page
    Then Admin should see manage program as header 	
  #2
  Scenario: Verify the response time
    Then Maximum navigation time in milliseconds, defaults to 30 seconds
  #3
  Scenario: Verify broken link
    Then HTTP response >= 400. Then the link is broken
  #4
  Scenario: Verify LMS title
    Then Admin should see LMS-Learning management system  as title
  #5
  Scenario: Verify  LMS title alignment
    Then LMS title should be on the top left corner of page
  #6
  Scenario: Validate navigation bar text
    Then Admin should see correct spelling in navigation bar text
  #7
  Scenario: Validate LMS title has correct spelling ang space
    Then Admin should see correct spelling and space in LMS title
  #8
  Scenario: Validate alignment for navigation bar
    Then Admin should see the navigation bar text on the top right side
  #9
  Scenario: Validate navigation bar order  1st Program
    Then Admin should see program in the 1st place
  #10
  Scenario: Validate navigation bar order  2nd Batch
    Then Admin should see batch in the 2nd place
  #11
  Scenario: Validate navigation bar order 3rd User
    Then Admin should see user in the  3rd place
  #12
  Scenario: Validate navigation bar order 4th Logout
    Then Admin should see logout in the 4th place
  
   
