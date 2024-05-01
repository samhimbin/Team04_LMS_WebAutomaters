package com.stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import com.Utilities.BaseClass;
import com.Utilities.LoggerLoad;
import com.driverFactory.DriverClass;
import com.pageObjects.BatchPageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageBatch_steps extends BaseClass {

	@Given("Admin is on the dashboard page after Login")
	public void admin_is_on_the_dashboard_page_after_login() {
		batchpage = new BatchPageObject(DriverClass.getDriver());
		String dashboardTitle = DriverClass.getDriver().getTitle();
		LoggerLoad.info("Admin is on the dashboard page after Login :" + dashboardTitle);
	}

	@When("Admin clicks Batch from navigation bar")
	public void admin_clicks_batch_from_navigation_bar() {
		batchpage.clickBatchBtn();
	}

	@Then("Admin should see the Manage Batch in the URL")
	public void admin_should_see_the_manage_batch_in_the_url() {

		String currentUrlBatch = batchpage.findCurrentUrl();
		Assert.assertEquals(currentUrlBatch, BaseClass.expectedBatchUrl);

		if (currentUrlBatch.equals(BaseClass.expectedBatchUrl)) {
			LoggerLoad.info("url matches");
		} else {
			LoggerLoad.info("url doesn't contain Manage Batch :"+currentUrlBatch);
		}

	}
	@Then("Admin should see the {string} in the header")
	public void admin_should_see_the_in_the_header(String string) {
		LoggerLoad.info(" enetered managebatch code");
		String manageText1 = batchpage.manageBatchFunction();
		LoggerLoad.info("******"+ manageText1);
		LoggerLoad.info("####" + string);
		if(manageText1.equals(string)) {
			LoggerLoad.info("Admin see Manage Batch in the header" + manageText1);
		}
		else {
			LoggerLoad.info("Admin couldn't see Manage Batch in the header");
		}
	}
	@Then("Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() {
		LoggerLoad.info("Admin see the pagination controls under the data table: "+ batchpage.paginationFinder());
	}
	@Then("Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete")
	public void admin_should_see_the_data_table_with_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {
		String dataTexts=batchpage.batchTableData();
		LoggerLoad.info("******"+ dataTexts);
		
	}
	@Then("Admin should be able to see the Delete icon button that is disabled")
	public void admin_should_be_able_to_see_the_delete_icon_button_that_is_disabled() {
		
		LoggerLoad.info("Admin is able to see the Delete icon button that is disabled :"+batchpage.disabledDeleteFunction() );
	}
	@Then("Admin should be able to see the + A New batch button")
	public void admin_should_be_able_to_see_the_a_new_batch_button() {
	
		LoggerLoad.info("Admin is able to see the + A New batch button :"+batchpage.addNewButtonFunction());
	}

	@Then("Each row in the data table should have a checkbox")
	public void each_row_in_the_data_table_should_have_a_checkbox() {
		LoggerLoad.info("Each row in the data table have a checkbox :"+ batchpage.checkBoxFunction());
	}
	@Then("Each row in the data table should have a edit icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {
		LoggerLoad.info("Each row in the data table have a edit icon that is enabled :"+	batchpage.editIconFunction());
	    
	}
	@Then("Each row in the data table should have a delete icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() {
		LoggerLoad.info("Each row in the data table have a delete icon that is enabled :"+ batchpage.deleteIconFunction());
	}
	@When("Admin clicks + A New Batch button")
	public void admin_clicks_a_new_batch_button() {
		batchpage.newBatchAlertFunction();
		LoggerLoad.info("Admin clicked + A New Batch button");
	}

	@Then("A new pop up with Batch details appears")
	public void a_new_pop_up_with_batch_details_appears()  {
		
	    String alertText =batchpage.alertDisplyFunction();
		Assert.assertEquals("Batch Details", alertText);
		LoggerLoad.info("Alert message: " + alertText);
	}
	
	
	
	
	
	
	
	
//	@Then("Each row in the data table should have a checkbox")
//	public void each_row_in_the_data_table_should_have_a_checkbox() {
//		batchpage.checkBoxFunction();
//	}
//	@Then("Each row in the data table should have a edit icon that is enabled")
//	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {
//		batchpage.editIconFunction();
//	    
//	}
//	
//	@Then("Each row in the data table should have a delete icon that is enabled")
//	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() {
//		batchpage.deleteIconFunction();
//	}
	
	@When("Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() {
		batchpage.rowDeleteFunction();
	    
	}

	@Then("Alert appears with yes and No option")
	public void alert_appears_with_yes_and_no_option() throws Throwable {
		
		String actualMsg = null;


		actualMsg = batchpage.alertDisplyFunction();

		LoggerLoad.info("Actual message is  : " + actualMsg);
		assertEquals(actualMsg,"Alert appears with yes and No option", "Result matched");
		

	}
	
	@When("You click yes option")
	public void you_click_yes_option() {
		batchpage.batchDeleteYes();
	    
	}

	@Then("Batch deleted alert pops and batch is no more available in data table")
	public void batch_deleted_alert_pops_and_batch_is_no_more_available_in_data_table() {
//		assertTrue(signinPg.getConfrimMsgText().contains("Successful"));
//        
//        programPage.clickOnClose();
//
//
//		actualDeleteMsg = signinPg.alertDisplayFunction3();

//		LoggerLoad.info("Actual message is  : " + actualDeleteMsg);
		//assertEquals(actualDeleteMsg,"Alert appears with yes and No option", "Result matched");
	    
	}

	@When("you click No option")
	public void you_click_no_option() {
		batchpage.batchDeleteNo();
	}

	@Then("Batch is still listed in data table")
	public void batch_is_still_listed_in_data_table() {
		batchpage.batchserachfunction();
	}
	
	@Given("None of the checkboxes in data table are selected")
	public void none_of_the_checkboxes_in_data_table_are_selected() {
		batchpage.checkboxFunction();
	    
	}

	@Then("The delete icon under the Manage Batch header should be disabled")
	public void the_delete_icon_under_the_manage_batch_header_should_be_disabled() { 
		batchpage.disabledDeleteFunction();
	}
	@Given("One of the checkbox\\/ row is selected")
	public void one_of_the_checkbox_row_is_selected() {
		//selected first row
		batchpage.selectOnlyOneRow();
	}

	@When("Click delete icon below Manage Batch header")
	public void click_delete_icon_below_manage_batch_header() {
		batchpage.disabledDeleteFunctiontoDelete();
	    
	}

	@Then("The respective row in the data table is deleted")
	public void the_respective_row_in_the_data_table_is_deleted() {
		batchpage.batchDeleteYes();	
		
	}

	@Given("Two or more checkboxes\\/row is selected")
	public void two_or_more_checkboxes_row_is_selected() {
		
	    //selcet first 2 rows
		
		batchpage.selectMultiRow();
		
	}
	
}
	
	




