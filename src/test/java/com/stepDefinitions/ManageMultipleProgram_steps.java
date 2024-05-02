package com.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.driverFactory.DriverClass;
import com.pageObjects.MulipleProgramPageObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ManageMultipleProgram_steps {
    private MulipleProgramPageObject programPage = new MulipleProgramPageObject(DriverClass.getDriver());
    
    @Given("Admin is in the manage program page after clicking Program on the navigation bar")
    public void admin_is_in_the_manage_program_page_after_clicking_program_on_the_navigation_bar() throws InterruptedException {
//        Thread.sleep(3000);
//        DriverClass.getDriver().navigate().back();
//        programPage.selectOneProgramChk();
        Assert.assertTrue("Manage Program".equalsIgnoreCase(programPage.getProgramHeaderName()));
        System.out.println("Admin is in the manage program page.");
    }

    @When("Admin clicks any checkbox in the data table")
    public void admin_clicks_any_checkbox_in_the_data_table() {
//        programPage.selectOneProgramChk();
        String isSelected = programPage.isSelectedProgramChk();
        //Assert.assertTrue(isSelected.equalsIgnoreCase("true"));
    }
    
    @Then("Admin should see common delete icon enabled under header Manage Program")
    public void admin_should_see_common_delete_icon_enabled_under_header_manage_program() {
        Assert.assertTrue(programPage.isEnabledCommonDeleteBtn());
    }

    @Given("Admin clicks delete button after selecting the check box in the data table to reach on confirm deletion alert")
    public void admin_clicks_delete_button_after_selecting_the_check_box_in_the_data_table_to_reach_on_confirm_deletion_alert() {
        programPage.clickCommonDeleteButton();
    }

    @When("Admin clicks <YES> button on the alert for multiple")
    public void admin_clicks_yes_button_on_the_alert_for_multiple() throws InterruptedException {
        Thread.sleep(2000);
        programPage.commonDeleteAlertConfirmYes();
    }
    @Then("Admin should land on Manage Program page and can see the selected program is deleted from the data table")
    public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_deleted_from_the_data_table() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("Admin clicks delete button box and Confirm Deletion alert")
    public void admin_clicks_delete_button_box_and_confirm_deletion_alert() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Admin clicks <NO> button on the alert for multiple")
    public void admin_clicks_no_button_on_the_alert_for_multiple() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should land on Manage Program page and can see the selected program is not deleted from the data table")
    public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_not_deleted_from_the_data_table() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("Admin clicks delete button under header after selecting multiple checkboxes and Confirm Deletion alert")
    public void admin_clicks_delete_button_under_header_after_selecting_multiple_checkboxes_and_confirm_deletion_alert() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Admin clicks <YES> button")
    public void admin_clicks_yes_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should land on Manage Program page and can see the selected programs are deleted from the data table")
    public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_deleted_from_the_data_table() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("clicks <No> button on  alert")
    public void clicks_no_button_on_alert() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should land on Manage Program page and can see the selected programs are not deleted from the data table")
    public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_not_deleted_from_the_data_table() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
