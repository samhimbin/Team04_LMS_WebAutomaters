package com.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import com.Utilities.BaseClass;
import com.Utilities.LoggerLoad;
import com.driverFactory.DriverClass;
import com.pageObjects.DashboardPageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardPage_steps extends BaseClass {

	// ---#1 Dashboard page header validation-----

	@When("Admin enter valid credentials and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
		dashboard = new DashboardPageObject(DriverClass.getDriver());
		LoggerLoad.info("Admin gave valid credentials and landed on Dashboard Page");
	}

	@Then("Admin should see manage program as header")
	public void admin_should_see_manage_program_as_header() {

		String expectedHeaderText = "Manage Program";
		String actualHeaderText = dashboard.getHeaderText();
		Assert.assertEquals(expectedHeaderText, actualHeaderText);

	}

	// ---#Verify the response time

	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) {
		long totalresponseTime = dashboard.responseTime();
		LoggerLoad.info("navigation time in milliseconds :" + totalresponseTime);

	}

	// --#4 Verify LMS title----

	@Then("Admin should see LMS-Learning management system  as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
		String expectedTitle = "LMS - Learning Management System";
		String actualTitle = dashboard.lmsmanagetitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		LoggerLoad.info("Admin see " + actualTitle + " as title");
	}

	// --#5 Verify LMS title alignment-----

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		String alignment = dashboard.checkLMStitleAlignment();
		LoggerLoad.info("Alignment of LMS title is on top :" + alignment + "corner of page");
	}
	// ---#6 Validate navigation bar text----

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() throws IOException {
		dashboard.spellCheck();
		LoggerLoad.info("Admin see correct spellings in navigation bar text");
	}

	// --#7 Validate LMS title has correct spelling ang space

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() throws IOException {
		dashboard.spellCheckForLMStitle();
		LoggerLoad.info("Admin see correct spelling and space in LMS title");
	}
	
	//---#8 Validate alignment for navigation bar-----
	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
	    String alignment= dashboard.checkNavigationAlignment();
	    LoggerLoad.info("Admin should see the navigation bar text on the top "+alignment+" side");
	}

	// ---#9 Validate navigation bar order 1st Program---
	@Then("Admin should see program in the 1st place")
	public void admin_should_see_program_in_the_1st_place() {
		String option = dashboard.orderProgramNavigationBar();
		LoggerLoad.info("Admin see "+option+" in the 1st place");
	}
	// ---#10 Validate navigation bar order 2nd Batch---
	@Then("Admin should see batch in the 2nd place")
	public void admin_should_see_batch_in_the_2nd_place() {
		String option = dashboard.orderBatchNavigationBar();
		LoggerLoad.info("Admin see "+option+" in the 2nd place");
	}
	// ---#11 Validate navigation bar order 3rd User---
	@Then("Admin should see user in the  3rd place")
	public void admin_should_see_user_in_the_3rd_place() {
		String option = dashboard.orderUserNavigationBar();
		LoggerLoad.info("Admin see "+option+" in the 3rd place");
	}
	// ---#12 Validate navigation bar order 4th logout---
	@Then("Admin should see logout in the 4th place")
	public void admin_should_see_logout_in_the_4th_place() {
		String option = dashboard.orderLogoutNavigationBar();
		LoggerLoad.info("Admin see "+option+" in the 4th place");
	}

}
