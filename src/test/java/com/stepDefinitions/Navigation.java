package com.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.lms.factory.DriverFactory;
import lms.pagefactory.Navi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Navigation {
    private WebDriver driver = DriverFactory.getDriver();
    private Navi navigationPage = new Navi(driver);

    @Given("Admin is on Manage Program page")
    public void admin_is_on_manage_program_page() {
        System.out.println("Admin is on the Manage Program page."); 
        navigationPage.clickCheckBoxButton();
    }

    @When("Admin clicks on Batch link on Manage Program page")
    public void admin_clicks_on_batch_link_on_manage_program_page() {
        // Implement code to click on the Batch link
    }

    @Then("Admin is re-directed to Batch page")
    public void admin_is_re_directed_to_batch_page() {
        // Add assertions or validation logic here to confirm redirection to the Batch page
    }

    @When("Admin clicks on User link on Manage Program page")
    public void admin_clicks_on_user_link_on_manage_program_page() {
        // Implement code to click on the User link
    }

    @Then("Admin is re-directed to User page")
    public void admin_is_re_directed_to_user_page() {
        // Add assertions or validation logic here to confirm redirection to the User page
    }

    @When("Admin clicks on Logout link on Manage Program page")
    public void admin_clicks_on_logout_link_on_manage_program_page() {
        // Implement code to click on the Logout link
    }

    @Then("Admin is re-directed to Login page")
    public void admin_is_re_directed_to_login_page() {
        // Add assertions or validation logic here to confirm redirection to the Login page
    }
}
