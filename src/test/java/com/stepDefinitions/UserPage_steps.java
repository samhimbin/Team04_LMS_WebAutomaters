package com.stepDefinitions;

import com.Utilities.BaseClass;
import com.driverFactory.DriverClass;
import com.Utilities.LoggerLoad;
import com.pageObjects.ProgramPageObject;
import com.pageObjects.UserPageObject;
import com.driverFactory.DriverClass;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.TimeoutException;

public class UserPage_steps extends BaseClass 
{
	@Given("Admin is on dashboard page after Login to test User Module")
	public void admin_is_on_dashboard_page_after_login_to_test_user_module() 
	{
		userpage = new UserPageObject(DriverClass.getDriver());
		String dashboardTitle = DriverClass.getDriver().getTitle();
		LoggerLoad.info("dashboardTitle=" + dashboardTitle);
		Assert.assertEquals("LMS", dashboardTitle);
	}

	@When("Admin clicks User from navigation bar")
	public void admin_clicks_user_from_navigation_bar() 
	{
	    userpage.clickUserButton();
		LoggerLoad.info("Admin clicked on User from navigation bar");
	}
	
	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String expectedStr) 
	{
		try
		{
			String currentUrl = DriverClass.getDriver().getCurrentUrl();
			if (currentUrl.contains(expectedStr)) 
			{
	            LoggerLoad.info("URL validation passed. Expected string '" + expectedStr + "' found.");
			} 
			else 
			
			{ 
			    LoggerLoad.info("URL validation failed. Expected string '" + expectedStr + "' not found.");
		        throw new AssertionError("URL validation failed. Expected string '" + expectedStr + "' not found.");
			}
		}
		catch (AssertionError e) 
		{
	        // Log the error message
	        System.err.println("Assertion Error: " + e.getMessage());
	        // You can choose to take additional actions here if needed
	    }
	}
	
	@Then("Admin should see a heading with text {string} on the user page")
    public void admin_should_see_a_heading_with_text_on_the_user_page(String chkheaderString) 
	{
        assertTrue("Heading with text '" + chkheaderString + "' is not displayed on the page",
        userpage.getHeaderString().isDisplayed());
        LoggerLoad.info("Heading '" + chkheaderString + "' is displayed on the page.");
    }
	
	@Then("Admin should see the text as {string} along with Pagination icon below the table.")
    public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String chkPaginationString) 
	{
        LoggerLoad.info("String to be checked '" + chkPaginationString + "'");
        List<WebElement> paginationString = userpage.getPaginationString();
        assertTrue("Pagination with text '" + chkPaginationString + "' is not displayed on the page",
                paginationString.size() > 0);
        LoggerLoad.info("Text '" + chkPaginationString + "' is displayed on the page.");

        // Verify the presence of pagination icons below the table
        assertTrue("Pagination next icon not found below the table", userpage.isPaginationNextIconDisplayed());
        assertTrue("Pagination last icon not found below the table", userpage.isPaginationLastIconDisplayed());
        assertTrue("Pagination first icon not found below the table", userpage.isPaginationFirstIconDisplayed());
        assertTrue("Pagination previous icon not found below the table", userpage.isPaginationPrevIconDisplayed());
        LoggerLoad.info("Pagination String '" + chkPaginationString + "' along with pagination icons is displayed on the page.");
    }

	@Then("Admin Should see the data table with column names Id, Name, location, Phone Number, Edit\\/Delete")
	public void admin_should_see_the_data_table_with_column_names_id_name_location_phone_number_edit_delete() 
	{
        WebElement userDataTable = userpage.getUserDataTable();

        List<WebElement> headers = userpage.getTableHeaders();

        String[] expectedColumnNames = {"Id", "Name", "Location", "Phone Number", "Edit / Delete"};

        for (String expectedColumnName : expectedColumnNames) 
        {
            boolean columnFound = false;
            for (WebElement header : headers) 
            {
                if (header.getText().equalsIgnoreCase(expectedColumnName))
                {
                    columnFound = true;
                    break;
                }
            }
            assertTrue("Column '" + expectedColumnName + "' not found in the table", columnFound);
            LoggerLoad.info("Column '" + expectedColumnName + "' found: " + columnFound);

        }
        LoggerLoad.info("Admin verified the presence of all expected columns in the data table.");

    }
	
	@Then("Admin should see a Delete button on the top left hand side as Disabled in User Page")
    public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled_in_user_page() 
	{
        WebElement deleteButton = userpage.getDeleteButton();

        assertTrue("Delete button is not displayed or is not disabled", deleteButton.isDisplayed() && !deleteButton.isEnabled());
    }
	
	/*@Then("Admin should be able to see the {string} button above the data table")
    public void admin_should_be_able_to_see_the_button_above_the_data_table(String buttonName) 
	{
        WebElement button = null;

        switch (buttonName) {
            case "+ Add New User":
                button = userpage.getAddNewUserButton();
                break;

            case "+ Assign Student":
                button = userpage.getAssignStudentButton();
                break;

            case "+ Assign Staff":
                button = userpage.getAssignStaffButton();
                break;

            default:
                throw new IllegalArgumentException("Invalid button name: " + buttonName);
        }

        assertTrue("Button '" + buttonName + "' is not displayed", button.isDisplayed());
    }*/
	
	 @Then("Admin should be able to see the search text box above the data table")
	    public void admin_should_be_able_to_see_the_search_text_box_above_the_data_table() 
	 	{
	        WebElement dataTable = userpage.getDataTable(); 
	        // Locate the search text box using relative locators
	        WebElement searchTextbox = userpage.getSearchIcon();
	        System.out.println("Checking the search text box");

	        // Verify that the search text box is present
	        assertTrue("Search text box is not displayed above the data table", searchTextbox.isDisplayed());
	    }
	 
	 @Then("Admin should see two  records displayed on the data table")
	 public void admin_should_see_two_records_displayed_on_the_data_table()
	 {
	        int actualRowCount = userpage.getDataTableRowCount();
	        int expectedRowCount = 2;
	        assertEquals("Number of records displayed validation failed. Expected number of records is " + expectedRowCount + ".", expectedRowCount, actualRowCount);
	    }
	 
	 @Then("Each row in the user data table should have a checkbox")
	    public void each_row_in_the_user_data_table_should_have_a_checkbox() 
	 	{
	        assertTrue("No checkbox found in the data table rows.", userpage.areCheckboxesPresentInAllRows());
	    }
	 
	 @Then("Each row in the user data table should have a edit icon that is enabled")
	 public void each_row_in_the_user_data_table_should_have_a_edit_icon_that_is_enabled() {
	        assertTrue("Edit icon is not enabled in all data table rows.", userpage.areEditIconsEnabledInAllRows());
	    }
	 
	 @Then("Each row in the user data table should have a delete icon that is enabled")
	    public void each_row_in_the_user_data_table_should_have_a_delete_icon_that_is_enabled() 
	 	{
	        assertTrue("Delete icon is not enabled in all data table rows.", userpage.areDeleteIconsEnabledInAllRows());
	    }
	 
	 @When("Admin enters {string} into search box.")
	    public void admin_enters_into_search_box(String searchText) 
	 	{
	        userpage.enterSearchText(searchText);
	    }
	 
	 @Then("Admin should see user displayed with the entered name")
	    public void admin_should_see_user_displayed_with_the_entered_name() 
	 	{
	        int userCount = userpage.getMatchingUserCount();
	        assertTrue("No user found with the entered name", userCount > 0);
	        LoggerLoad.info("Total number of users found: " + userCount);
	    }

	 @When("Admin enters the {string} not present in the data table on the Search box")
	    public void admin_enters_the_not_present_in_the_data_table_on_the_search_box(String keyWord) 
	 	{
	        userpage.enterKeywordInSearchBox(keyWord);
	    }
	 
	 @Then("Admin should see zero entries on the data table")
	    public void admin_should_see_zero_entries_on_the_data_table() 
	 	{
	        userpage.verifyNoEntriesDisplayed();
	    }
	 
	 //Assign Student starts here
	 @When("Admin clicks {string} button")
	    public void admin_clicks_button(String buttonName) throws InterruptedException 
	 	{
	        userpage.clickButton(buttonName);
	    }
	 
	 @Then("Admin should see a pop up open for assign student details with empty form along with Save and Cancel button and close \\(X) icon on the top right corner of the window")
	 public void admin_should_see_a_pop_up_open_for_assign_student_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window()
	 {
		 userpage.verifyPopupDisplayed();
		 userpage.verifyEmptyForm();
		 userpage.verifySaveAndCancelButton();
		 userpage.verifyCloseButton();
	    }
	 
	 @Then("Admin should see User Role as R03,and other fields Student Email id,Program Name,Batch Name and Status with respective input boxes.")
	 public void admin_should_see_user_role_as_r03_and_other_fields_student_email_id_program_name_batch_name_and_status_with_respective_input_boxes() 
	  {
		 userpage.verifyUserRole("R03");
		 userpage.verifyOtherFields();
	    }
	 
	 @Then("Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name")
	 public void admin_should_see_drop_down_boxes_with_valid_datas_for_student_email_id_program_name_and_batch_name() 
	 {
	 
	 }
	 
	 @Then("Admin should see two radio button for Status")
	    public void admin_should_see_two_radio_button_for_status() 
	 	{
	        assert userpage.isStatusRadioButtonsDisplayed() : "Status radio buttons are not displayed";
	    }
	 
	 @When("Admin clicks {string} button with entering any data")
	    public void admin_clicks_button_with_entering_any_data(String buttonName) {
		 userpage.clickSaveButton();
	    }
	 @Then("Admin gets a Error message alert")
	    public void admin_gets_a_error_message_alert() throws InterruptedException {
	        assertTrue("Error message is not displayed", userpage.isErrorMessageDisplayed());
	        LoggerLoad.info("Error message 'User Email Id is required.' is displayed.");
	        userpage.clickCancelButton();
	    }
	 
	 @When("Admin clicks {string} button without entering Student Email id")
	    public void admin_clicks_button_without_entering_student_email_id(String buttonName) {
		 userpage.verifyNoOptionSelected();
		 userpage.clickSaveButton();
	    }
	 @Then("Admin gets a Error message alert as {string}")
	    public void admin_gets_a_error_message_alert_as(String errorMessage) {
		 userpage.verifyErrorMessageAlert(errorMessage);
	    }
	 
	 @When("Admin clicks {string} button without selecting program")
	    public void admin_clicks_button_without_selecting_program(String buttonName) throws InterruptedException {
	        //System.out.println("Starting the test scenario: Admin clicks '" + buttonName + "' button without selecting program");
		 userpage.clickButtonWithoutSelectingProgram(buttonName);
	        //System.out.println("End of the test scenario: Admin clicks '" + buttonName + "' button without selecting program");
	    }
	 
	 @When("Admin clicks {string} button without selecting batch")
	    public void admin_clicks_button_without_selecting_batch(String buttonName) throws InterruptedException {
	        userpage.clickButtonWithoutSelectingBatch(buttonName);
	    }
	 
	 @When("Admin clicks {string} button without giving status")
	    public void admin_clicks_button_without_giving_status(String buttonName) throws InterruptedException {
		 userpage.clickButtonWithoutGivingStatus(buttonName);
	    }
	 
	 @When("Admin clicks Cancel\\/Close\\(X) Icon on Assign Student form")
	    public void admin_clicks_cancel_close_x_icon_on_assign_student_form() throws InterruptedException 
	 {
		 	userpage.selectEmail();
		 	userpage.selectProgram();
		 	userpage.selectBatch();
		 	userpage.selectStatus();
		 	userpage.clickCloseButton();
	 }
	 
	 @Then("Assign Student popup window should be closed without saving")
	    public void assign_student_popup_window_should_be_closed_without_saving() {
	        if (userpage.isassignStudentSuccessMessageDisplayed()) 
	        {
	            LoggerLoad.info("Success message appeared when it shouldn't have.");
	        } else 
	        {
	            LoggerLoad.info("Expected Success message did not appear. Changes were not saved.");
	        }
	    }
	 @When("Admin all the required fields with valid values and click Save button")
	    public void admin_all_the_required_fields_with_valid_values_and_click_save_button() throws InterruptedException 
	 	{
		 	userpage.selectEmail();
		 	userpage.selectProgram();
		 	userpage.selectBatch();
		 	userpage.selectStatus();
		 	userpage.clickSaveButton();
	    }
	 @Then("Admin gets a message {string} alert")
		public void admin_gets_a_message_alert(String string) 
		{
			if (userpage.isassignStudentSuccessMessageDisplayed()) {
		        LoggerLoad.info("Success message appeared.");
		    } else {
		        LoggerLoad.info("Expected Success message did not appear. Changes were not saved.");
		    }
		
		}
	 
	 @When("Admin clicks <Cancel>button")
		public void admin_clicks_cancel_button() throws InterruptedException 
		{
		 	userpage.selectEmail();
		 	userpage.selectProgram();
		 	userpage.selectBatch();
		 	userpage.selectStatus();
		 	userpage.clickCancelButton();
		
		}

		@Then("Admin can see the Assign Student popup disappears without assigning")
		public void admin_can_see_the_assign_student_popup_disappears_without_assigning() 
		{
			if (userpage.isassignStudentSuccessMessageDisplayed()) 
			{
		        LoggerLoad.info("Success message appeared when it shouldn't have.");
		    } else {
		        LoggerLoad.info("Expected Success message did not appear. Changes were not saved.");
		    }
		
		}
		
		@Then("Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close \\(X) icon on the top right corner of the window")
		public void admin_should_see_a_pop_up_open_for_assign_staff_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
		    
		}

		@Then("Admin should see User Role as R02,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes.")
		public void admin_should_see_user_role_as_r02_and_other_fields_student_email_id_skill_program_name_batch_name_and_status_with_respective_input_boxes() {
		   
		}

		@When("Admin clicks {string} button without entering Skill")
		public void admin_clicks_button_without_entering_skill(String string) {
		    
		}

		@When("Admin clicks Cancel\\/Close\\(X) Icon on Assign Staff  form")
		public void admin_clicks_cancel_close_x_icon_on_assign_staff_form() {
		    
		}

		@Then("Assign Staff popup window should be closed without saving")
		public void assign_staff_popup_window_should_be_closed_without_saving() {
		    
		}

		@When("Enter all the required fields with valid values and click Save button")
		public void enter_all_the_required_fields_with_valid_values_and_click_save_button() {
		    
		}

		@Then("Admin can see the Assign Staff popup disappears without assigning")
		public void admin_can_see_the_assign_staff_popup_disappears_without_assigning() {
		    
		}


}