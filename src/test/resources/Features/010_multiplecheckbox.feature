@Multiple
Feature: Multiple Delete Program
 
 
#Background: Admin gives the correct LMS portal URL
Background: Admin successfully logged in to LMS Portal
		Given Admin is on dashboard page after Login
#		When  Admin clicks "Program" on the navigation bar
 Scenario:  Validate Common Delete button enabled after clicking on any checkbox
  Given Admin is in the manage program page after clicking Program on the navigation bar
  When Admin clicks any checkbox in the data table
  Then Admin should see common delete option enabled under header Manage Program
  
  #
  #Scenario: Validate multiple program deletion by selecting Single checkbox
  #Given Admin clicks delete button after selecting the check box in the data table to reach on confirm deletion alert
  #When Admin clicks <YES> button on the alert
  #Then  Admin should land on Manage Program page and can see the selected program is deleted from the data table
#
  #Scenario: Validate multiple program deletion by selecting Single checkbox
  #Given Admin clicks delete button box and Confirm Deletion alert
  #When Admin clicks <NO> button on the alert
  #Then   Admin should land on Manage Program page and can see the selected program is not deleted from the data table
  #
  #Scenario: Validate multiple program deletion by selecting multiple check boxes
  #Given Admin clicks delete button under header after selecting multiple checkboxes and Confirm Deletion alert
  #When Admin clicks <YES> button 
  #Then Admin should land on Manage Program page and can see the selected programs are deleted from the data table
  #
   #Scenario: Validate multiple program deletion by selecting multiple check boxes
  #Given Admin clicks delete button under header after selecting multiple checkboxes and Confirm Deletion alert
  #When  clicks <No> button on  alert
  #Then Admin should land on Manage Program page and can see the selected programs are not deleted from the data table
  