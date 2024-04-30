@program
Feature: Program Validation
	Background: Admin successfully logged in to LMS Portal
		Given Admin is on dashboard page after Login
		When  Admin clicks "Program" on the navigation bar
		
	#@LandingPage
	Scenario: Validate landing in Program page
	 Then Admin should see URL with "Manage Program"

	#@Heading
	Scenario: Validate the heading
	 Then Admin should see a heading with text "Manage Program" on the page

	#@Pagination
	Scenario: Validate the text and pagination icon below the data table
	 Then Admin should see the text as Showing x to y of z entries along with Pagination icon below the table
	
	#@footer
	Scenario: Validate the footer
	 Then Admin should see the footer as In total there are z programs

	#@DeleteButton
	Scenario: Validating the default state of Delete button
	 Then Admin should see a Delete button on the top left hand side as Disabled

	#@SearchBar
	Scenario: Verify Search bar on the Program page
	 Then Admin should see Search bar with text as "Search..."
	 
	