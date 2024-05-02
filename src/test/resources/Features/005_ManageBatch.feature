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
    
    #11
    #Scenario: Check if the fields exist in pop
     #Given Admin clicks + A New Batch button
     #When A new pop up with Batch details appears
     #Then The pop up should include Name,Numberofclasses,Description,ProgramName,staus,Numberofclasses
     
     ####12
    Scenario: Validate data rows
    Then Each row in the data table should have a checkboxBatch
      ###13
    Scenario: Validate data rows
    Then Each row in the data table should have a edit icon that is enabledBatch
    
     ###14
    Scenario: Validate data rows
    Then Each row in the data table should have a delete icon that is enabledBatch
    
     ##15
     #Scenario: Validate row level delete icon
    #Given The delete icon on row level in data table is enabled	
    #When Admin clicks the delete icon	
    #Then Alert appears with yes and No option
    
    ###16
    #Scenario: Validate accept alert
    # When Admin clicks the delete icon
    #When You click yes option
    #Then Batch deleted alert pops and batch is no more available in data table
    
    ###17
    #Scenario: Validate reject alert
    #When you click No option	
    #Then Batch is still listed in data table
    
    ##18
    Scenario: Validate the delete icon below the header 
    Given None of the checkboxes in data table are selected		
    Then The delete icon under the Manage Batch header should be disabled
     
  
  	