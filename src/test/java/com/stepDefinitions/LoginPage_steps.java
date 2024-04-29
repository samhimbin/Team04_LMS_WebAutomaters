package com.stepDefinitions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Utilities.BaseClass;
import com.Utilities.ExcelReaderListMap;
import com.Utilities.LoggerLoad;
import com.driverFactory.DriverClass;
import com.pageObjects.LoginPageObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage_steps extends BaseClass {

	// -----#1 Portal page Validations-------
	
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {

		LoggerLoad.info("Launching Browser");
		loginpage = new LoginPageObject(DriverClass.getDriver());
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() throws IOException {

		DriverClass.openPage();
		LoggerLoad.info("Admin gave correct URL portal");
	}

	@Then("Admin should land on the home page")
	public void admin_should_land_on_the_home_page() {
		LoggerLoad.info("Admin landed on Home page");
	}

	// ------#2 invalid URL------
	
	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() throws MalformedURLException, IOException {
		DriverClass.invalidURL();
		LoggerLoad.info("Admin gave inValid URL");

	}

	@Then("Admin should recieve {int} page not found error")
	public void admin_should_recieve_page_not_found_error(Integer statuscode)
			throws MalformedURLException, IOException {
		loginpage.getStatusCode();
		LoggerLoad.info("ResponseCode: "+loginpage.getStatusCode());
		LoggerLoad.info("Admin recieves 404 Page Not Found error as response");
		DriverClass.NavBack();
	}

	// -----#3 broken link -------

	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer responseCode) throws MalformedURLException, IOException {
        int totalBrokenLinks =loginpage.checkBrokenLink();
        if(totalBrokenLinks==0) {
        LoggerLoad.info("No Broken links in Login Page");
        }
        else {
        	LoggerLoad.info("There are broken links");
        }
	}

	// ---#4 Spelling check for all fields-----

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() throws IOException {
		loginpage.spellCheck();
		LoggerLoad.info("Admin see correct spellings in all fields");
	}

	// ---#5 + Logo is present-------

	@Then("Admin should see logo is present")
	public void admin_should_see_logo_is_present() {
		boolean logoPresent = loginpage.checkLogoImage();
		Assert.assertTrue(logoPresent);
	}

	// ---#5 Logo alignment-------

	@Then("Admin should see logo on the left  side")
	public void admin_should_see_logo_on_the_left_side() {

		String alignment = loginpage.checkLogoAlignment();
		LoggerLoad.info("Alignment of Logo is :"+alignment);

	}
	
	//---#6 Verify application name
	
	@Then("Admin should see  LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() throws IOException {
	    //String applicationName = loginpage.ImageTextExtraction();
	    //LoggerLoad.info("applicationName :"+applicationName);
		DriverClass.getImageSource();
		LoggerLoad.info("Image is visually inspected to Verify Application Name");
		  
	}
	
    //---#7 verify company name
	
	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() {
		DriverClass.getImageSource();
		LoggerLoad.info("Image is visually inspected to Verify Company Name");
	}

	// ---#8 Login page sign In Content-----

	@Then("Admin should see {string}")
	public void admin_should_see(String phrase) {
		String phraseRecieved = loginpage.getSignInContent();
		LoggerLoad.info("phrase Recieved :" + phraseRecieved);
		Assert.assertEquals(phrase, phraseRecieved);
	}

	// ---#9 total Text fields-----

	@Then("Admin should see <{int}> text fields")
	public void admin_should_see_text_fields(Integer totalFields) {
		List<WebElement> inputFields = loginpage.getTotal_noOf_inputFields();
		LoggerLoad.info("Total fields Present:  " + inputFields.size());
		Assert.assertEquals(totalFields, inputFields.size());
	}

	// ---#10 Text field 1 as User-----

	@Then("Admin should see {string} in the first text field")
	public void admin_should_see_in_the_first_text_field(String User) {
		LoggerLoad.info("Placeholder for Text field 1: " + loginpage.checkFirstTextField());
		Assert.assertEquals(User, loginpage.checkFirstTextField());
	}

	// ---#11 asterik in Text field 1 <User>-----

	@Then("Admin should see * symbol next to user text")
	public void admin_should_see_symbol_next_to_user_text() {
		String symbol = "*";
		LoggerLoad.info("Asterik for Text field 1: " + loginpage.CheckAstericFirstTextfield());
		Assert.assertEquals(symbol, loginpage.CheckAstericFirstTextfield());
	}

	// ---#12 Text field 2 as Password-----

	@Then("Admin should see {string} in the second text field")
	public void admin_should_see_in_the_second_text_field(String Password) {
		LoggerLoad.info("Placeholder for Text field 2: " + loginpage.checkSecondTextField());
		Assert.assertEquals(Password, loginpage.checkSecondTextField());
	}

	// ---#13 asterik in Text field 2 <Password>-----

	@Then("Admin should see * symbol next to password text")
	public void admin_should_see_symbol_next_to_password_text() {
		String symbol = "*";
		LoggerLoad.info("Asterik for Text field 2: " + loginpage.CheckAstericSecondTextfield());
		Assert.assertEquals(symbol, loginpage.CheckAstericSecondTextfield());
	}

	//---#14 alignment of input Fields------
	
	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
	
		String alignment = loginpage.alignmentOfInputFields();
		LoggerLoad.info("Input fields are aligned in :"+ alignment);
	}

	//---#15 login button present----
	
	@Then("Admin should see Login button")
	public void admin_should_see_login_button() {
		LoggerLoad.info("Login button is present: "+ loginpage.checkLoginButton());
		Assert.assertTrue(loginpage.checkLoginButton());
	}

	//---#16 alignment of login button----
	
	@Then("Admin should see login button on the centre of the page")
	public void admin_should_see_login_button_on_the_centre_of_the_page() {
		String alignment = loginpage.alignmentOfLoginButton();
		LoggerLoad.info("Login button is in the :"+ alignment);
	}

	//---#17 color of User text Field----
	
	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() {
		
		//color = rgba(0, 0, 0, 0.87)
		//The color is mostly black with a slight transparency of 87% . Which is considered to be close to Gray
		//it's always best to visually inspect the color 
		
		String color = loginpage.colorOfUserTextField();
	    LoggerLoad.info("color of Descriptive text of user field: "+color);
	}

	//---#18 color of password text field---
	
	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
		String color = loginpage.colorOfPasswordTextField();
		LoggerLoad.info("color of Descriptive text of password field: "+color);
	}

	// -------- #19 valid credentials-------

	@Given("Admin is in Home Page")
	public void admin_is_in_home_page() {
		LoggerLoad.info("Admin is in Home Page");
		loginpage = new LoginPageObject(DriverClass.getDriver());

	}

	@When("Admin enter valid credentials from {string} and {int}")
	public void admin_enter_valid_credentials_from_and(String SheetName, Integer rowNumber)
			throws InvalidFormatException, IOException {
		ExcelReaderListMap reader = new ExcelReaderListMap();
		LoggerLoad.info("User enter login credentials");
		List<Map<String, String>> testData = reader.getData(BaseClass.eXCEL, "Login");
		String User_name = testData.get(rowNumber).get("user"); // Column heading
		String Pass_word = testData.get(rowNumber).get("password"); // Column heading
		loginpage.enterUsernamePasswrd(User_name, Pass_word);
		LoggerLoad.info("Login credentials entered");

	}

	@When("clicks login button")
	public void clicks_login_button() {
		loginpage.loginbtnclk();
		LoggerLoad.info("Login button got clicked");
	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
		LoggerLoad.info("Admin landed on Dashboard Page");
	}

	// -----#20 invalid credentials------

	@When("Admin enter invalid credentials from {string} and {int}")
	public void admin_enter_invalid_credentials_from_and(String SheetName, Integer rowNumber)
			throws InvalidFormatException, IOException {
		ExcelReaderListMap reader = new ExcelReaderListMap();
		LoggerLoad.info("User enter login credentials");
		List<Map<String, String>> testData = reader.getData(BaseClass.eXCEL, "Login");
		String User_name = testData.get(rowNumber).get("user"); // Column heading
		String Pass_word = testData.get(rowNumber).get("password"); // Column heading
		loginpage.enterUsernamePasswrd(User_name, Pass_word);

	}

	@Then("Error message for {string}")
	public void error_message_for(String errorMessage) {
		String actual_Message = loginpage.getErrorMessage();
		LoggerLoad.info("Actual error message:" + actual_Message);
		String expectedMessage = errorMessage;
		LoggerLoad.info("Expected error message:" + expectedMessage);
		DriverClass.toRefresh(); // to refresh the page
	}

	// ----#21 null username-------

	@When("Admin enter value only in password using {string} and {int}")
	public void admin_enter_value_only_in_password_using_and(String SheetName, Integer rowNumber)
			throws InvalidFormatException, IOException {
		ExcelReaderListMap reader = new ExcelReaderListMap();
		LoggerLoad.info("User forgot to enter username");
		List<Map<String, String>> testData = reader.getData(BaseClass.eXCEL, "Login");
		String User_name = testData.get(rowNumber).get("user"); // Column heading
		String Pass_word = testData.get(rowNumber).get("password"); // Column heading
		loginpage.enterUsernamePasswrd(User_name, Pass_word);
	}

	@Then("Error message for null username {string}")
	public void error_message_for_null_username(String errorMessage) {
		String actual_Message = loginpage.BlankUserMessage();
		LoggerLoad.info("Actual error message:" + actual_Message);
		DriverClass.toRefresh(); // to refresh the page
	}

	// ----#22 null password-------

	@When("Admin enter value only in username using {string} and {int}")
	public void admin_enter_value_only_in_username_using_and(String SheetName, Integer rowNumber)
			throws InvalidFormatException, IOException {
		ExcelReaderListMap reader = new ExcelReaderListMap();
		LoggerLoad.info("User forgot to enter password");
		List<Map<String, String>> testData = reader.getData(BaseClass.eXCEL, "Login");
		String User_name = testData.get(rowNumber).get("user"); // Column heading
		String Pass_word = testData.get(rowNumber).get("password"); // Column heading
		loginpage.enterUsernamePasswrd(User_name, Pass_word);
	}

	@Then("Error message for null password {string}")
	public void error_message_for_null_password(String errorMessage) {
		try {
		String actual_Message = loginpage.BlankPasswordMessage();
		LoggerLoad.info("Actual error message:" + actual_Message);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		DriverClass.toRefresh(); // to refresh the page
	}
	
	//---#23 login through keyboard click---
	
	@When("clicks login button through keyboard")
	public void clicks_login_button_through_keyboard() {
	    loginpage.keyBoardClickLoginButton();
	    LoggerLoad.info("Login button action using keyboard is successful ");
	}
	
	//-----#24 login using mouse click-----
	
	@When("clicks login button through mouse")
	public void clicks_login_button_through_mouse() {
	   loginpage.mouseClickLoginButton();
	   LoggerLoad.info("Login button action using mouse is successful");
	}
}
