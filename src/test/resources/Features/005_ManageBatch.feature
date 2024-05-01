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
    #Scenario: Validate pop up for adding batch
    # When Admin clicks + A New Batch button
    # Then A new pop up with Batch details appears
     
     
     
    #11 
    Scenario: Validate data rows
    Then Each row in the data table should have a checkbox
    
    #12
    Scenario: Validate data rows
    Then Each row in the data table should have a edit icon that is enabled
    
    #13
    Scenario: Validate data rows
    Then Each row in the data table should have a delete icon that is enabled
    #14
    Scenario: Validate row level delete icon
    #Given The delete icon on row level in data table is enabled	
    When Admin clicks the delete icon	
    Then Alert appears with yes and No option
    
    #15
    Scenario: Validate accept alert
    # When Admin clicks the delete icon
    When You click yes option
    Then Batch deleted alert pops and batch is no more available in data table
    
    #Scenario: Validate reject alert
    #When you click No option	
    #Then Batch is still listed in data table
    
    #16
    Scenario: Validate the delete icon below the header 
    Given None of the checkboxes in data table are selected		
    Then The delete icon under the Manage Batch header should be disabled
    
    #17
    Scenario: Check for single row delete
    Given One of the checkbox/ row is selected	
    When Click delete icon below Manage Batch header
    Then The respective row in the data table is deleted
    
    #18
    Scenario: Check for multi row delete
    Given Two or more checkboxes/row is selected
    When Click delete icon below Manage Batch header	
    Then The respective row in the data table is deleted
    
    
    
  
  	