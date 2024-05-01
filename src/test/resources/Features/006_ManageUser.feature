Feature: Add New User

  Background: Admin is on dashboard page after Login and clicks User on the navigation bar

  #popwindow
  Scenario: Validate User Details Popup window
    Given Admin is on Manage User Page
    When Admin clicks  A New User button
    Then Admin should see pop up open for user details with First Name,Middle name,Last Name,Location,phone,email,linkedin url..etc"

  #input fileds
  Scenario: Validate input fields and text boxes in user details form
    When Admin clicks  A New User button
    Then "Admin should see text boxes for the fields First Name, Middle name, Last Name, Location,phone, email, linkedin url, Undergraduate, postgraduate,time zone ,user comments"

  #Dropdown
  Scenario: Validate drop downs in new user form
    When Admin clicks  A New User button
    Then "Admin should see drop downs for the fields User Role,Role status, visa status on user details pop up"

  #mandatory fields with valid data
  Scenario: Check if user is created when only mandatory fields are entered with valid data
    When Admin enters mandatory fields in the form and clicks on submit button
    Then Admin gets message User added Successfully

  Scenario: Check if user is created when only optional fields are entered with valid data
    When Admin skips to add value in mandatory field
    Then Admin should see error message below the test field and the field will be highlighed in red color

  #optional fields with invalid Data
  Scenario: Check if user is created when only optional fields are entered with invalid data is entered in all the fields
    When Admin enters invalid data in all of the  fields in the form and clicks on submit button
    Then Admin gets error message and user is not created

  #Empty form
  Scenario: Empty form submission
    When Admin clicks on submit button without entering data
    Then user won't be created and Admin gets error message

  #Cancel/close
  Scenario: Validate Cancel/Close(X) icon on User Details form
    When Admin clicks Cancel/Close(X) Icon on User Details form
    Then User Details popup window should be closed without saving

  #Cancel
  Scenario: Validate Cancel button on User Details form
    When Admin clicks Cancel button
    Then Admin can see the User details popup disappears without adding any user

  #Addind Details
  Scenario: Check if the user details are added in data table
    When Fill in all the fields with valid values and click submit
    Then The newly added user should be present in the data table in Manage User page
