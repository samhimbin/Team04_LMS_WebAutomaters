@user
Feature: User page validation1

 	Background: Logged on the LMS portal
  		Given Admin is on dashboard page after Login to test User Module
  		When Admin clicks User from navigation bar
	  	
	Scenario: Validate landing in Program page
	  	Then Admin should see the "Manage User" in the URL
	  
	Scenario: Validate the heading
			Then Admin should see a heading with text "Manage user" on the user page
			
	Scenario Outline: Validate the text and pagination icon below the data table
			Then Admin should see the text as "Showing <X> to <Y> of <Z> <Entries>" along with Pagination icon below the table.
		
	Examples:
	| X    | Y    | Z    | Entries |
	| 1    | 5    | 49   | users   | 
		
	Scenario: Validate data table headers in the User Page
			Then Admin Should see the data table with column names Id, Name, location, Phone Number, Edit/Delete
				
	Scenario: Validating the default state of Delete button
			Then Admin should see a Delete button on the top left hand side as Disabled in User Page
				
#	Scenario: Validate "+ A New user" button in User Page
#			Then Admin should be able to see the "+ Add New User" button above the data table
#			  
#	Scenario: Validate "+ Assign staff"  button in User page
#			Then Admin should be able to see the "+ Assign staff" button above the data table
#				
#	Scenario: Validate "+ Assign Student"  button in User page
#			Then Admin should be able to see the "+ Assign Student" button above the data table
				
	Scenario: Validate search box in User page
			Then Admin should be able to see the search text box above the data table
				
	Scenario: Validate number of data rows in the data table
			Then Admin should see two  records displayed on the data table
				
	Scenario: Verify Check box on the data table
			Then Each row in the user data table should have a checkbox
				
	Scenario: Verify edit icon on the data table
			Then Each row in the user data table should have a edit icon that is enabled
				
	Scenario: Verify  delete icon on the data table
			Then Each row in the user data table should have a delete icon that is enabled
		
	Scenario Outline: search user by name
	    When Admin enters "<User Name>" into search box.
		 	Then Admin should see user displayed with the entered name
		 	
	Examples:
    | User Name |
    | Sam       |
	  
	Scenario Outline: Validating the Search with unrelated keyword
	    When Admin enters the "<keywords>" not present in the data table on the Search box 
	  	Then Admin should see zero entries on the data table
	  	
	Examples:
  |keywords |
  |gibberish|
	  
  Scenario: Validate Assign Student Popup window
   		When Admin clicks "Assign Student" button
		  Then Admin should see a pop up open for assign student details with empty form along with Save and Cancel button and close (X) icon on the top right corner of the window
		  
	Scenario: Validate input fields and their text boxes in Assign Student form 
	 		Then Admin should see User Role as R03,and other fields Student Email id,Program Name,Batch Name and Status with respective input boxes.
	
	Scenario: Validate Dropdown in Assign Student Form
	 		Then Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name
		
	Scenario: Validate radio button in Assign Student Form
	 		Then Admin should see two radio button for Status
	 		
	Scenario: Empty Form Submission
			When Admin clicks "Save" button with entering any data
			Then Admin gets a Error message alert
			
			
	Scenario:	Validate the Assign Student form page without giving Student Email id
			When Admin clicks "Assign Student" button
			When Admin clicks "Save" button without entering Student Email id
			Then Admin gets a Error message alert as "Student Email id is required"
			
	Scenario: Validate the Assign Student form page without selecting Program
			When Admin clicks "Assign Student" button
			When Admin clicks "Save" button without selecting program
			Then Admin gets a Error message alert as "Program is required"
			
	Scenario: Validate the Assign Student form page without selecting batch
		 	When Admin clicks "Assign Student" button
			When Admin clicks "Save" button without selecting batch
			Then Admin gets a Error message alert as "Batch is required"
			
	Scenario: Validate the Assign Student form page without giving Status
			When Admin clicks "Assign Student" button
			When Admin clicks "Save" button without giving status
			Then Admin gets a Error message alert as "Status is required"
			
	Scenario: Validate Cancel/Close(X) icon on Assign Student form
			When Admin clicks "Assign Student" button
			When Admin clicks Cancel/Close(X) Icon on Assign Student form
			Then Assign Student popup window should be closed without saving
			
	Scenario: Validate Save button on Assign Student form
			When Admin all the required fields with valid values and click Save button
			Then Admin gets a message "Successfully Student Assigned" alert 
			
	Scenario: Validate Cancel button on Assign Student form
			When Admin clicks "Assign Student" button
			When Admin clicks <Cancel>button 
			Then Admin can see the Assign Student popup disappears without assigning 
		
	Scenario: Validate Assign Staff Popup window
			When Admin clicks "Assign Staff" button
			Then Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close (X) icon on the top right corner of the window
	
	Scenario: Validate input fields and their text boxes in Assign Staff form 
			Then Admin should see User Role as R02,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes.
	
	Scenario: Validate Dropdown in Assign Staff Form
			Then Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name
	
	Scenario: Validate radio button in Assign Staff Form
			Then Admin should see two radio button for Status
	
	Scenario: Empty Form Submission
			When Admin clicks "Save" button with entering any data
			Then Admin gets a Error message alert 
	
	Scenario: Validate the Assign Staff form page without giving Student Email id
			When Admin clicks "Assign Staff" button
			When Admin clicks "Save" button without entering Student Email id
			Then 	Admin gets a Error message alert as "Student Email id is required"
		
	Scenario: Validate the Assign Staff form page without giving Skill
			When Admin clicks "Assign Staff" button
			When Admin clicks "Save" button without entering Skill
			Then Admin gets a Error message alert as "Skill is required"
	
	Scenario: Validate the Assign Staff form page without selecting Program
			When Admin clicks "Assign Staff" button
			When Admin clicks "Save" button without selecting program
			Then Admin gets a Error message alert as "Program is required"
			
	Scenario: Validate the Assign Staff form page without selecting batch
			When Admin clicks "Assign Staff" button
			When Admin clicks "Save" button without selecting batch
			Then Admin gets a Error message alert as "Batch is required"
			
	Scenario: Validate the Assign Staff form page without giving Status
			When Admin clicks "Assign Staff" button
			When Admin clicks "Save" button without giving status
			Then Admin gets a Error message alert as "Status is required"
	
	Scenario: Validate Cancel/Close(X) icon on Assign Staff form
			When Admin clicks "Assign Staff" button
			When Admin clicks Cancel/Close(X) Icon on Assign Staff  form
			Then Assign Staff popup window should be closed without saving
	
	
	Scenario: Validate Save button on Assign Staff form
			When Enter all the required fields with valid values and click Save button
			Then Admin gets a message "Successfully Staff Assigned" alert 
	
	
	Scenario: Validate Cancel button on Assign Staff form
			When Admin clicks "Assign Staff" button
			When Admin clicks <Cancel>button 
			Then Admin can see the Assign Staff popup disappears without assigning 
	
	
	
	
	
	
		
	
		
	
		
	

		
	
	
	 	
	 
 
		
	
		



  