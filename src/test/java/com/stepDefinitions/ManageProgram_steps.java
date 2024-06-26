package com.stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Utilities.BaseClass;
import com.Utilities.ExcelReaderListMap;
import com.Utilities.LoggerLoad;
import com.driverFactory.DriverClass;
import com.pageObjects.ProgramPageObject;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ManageProgram_steps extends BaseClass {

	// #1
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		programPage = new ProgramPageObject(DriverClass.getDriver());
		String dashboardTitle = DriverClass.getDriver().getTitle();
		LoggerLoad.info("dashboardTitle=" + dashboardTitle);
		Assert.assertEquals(dashboardTitle, "LMS");
	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String Program) throws Exception {
		programPage.clickOnProgramButton();
		LoggerLoad.info("Admin clicked on " + Program + "from navigation bar");
	}

	@Then("Admin should see URL with {string}")
	public void admin_should_see_url_with(String string) {
		String currentUrl = DriverClass.getDriver().getCurrentUrl();
		LoggerLoad.info("currentUrl :" + currentUrl);
		String expectedURL = BaseClass.ExpectedprogramUrl;
		try {
			Assert.assertEquals(currentUrl, expectedURL);
			//Assert.assertTrue(currentUrl.equals(expectedURL) || currentUrl.contains(expectedURL));
		} catch (Exception e) {
			e.printStackTrace();
		}
		programPage.manageProgramIsDisplayed();
		Assert.assertEquals(programPage.manageProgramIsDisplayed(), "Manage Program");
		LoggerLoad.info("Admin see the URL to be :" + expectedURL);
	}

	// #2
	@Then("Admin should see a heading with text {string} on the page")
	public void admin_should_see_a_heading_with_text_on_the_page(String string) {
		Assert.assertEquals(programPage.manageProgramIsDisplayed(), "Manage Program");
		LoggerLoad.info("Admin see a heading with text " + programPage.manageProgramIsDisplayed() + " on the page");
	}
	
	@Then("Admin should see the footer as In total there are z programs")
	public void admin_should_see_the_footer_as_in_total_there_are_z_programs() {
		LoggerLoad.info("Footer Message ------>"+programPage.getfooterMessage());
		Assert.assertTrue(programPage.getfooterMessage().startsWith("In total there are ") && programPage.getfooterMessage().endsWith(" programs."));
	}
	
    // Delete
	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
		Assert.assertFalse(programPage.deleteButtonValidation());
		LoggerLoad.info("DeleteButton------>"+programPage.deleteButtonValidation());
	}
	
	// Search
	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String string) {
		Assert.assertTrue(programPage.searchBoxValidation());  
		LoggerLoad.info("Search bar------>"+programPage.searchBoxValidation());
	}
	
    // Add new Program
	@Then("Admin should see a {string} button on the program page above the data table")
	public void admin_should_see_a_button_on_the_program_page_above_the_data_table(String string) {
		Assert.assertEquals(programPage.addProgramButtonValidation(), "A New Program");
		LoggerLoad.info("Admin should see a" +programPage.addProgramButtonValidation()+" button on the program page above the data table");
	}
	
	@Then("Admin should see data table on the Manage Program Page with column headers")
	public void dmin_should_see_data_table_on_the_manage_program_page_with_column_headers() {

		Assert.assertTrue("Program Name".equals(programPage.programNameHeaderValidation()));
		Assert.assertTrue("Program Description".equals(programPage.programDescriptionHeaderValidation()));
		Assert.assertTrue("Program Status".equals(programPage.programStatusHeaderValidation()));
		Assert.assertTrue("Edit / Delete".equals(programPage.editDeleteHeaderValidation()));
		LoggerLoad.info("Admin should see data table on the Manage Program Page with column headers");
	}

	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
	  
	  Assert.assertTrue("programName".contains(programPage.programNameArrowIconValidation()));
	  Assert.assertTrue("Program Description".contains(programPage.programDescriptionArrowIconValidation()));
	  Assert.assertTrue("Program Status".contains(programPage.programStatusArrowIconValidation()));
	  Assert.assertTrue("Edit / Delete".equals(programPage.editDeleteHeaderValidation()));
	  LoggerLoad.info("Admin should see the sort arrow icon beside to each column header except Edit and Delete");
	}
	
	// Pagenation
	@Then("Admin should see the text as Showing x to y of z entries along with Pagination icon below the table")
	public void admin_should_see_the_text_as_showing_x_to_y_of_z_entries_along_with_pagination_icon_below_the_table() {
		String rowsInfo = programPage.numberOfRecordstextValidate();
		String[] items = rowsInfo.split(" "); // e.g. Showing 1 to 5 of 7 entries
	    Assert.assertTrue(items.length == 7 && items[0].equals("Showing")&& items[2].equals("to")&& items[4].equals("of")&& items[6].equals("entries"));
	    LoggerLoad.info("Admin should see the text as "+ programPage.numberOfRecordstextValidate()+"along with Pagination icon below the table");
	}

	@Then("Admin should see check box on the left side in all rows of the data table")
	public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() {
		pageUtils = getCurrentPageUtils(programPage.numberOfRecordstextValidate());
		for (int i = 1; i<=pageUtils.getRecordsPerPage(); i++) {
			WebElement rowCheckBox = DriverClass.getDriver().findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr["+ i +"]/td[1]/p-tablecheckbox/div/div[2]"));
			Assert.assertTrue(rowCheckBox.isDisplayed());	
			LoggerLoad.info("Admin should see check box on the left side in all rows of the data table");
		}
	    
	}
	
	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		pageUtils = getCurrentPageUtils(programPage.numberOfRecordstextValidate());
		
		for (int i = 1; i<=pageUtils.getRecordsPerPage(); i++) {
			WebElement rowEditIcon = DriverClass.getDriver().findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr["+ i +"]/td[5]/div/span/button[1]/span[1]"));
			Assert.assertTrue(rowEditIcon.isDisplayed());	
		}

     	for (int i = 1; i<=pageUtils.getRecordsPerPage(); i++) {
			WebElement rowdeleteicon = DriverClass.getDriver().findElement(By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr["+ i +"]/td[5]/div/span/button[2]/span[1]"));
			Assert.assertTrue(rowdeleteicon.isDisplayed());
			LoggerLoad.info("Admin should see the Edit and Delete buttons on each row of the data table");
     	}
	}

	@Then("Admin should see the number of records displayed on the page are {int}")
	public void admin_should_see_the_number_of_records_displayed_on_the_page_are(Integer int1) {
		String[] items = programPage.numberOfRecordstextValidate().split(" "); // e.g. Showing 1 to 5 of 7 entries
		Assert.assertTrue(items.length == 7 && items[1].equals("1") && items[3].equals("5"));
		LoggerLoad.info("Admin should see the number of records displayed on the page are 5");
	}
	
	// Add A Program
	@Given("Admin is on Manage Program Page")
	public void admin_is_on_manage_program_page() {
		programPage.manageProgramIsDisplayed();
		Assert.assertEquals(programPage.manageProgramIsDisplayed(),"Manage Program");
		LoggerLoad.info("Admin is on Manage Program Page");
	}
	
	@When("Admin clicks <A New Program> button")
	public void admin_clicks_a_new_program_button() throws InterruptedException {
		programPage.clickOnaddProgram();
		LoggerLoad.info("Admin clicks <A New Program> button");
	}

	@Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
		// Check if all elements exists
		programPage.closeIsDisplayed();
		Assert.assertTrue(programPage.closeIsDisplayed());
		
		programPage.programNameValidate();
		Assert.assertTrue(programPage.programNameValidate().startsWith("Name"));
		
		Assert.assertEquals(programPage.programTextFieldValidate(), "");

		Assert.assertTrue(programPage.descriptionTextFieldIsDisplayed());
		
		Assert.assertTrue(programPage.inActiveStatusIsDisplayed());
		
		Assert.assertTrue(programPage.cancelIsDisplayed());
		Assert.assertTrue(programPage.saveIsDisplayed());
		
		programPage.clickOnClose();
		LoggerLoad.info("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and CloseIcon on the top right corner of the window");
	}
	
	@Then("Admin should see two input fields and their respective text boxes in the program details window")
	public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window() {
		Assert.assertTrue(programPage.programNameValidate().startsWith("Name"));
		Assert.assertTrue(programPage.programTextFieldIsDisplayed());
		Assert.assertEquals(programPage.programTextFieldValidate(), "");
		
		Assert.assertTrue(programPage.descriptionValidate().startsWith("Description"));//-->false
		Assert.assertTrue(programPage.descriptionTextFieldIsDisplayed());
		Assert.assertEquals(programPage.descriptionTextFieldValidate(), "");
		
		programPage.clickOnClose();
		LoggerLoad.info("Admin should see two input fields and their respective text boxes in the program details window");
	}

	@Then("Admin should see two radio button for Program Status")
	public void admin_should_see_two_radio_button_for_program_status() {
		Assert.assertTrue(programPage.activeStatusIsDisplayed());
		Assert.assertTrue(programPage.inActiveStatusIsDisplayed());
		
		programPage.clickOnClose();
	}
	
	@Given("Admin is on {string} Popup window")
	public void admin_is_on_popup_window(String string) throws InterruptedException {
		programPage.clickOnaddProgram();
		LoggerLoad.info("Admin is on Add Program Popup window");
	}

	@When("Admin clicks <Save>button without entering any data")
	public void admin_clicks_save_button_without_entering_any_data() {
		programPage.clickSave();
		LoggerLoad.info("Admin clicks <Save>button without entering any data");
	}

	@Then("Admin gets a Error message alertProgram")
	public void admin_gets_a_error_message_alert() {
		Assert.assertTrue(programPage.programNameValidate().startsWith("Name"));
		
		Assert.assertEquals(programPage.getProgramRequiredMsg(), "Program name is required.");
		
		Assert.assertEquals(programPage.descriptionTextFieldValidate(), "");
		
		Assert.assertEquals(programPage.getprogramDescRequiredMsg(), "Description is required.");
		
		Assert.assertEquals(programPage.getStatusMsg(),"Status is required.");
	    
		programPage.clickOnClose();
		LoggerLoad.info("Admin gets a Error message alert");
	}
	
	// Proram Name From Excel
	@When("Admin enter value only in ProgramName using {string} and {int}")
	public void admin_enter_value_only_in_program_name_using_and(String SheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReaderListMap reader = new ExcelReaderListMap();
		List<Map<String, String>> testData = reader.getData(BaseClass.eXCEL, "Program");
		String ProgramName = testData.get(rowNumber).get("ProgramName"); 
		programPage.enterNameTextField(ProgramName);
		LoggerLoad.info("Admin enter value only in ProgramName using sheetName and RowNumber");
	}

	@When("Admin clicks Save Button")
	public void admin_clicks_save_button() {
		programPage.clickSave();
		LoggerLoad.info("Admin clicks Save Button");
	}
	
    // Excel Reader Program Description
	@When("Admin enter value only in Program description using {string} and {int}")
	public void admin_enter_value_only_in_program_description_using_and(String SheetName, Integer rowNumber)throws InvalidFormatException, IOException
	{
		ExcelReaderListMap reader = new ExcelReaderListMap();
		List<Map<String, String>> testData = reader.getData(BaseClass.eXCEL, "Program");
		String ProgramDescription = testData.get(rowNumber).get("ProgramDescription"); 
		programPage.enterProgramDescriptionTextField(ProgramDescription);
		LoggerLoad.info("Admin enter value only in Program description using SheetName and RowNumber");
	}
	
	@Then("Admin gets a message alert {string}ProgramName")//program des
	public void admin_gets_a_message_alert_ProgramName(String string) {
         Assert.assertEquals(programPage.getProgramRequiredMsg(), "Program name is required.");
         
         programPage.clickOnClose();
         LoggerLoad.info("Admin gets a message alert" +programPage.getProgramRequiredMsg()+"ProgramName");
	}
	
	@Then("admin gets a message alert for description")
	public void admin_gets_a_message_alert_for_description() {
		Assert.assertEquals(programPage.getprogramDescRequiredMsg(), "Description is required.");
		programPage.clickOnClose();
		LoggerLoad.info("admin gets a message alert for description"+programPage.getprogramDescRequiredMsg());
	}

	@When("Admin selects only Status")
	public void admin_selects_only_status() {
		programPage.clickActivel();
		LoggerLoad.info("Admin selects only Status");
	}
	
	@Then("Admin gets a message alert {string} and {string}")
	public void admin_gets_a_message_alert_and(String string, String string2) {
	     Assert.assertEquals(programPage.getProgramRequiredMsg(), "Program name is required.");
	     Assert.assertEquals(programPage.getprogramDescRequiredMsg(), "Description is required.");
	     
	     programPage.clickOnClose();
	     LoggerLoad.info("Admin gets a message alert" +programPage.getProgramRequiredMsg()+  "and"+programPage.getprogramDescRequiredMsg() );
	}
	
	@When("Admin enters only numbers or special char in name and desc column {string} and {int}")
	public void admin_enters_only_numbers_or_special_char_in_name_and_desc_column_and(String SheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReaderListMap reader = new ExcelReaderListMap();
		List<Map<String, String>> testData = reader.getData(BaseClass.eXCEL, "Program");
		String ProgramName = testData.get(rowNumber).get("ProgramName"); 
		programPage.enterNameTextField(ProgramName);
		String ProgramDescription = testData.get(rowNumber).get("ProgramDescription"); 
		programPage.enterProgramDescriptionTextField(ProgramDescription);
		LoggerLoad.info("Admin enters only numbers or special char in name and desc column {string} and {int}");
	}
	
	@Then("Admin gets a Error message alert SpecialCharecters")
	public void admin_gets_a_error_message_alert_SpecialCharecters() {
		Assert.assertEquals(programPage.getprogramRequiredMsgSpecialCharacter(), "This field should start with an alphabet, no special char and min 2 char.");
		
		Assert.assertEquals(programPage.getprogramDescRequiredMsgSpecialCharacter(), "This field should start with an alphabet and min 2 char.");
		
		programPage.clickOnClose();
		LoggerLoad.info("Admin gets a Error message alert SpecialCharecters"+programPage.getprogramDescRequiredMsgSpecialCharacter()+"and"+programPage.getprogramDescRequiredMsgSpecialCharacter());
	}
	
	@When("Admin clicks Close\\(X) Icon on Program Details form")
	public void admin_clicks_cancelor_close_x_icon_on_program_details_form() {
		programPage.clickOnClose();
		LoggerLoad.info("Admin clicks Close(X) Icon on Program Details form");
	}
	
	@Then("Program Details popup window should be closed without savings")
	public void program_details_popup_window_should_be_closed_without_savings() {
		Assert.assertEquals(programPage.manageProgramIsDisplayed(),"Manage Program");
		LoggerLoad.info("Program Details popup window should be closed without savings");
	}

	@When("Enter all the required fields with valid values {string} and {int}")
	public void enter_all_the_required_fields_with_valid_values_and(String sheetName, Integer rowNumber) throws Exception {
		ExcelReaderListMap reader = new ExcelReaderListMap();
		List<Map<String, String>> testData = reader.getData(BaseClass.eXCEL, sheetName);
		String programName = testData.get(rowNumber).get("ProgramName"); // Column heading
		programPage.enterNameTextField(programName);
		String programDescription = testData.get(rowNumber).get("ProgramDescription"); // Column heading
		programPage.enterProgramDescriptionTextField(programDescription);
		String status = testData.get(rowNumber).get("Status");
		if ("Active".equalsIgnoreCase(status)) {
			programPage.clickActivel();
		} else if ("Inactive".equalsIgnoreCase(status)) {
			programPage.clickInactive();
		} else if (status == null || "".equals(status.trim())) {
			programPage.clickActivel();
		} else {
			throw new Exception("Invalid Status:" + status);
		}
		
		programPage.clickSave();
		LoggerLoad.info("Enter all the required fields with valid values");
	}

	@Then("Admin gets a message {string} alert and able to see the new program added in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_the_new_program_added_in_the_data_table(String string) throws Exception {
		programPage.validateAddProgramSuccess();
		LoggerLoad.info("Admin gets a message  alert and able to see the new program added in the data table");
	}

	@When("Admin clicks <Cancel>buttonProgram")
	public void admin_clicks_cancel_button() {
		programPage.clickCancel();
		LoggerLoad.info("Admin clicks <Cancel>button");
	}

	@Then("Admin can see the Program details popup disappears without creating any program")
	public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program() {
		Assert.assertEquals(programPage.manageProgramIsDisplayed(),"Manage Program");
		LoggerLoad.info("Admin can see the Program details popup disappears without creating any program");
	}
	
	@And("Admin clicks <Edit> button on the data table for any row")
	public void admin_clicks_edit_button_on_the_data_table_for_any_row() throws InterruptedException {
		pageUtils = getCurrentPageUtils(programPage.numberOfRecordstextValidate());
		programPage.clickOnEditIcon(pageUtils.getRecordsPerPage());
		LoggerLoad.info("Admin clicks <Edit> button on the data table for any row");
	}

	@Then("Admin should see a popup open for Program details to edit")
	public void admin_should_see_a_popup_open_for_program_details_to_edit() {
		
		Assert.assertTrue(programPage.closeIsDisplayed());
		
		Assert.assertTrue(programPage.programNameValidate().startsWith("Name"));
		Assert.assertTrue(programPage.programTextFieldIsDisplayed());
		
		Assert.assertTrue(programPage.descriptionValidate().startsWith("Description"));
		Assert.assertTrue(programPage.descriptionTextFieldIsDisplayed());
		Assert.assertTrue(!"".equals(programPage.descriptionValidate()));
		
		Assert.assertTrue(programPage.activeStatusIsDisplayed());
		Assert.assertTrue(programPage.inActiveStatusIsDisplayed());
		
		Assert.assertTrue(programPage.cancelIsDisplayed());
		Assert.assertTrue(programPage.saveIsDisplayed());
		
		programPage.clickOnClose();
		LoggerLoad.info("Admin should see a popup open for Program details to edit");
	}

	@When("Admin edits the Name column using {string} and {int}")
	public void admin_edits_the_name_column_using_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReaderListMap reader = new ExcelReaderListMap();
		List<Map<String, String>> testData = reader.getData(BaseClass.eXCEL, "Program");
		String programName = testData.get(rowNumber).get("ProgramName"); 
		programPage.clearNameTextField();
		programPage.enterNameTextField(programName);
		LoggerLoad.info("Admin edits the Name column");
	}

	@Then("Admin gets a message {string} alert and able to see the updated name in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_name_in_the_table_for_the_particular_program(String string) throws Exception {
		programPage.validateEditProgramSuccess();
		LoggerLoad.info("Admin gets a message {string} alert and able to see the updated name in the table for the particular program");
	}

	@When("Admin edits the Description column in using {string} and {int}")
	public void admin_edits_the_description_column_in_using_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReaderListMap reader = new ExcelReaderListMap();
		List<Map<String, String>> testData = reader.getData(BaseClass.eXCEL, "Program");
		String programDesc = testData.get(rowNumber).get("ProgramDescription"); 
		programPage.clearProgramDescriptionTextField();
		programPage.enterProgramDescriptionTextField(programDesc);
		LoggerLoad.info("Admin edits the Description column");
	}

	@Then("Admin gets a message {string} alert and able to see the updated description in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_description_in_the_table_for_the_particular_program(String string) throws Exception {
		programPage.validateEditProgramSuccess();
		LoggerLoad.info("Admin gets a message  program Success alert and able to see the updated description in the table for the particular program");
	}

	@When("Admin changes the Status")
	public void admin_changes_the_status() {
		programPage.clickInactive();
		LoggerLoad.info("Admin changes the Status");
	}

	@Then("Admin gets a message {string} alert and able to see the updated status in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_status_in_the_table_for_the_particular_program(String string) throws Exception {
		programPage.validateEditProgramSuccess();
		LoggerLoad.info("Admin gets a message Program Edit Success alert and able to see the updated status in the table for the particular program");
	}

	@When("Admin edit special char in name and desc column {string} and {int}")
	public void admin_edit_special_char_in_name_and_desc_column_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReaderListMap reader = new ExcelReaderListMap();
		List<Map<String, String>> testData = reader.getData(BaseClass.eXCEL, "Program");
		
		String programName = testData.get(rowNumber).get("ProgramName"); 
		String programDesc = testData.get(rowNumber).get("ProgramDescription"); 
		
		programPage.clearNameTextField();
		programPage.clearProgramDescriptionTextField();
		
		programPage.enterNameTextField(programName);
		programPage.enterProgramDescriptionTextField(programDesc);
		LoggerLoad.info("Admin edit special char in name and desc");
	}

	@Then("Admin gets a Error message alert Edit program")
	public void admin_gets_a_error_message_alert_edit_program() {
		programPage.getprogramRequiredMsgSpecialCharacter();
		programPage.getprogramDescRequiredMsgSpecialCharacter();
		Assert.assertEquals(programPage.getprogramRequiredMsgSpecialCharacter(), "This field should start with an alphabet, no special char and min 2 char.");
		Assert.assertEquals(programPage.getprogramDescRequiredMsgSpecialCharacter(), "This field should start with an alphabet and min 2 char.");
		
		programPage.clickOnClose();
		LoggerLoad.info("Admin gets a Error message alert Edit program");
	}

	@When("Admin clicks <Cancel>button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
		programPage.clickCancel();
		LoggerLoad.info("Admin clicks <Cancel>button on edit popup");
	}

	@Then("Admin can see the Program details popup disappears and can see nothing changed for particular program")
	public void admin_can_see_the_program_details_popup_disappears_and_can_see_nothing_changed_for_particular_program() {
		Assert.assertEquals(programPage.manageProgramIsDisplayed(),"Manage Program");
		LoggerLoad.info("Admin can see the Program details popup disappears and can see nothing changed for particular program");
	}

	@When("Admin clicks <Save>button on edit popup")
	public void admin_clicks_save_button_on_edit_popup() {
		programPage.clickSave();
		LoggerLoad.info("Admin clicks <Save>button on edit popup");
	}
	
	@Then("Admin gets a message {string} alert and able to see the updated details in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_details_in_the_table_for_the_particular_program(String string) throws Exception {
		programPage.validateEditProgramSuccess();
		LoggerLoad.info("Admin gets a message Edit program Success alert and able to see the updated details in the table for the particular program");
	}

	// Delete Program step definitions
	@When("Admin clicks <Delete> button on the data table for any row")
	public void admin_clicks_delete_button_on_the_data_table_for_any_row() throws InterruptedException {
		pageUtils = getCurrentPageUtils(programPage.numberOfRecordstextValidate());
		programPage.clickOnDeleteIcon(pageUtils.getRecordsPerPage());
		LoggerLoad.info("Admin clicks <Delete> button on the data table for any row");
	}
	
	@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String string) {
		// Confirm header
		Assert.assertEquals(programPage.getConfrimText(), "Confirm");
		
		// No button
		Assert.assertTrue(programPage.isNoButtonDisplayed());
		Assert.assertEquals(programPage.getNoButtonText(), "No");
		
		// Yes button
		Assert.assertTrue(programPage.isYesButtonDisplayed());
		Assert.assertEquals(programPage.getYesButtonText(), "Yes");
	    
		// Close icon
		Assert.assertTrue(programPage.isDeleteCloseIconDisplayed());
		
		programPage.clickOnDeleteCloseIcon();
		LoggerLoad.info("Admin should see a alert open with heading  <YES> and <NO> button for deletion");
	}
	
	@Then("Admin should see a message {string}")
	public void admin_should_see_a_message(String string) {
		// Confrim message
		Assert.assertTrue(programPage.getConfrimMsgText().contains("Are you sure you want to delete "));
		
		programPage.clickOnDeleteCloseIcon();
		LoggerLoad.info("Admin should see a message Delete Alert message");
	}
	
	@Given("Admin is on Confirm Deletion alert")
	public void admin_is_on_confirm_deletion_alert() throws InterruptedException {
		pageUtils = getCurrentPageUtils(programPage.numberOfRecordstextValidate());
		programPage.clickOnDeleteIcon(pageUtils.getRecordsPerPage());
		LoggerLoad.info("Admin is on Confirm Deletion alert");
	}
	
	@When("Admin clicks <YES> button on the alert")
	public void admin_clicks_yes_button_on_the_alert() {
		programPage.clickOnYesButton();
		LoggerLoad.info("Admin clicks <YES> button on the alert");
	}
	
	@Then("Admin gets a message {string} alert and able to see that program deleted in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_that_program_deleted_in_the_data_table(String string) throws Exception {
		programPage.validateDeleteProgramSuccess();
		LoggerLoad.info("Admin gets a message Program Delete Success alert and able to see that program deleted in the data table");
	}
	
	@When("Admin clicks <NO> button on the alert")
	public void admin_clicks_no_button_on_the_alert() {
		programPage.clickOnNoButton();
		LoggerLoad.info("Admin clicks <NO> button on the alert");
	}
	
	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
		Assert.assertEquals(programPage.manageProgramIsDisplayed(),"Manage Program");
		LoggerLoad.info("Admin can see the deletion alert disappears without deleting");
	}
	
	@When("Admin clicks Close\\(X) Icon on Deletion alert")
	public void admin_clicks_close_x_icon_on_deletion_alert() {
		programPage.clickOnDeleteCloseIcon();
		LoggerLoad.info("Admin clicks Close(X) Icon on Deletion alert");
	}
	
	@Then("Admin can see the deletion alert disappears without any changes")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes() {
		Assert.assertEquals(programPage.manageProgramIsDisplayed(),"Manage Program");
		LoggerLoad.info("Admin can see the deletion alert disappears without any changes");
	}
	// End of Delete Program step definitions

}
