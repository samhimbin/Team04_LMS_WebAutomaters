package com.stepDefinitions;



import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Utilities.BaseClass;
import com.Utilities.LoggerLoad;
import com.driverFactory.DriverClass;

import com.pageObjects.UserPageObject;


import io.cucumber.java.en.*;

public class ManageUser_steps extends BaseClass{
	
	WebDriver driver;
	
	
	

	@Given("Admin is on Manage User Page")
	public void admin_is_on_manage_user_page() {
		UserPageObject.manageProgramIsDisplayed();
		Assert.assertEquals(UserPageObject.manageProgramIsDisplayed(),"Manage program");
	}

	@When("Admin clicks  A New User button")
	public void admin_clicks_a_new_user_button() {
		UserPageObject.clickaddNewBtn();
		
	}

	@Then("Admin should see pop up open for user details with First Name,Middle name,Last Name,Location,phone,email,linkedin url..etc\"")
	public void admin_should_see_pop_up_open_for_user_details_with_first_name_middle_name_last_name_location_phone_email_linkedin_url_etc() {
		String parentWindow = driver.getWindowHandle();
		
		String currentWindowHandle = driver.getWindowHandle();
	    Set<String> windows = driver.getWindowHandles();
	    for(String win : windows) {
		driver.switchTo().window(win);
		//if(driver.getTitle().equals("userDetailsTitle")){
			//driver.close();
			
		//}
		//driver.switchTo().window(parentWindow);
		
	}
		
		
		
		
	}

	@Then("{string}")
	public void string(String string) {
	 
	}

	@When("Admin enters mandatory fields in the form and clicks on submit button")
	public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_submit_button() {
	   
	}

	@Then("Admin gets message User added Successfully")
	public void admin_gets_message_user_added_successfully() {
	
	}

	@When("Admin skips to add value in mandatory field")
	public void admin_skips_to_add_value_in_mandatory_field() {
	   	}

	@Then("Admin should see error message below the test field and the field will be highlighed in red color")
	public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighed_in_red_color() {
	   
	}

	@When("Admin enters invalid data in all of the  fields in the form and clicks on submit button")
	public void admin_enters_invalid_data_in_all_of_the_fields_in_the_form_and_clicks_on_submit_button() {
	   
	}

	@Then("Admin gets error message and user is not created")
	public void admin_gets_error_message_and_user_is_not_created() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks on submit button without entering data")
	public void admin_clicks_on_submit_button_without_entering_data() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("user won't be created and Admin gets error message")
	public void user_won_t_be_created_and_admin_gets_error_message() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks Cancel\\/Close\\(X) Icon on User Details form")
	public void admin_clicks_cancel_close_x_icon_on_user_details_form() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User Details popup window should be closed without saving")
	public void user_details_popup_window_should_be_closed_without_saving() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin can see the User details popup disappears without adding any user")
	public void admin_can_see_the_user_details_popup_disappears_without_adding_any_user() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Fill in all the fields with valid values and click submit")
	public void fill_in_all_the_fields_with_valid_values_and_click_submit() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The newly added user should be present in the data table in Manage User page")
	public void the_newly_added_user_should_be_present_in_the_data_table_in_manage_user_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


}
