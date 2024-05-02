package com.stepDefinitions;

import org.testng.Assert;

import com.Utilities.BaseClass;
import com.Utilities.LoggerLoad;
import com.driverFactory.DriverClass;
import com.pageObjects.LogOutPageObjects;
import com.stepDefinitions.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogOut extends BaseClass {
	
	@Given("Admin is in dashboard page")
	public void admin_is_in_dashboard_page() {
		//driver = new ChromeDriver();
		logOutPage = new LogOutPageObjects(DriverClass.getDriver());
		
	}

	@When("Admin click Logout button on navigation bar")
	public void admin_click_logout_button_on_navigation_bar() {
		logOutPage.clickLogout();
		LoggerLoad.info("CLICKED LOGOUT BUTTON");
	}

	@Then("Admin should land on login in page")
	public void admin_should_land_on_login_in_page() {
		Assert.assertEquals(BaseClass.logOutExpectedUrl, DriverClass.getDriver().getCurrentUrl());
	  LoggerLoad.info("I am on the login page");
	}
	

}
