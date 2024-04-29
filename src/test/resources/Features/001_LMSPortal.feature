@portal
Feature: Homepage verification
    
    #1
	Scenario: Verify admin is able to land on home page
     Given Admin launch the browser
     When  Admin gives the correct LMS portal URL
     Then  Admin should land on the home page
     
    #2
	Scenario: Verify admin is able to land on home page with invalid URL
     Given Admin launch the browser
     When  Admin gives the invalid LMS portal URL
     Then  Admin should recieve 404 page not found error 
     
    #3
	Scenario: Verify for broken link in login page
     Given Admin launch the browser
     When  Admin gives the correct LMS portal URL
     Then  HTTP response >= 400. Then the link is broken
     
    #4
	Scenario: Verify the text spelling in the page
     Given Admin launch the browser
     When  Admin gives the correct LMS portal URL
     Then  Admin should see correct spellings in all fields
    
    #5
	Scenario: Verify the company logo alignment
     Given Admin launch the browser
     When  Admin gives the correct LMS portal URL
     Then  Admin should see logo on the left  side
    
    #5+
	Scenario: Verify the company logo is present
     Given Admin launch the browser
     When  Admin gives the correct LMS portal URL
     Then  Admin should see logo is present
     
    #6
	Scenario: Verify application name
     Given Admin launch the browser
     When  Admin gives the correct LMS portal URL
     Then  Admin should see  LMS - Learning Management System
    
    #7
	Scenario: Verify company name
     Given Admin launch the browser
     When  Admin gives the correct LMS portal URL
     Then  Admin should see company name below the app name
     
    #8
	Scenario: Validate sign in content
     Given Admin launch the browser
     When  Admin gives the correct LMS portal URL
     Then  Admin should see "Please login to LMS application"
     
    #9
	Scenario: Verify text field is present
     Given Admin launch the browser
     When  Admin gives the correct LMS portal URL
     Then  Admin should see <2> text fields
     
    #10
	Scenario: Verify text on the first text field
     Given Admin launch the browser
     When  Admin gives the correct LMS portal URL
     Then  Admin should see "User" in the first text field
     
    #11
	Scenario: Verify asterik next to user text
     Given Admin launch the browser
     When  Admin gives the correct LMS portal URL
     Then  Admin should see * symbol next to user text
     
    #12
    Scenario: Verify text on the Second text field
     Given Admin launch the browser
     When  Admin gives the correct LMS portal URL
     Then  Admin should see "Password" in the second text field
     
    #13
	Scenario: Admin should see * symbol next to password text
     Given Admin launch the browser
     When  Admin gives the correct LMS portal URL
     Then  Admin should see * symbol next to password text
     
    #14
	Scenario: Verify the alignment of input fields for the login
     Given Admin launch the browser
     When  Admin gives the correct LMS portal URL
     Then  Admin should see input field on the centre of the page
     
    #15
	Scenario: verify Login is present
     Given Admin launch the browser
     When  Admin gives the correct LMS portal URL
     Then  Admin should see Login button
   
   #16
	Scenario: Verify the alignment of the login button
     Given Admin launch the browser
     When  Admin gives the correct LMS portal URL
     Then  Admin should see login button on the centre of the page
     
   #17
	Scenario: Verify input descriptive text in user field
     Given Admin launch the browser
     When  Admin gives the correct LMS portal URL
     Then  Admin should see user in gray color
     
   #18
	Scenario: Verify input descriptive text in password field
     Given Admin launch the browser
     When  Admin gives the correct LMS portal URL
     Then  Admin should see password in gray color
     
     