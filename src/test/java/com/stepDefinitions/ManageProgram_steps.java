package com.stepDefinitions;

import org.testng.Assert;

import com.Utilities.BaseClass;
import com.driverFactory.DriverClass;
import com.Utilities.LoggerLoad;

import io.cucumber.core.logging.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pageObjects.ProgramPageObject;

public class ManageProgram_steps extends BaseClass {

	// #1
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		programpage = new ProgramPageObject(DriverClass.getDriver());
		String dashboardTitle = DriverClass.getDriver().getTitle();
		LoggerLoad.info("dashboardTitle=" + dashboardTitle);
		Assert.assertEquals("LMS", dashboardTitle);
	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String Program) {
		programpage.clickOnProgramButton();
		LoggerLoad.info("Admin clicked on " + Program + "from navigation bar");
	}

	@Then("Admin should see URL with {string}")
	public void admin_should_see_url_with(String string) {
		String currentUrl = DriverClass.getDriver().getCurrentUrl();
		LoggerLoad.info("currentUrl :" + currentUrl);
		String expectedURL = BaseClass.ExpectedUrl;
		try {
			Assert.assertEquals(currentUrl, expectedURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		programpage.manageProgramIsDisplayed();
		Assert.assertEquals(programpage.manageProgramIsDisplayed(), "Manage Program");
		LoggerLoad.info("Admin see the URL to be :" + expectedURL);
	}

	// #2
	@Then("Admin should see a heading with text {string} on the page")
	public void admin_should_see_a_heading_with_text_on_the_page(String string) {

		Assert.assertEquals(programpage.manageProgramIsDisplayed(), "Manage Program");
		LoggerLoad.info("Admin see a heading with text " + programpage.manageProgramIsDisplayed() + " on the page");
	}

	// #3
	@Then("Admin should see the text as Showing x to y of z entries along with Pagination icon below the table")
	public void admin_should_see_the_text_as_showing_x_to_y_of_z_entries_along_with_pagination_icon_below_the_table() {

	}

	// #4
	@Then("Admin should see the footer as In total there are z programs")
	public void admin_should_see_the_footer_as_in_total_there_are_z_programs() {
		LoggerLoad.info("Footer Message ------>" + programpage.getfooterMessage());
		Assert.assertTrue(programpage.getfooterMessage().startsWith("In total there are ")
				&& programpage.getfooterMessage().endsWith(" programs."));

	}
    
	//#5
	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
		
	}
    
	//#12
	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String string) {
		
		Assert.assertTrue(programpage.searchBoxValidation());
        LoggerLoad.info("Admin see Search bar with text as "+ programpage.searchBoxValidation());
	}

}
