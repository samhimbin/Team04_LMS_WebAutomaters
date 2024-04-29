@batch
Feature: Batch Page Validation
    
 	Background: Logged on the LMS portal
        Given Admin is on the dashboard page after Login
        When Admin clicks Batch from navigation bar
    
    #1    
    Scenario: Validate landing in Batch page
  	 Then Admin should see the Manage Batch in the URL
  	#2
  	Scenario: Validate header in the Batch Page
     Then Admin should see the "Manage Batch" in the header
  	#3
  	Scenario: Validate pagination in the Batch Page
  	 Then Admin should see the pagination controls under the data table
   	#4
  	Scenario: Validate data table headers in the Batch Page
  	 Then Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete
    #5
    Scenario: Validate Delete button in Batch Page
     Then Admin should be able to see the Delete icon button that is disabled
    #6
    Scenario: Validate + A New batch in Batch Page
     Then Admin should be able to see the + A New batch button
    #7
    Scenario: Validate data rows
     Then Each row in the data table should have a checkbox
    #8
    Scenario: Validate data rows
     Then Each row in the data table should have a edit icon that is enabled
    #9    
    Scenario: Validate data rows
     Then Each row in the data table should have a delete icon that is enabled
    #10
    Scenario: Validate pop up for adding batch
     When Admin clicks + A New Batch button
     Then A new pop up with Batch details appears
  
  	