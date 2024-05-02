//package com.lms.steps;
//
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import com.lms.factory.DriverFactory;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//import lms.pagefactory.Pagination_pagefactory;
//
//public class lms_pagination {
//   
//     WebDriver driver = DriverFactory.getDriver();
//    
//
//    @Given("Admin is logged in")
//    public void admin_is_logged_in() throws InterruptedException {
//    	Thread.sleep(2000);
//    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    	// manageProgramPage = new Pagination_pagefactory(driver);
//    	Pagination_pagefactory manageProgramPage = new Pagination_pagefactory();
//    	Assert.assertTrue(manageProgramPage.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
//      
//    }
//    
//
//    @Then("Admin should be on Manage Program Page in program module")
//    public void admin_should_be_on_manage_program_page_in_program_module() {
//    	    
//    }
//    @Given("Admin is on Manage Program page in program module")
//    public void admin_is_on_manage_program_page_in_program_module() {
//        
//    }
//    
//    	
//    	
//
//    @When("Admin clicks Next page link on the program table")
//    public void admin_clicks_next_page_link_on_the_program_table() {
//    	
//   
//    @Then("Admin should see the Pagination has Next active link")
//    public void admin_should_see_the_pagination_has_next_active_link() {
//        
//
//    }
//  
//    @When("Admin clicks Last page link")
//    public void admin_clicks_last_page_link() {
//    	public boolean isLastLink()
//    	{
//            // Wait for the table to reload with the next page records
//    	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(1000));
//    	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));
//
//    			
////    	        // Find the disabled element using JavaScript Executor
////    	        WebElement nextBtn = (WebElement) ((JavascriptExecutor) driver)
////    	                .executeScript("return document.getElementsByClassName('p-paginator-next p-paginator-element p-link p-ripple');");
//    			// Check if the next page button is enabled
////    	        boolean isNextEnabled = nextBtn.isEnabled();
////    	        boolean isNextEnabled = driver.findElement(nextBtn).isEnabled();
////    	        boolean isNextEnabled = !driver.findElement(nextBtn).getAttribute("class").contains("disabled");
////    	        System.out.println("isNextEnabled "+isNextEnabled);  
//    	        boolean isLastEnabled;
//    	        List<WebElement> elements = driver.findElements(nextBtn);
//    	        if (!elements.isEmpty()) {
//    	            WebElement button = elements.get(0);
//    	            isNextEnabled = button.isEnabled();
//    	            // Perform actions on the button
//    	        } else {
//    	        	
//    	            // Element not found, handle accordingly
//    	        	isNextEnabled = false;
//    	        }
//
//    	        return isNextEnabled;
//
////    	        // Verify that the "Next" link in the pagination is active
////    	        WebElement nextPageActiveLink = driver.findElement(By.xpath("//a[@class='next-page-link' and @aria-disabled='false']"));
////    	        // Perform assertions or further verification on the "Next" active link
//    		}// Wait for the table to reload with the next page records
//            WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(1000));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));
//
//    		
////            // Find the disabled element using JavaScript Executor
////            WebElement nextBtn = (WebElement) ((JavascriptExecutor) driver)
////                    .executeScript("return document.getElementsByClassName('p-paginator-next p-paginator-element p-link p-ripple');");
//    		// Check if the next page button is enabled
////            boolean isNextEnabled = nextBtn.isEnabled();
////            boolean isNextEnabled = driver.findElement(nextBtn).isEnabled();
////            boolean isNextEnabled = !driver.findElement(nextBtn).getAttribute("class").contains("disabled");
////            System.out.println("isNextEnabled "+isNextEnabled);  
//            boolean isNextEnabled;
//            List<WebElement> elements = driver.findElements(nextBtn);
//            if (!elements.isEmpty()) {
//                WebElement button = elements.get(0);
//                isNextEnabled = button.isEnabled();
//                // Perform actions on the button
//            } else {
//            	
//                // Element not found, handle accordingly
//            	isNextEnabled = false;
//            }
//
//            return isNextEnabled;
//
////            // Verify that the "Next" link in the pagination is active
////            WebElement nextPageActiveLink = driver.findElement(By.xpath("//a[@class='next-page-link' and @aria-disabled='false']"));
////            // Perform assertions or further verification on the "Next" active link
//    	}
//
//        
//    }
//
//    @Then("Admin should see the last page record on the table with Next page link are disabled")
//    public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
//       
//    }
//
//
//
//   @Given("Admin is on last page of Program table")
//  public void admin_is_on_last_page_of_program_table() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("Admin clicks Previous page link")
//	public void admin_clicks_previous_page_link() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("Admin should see the previous page record on the table with pagination has previous page link")
//	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//
//    @Given("Admin is on Previous Program page")
//    public void admin_is_on_previous_program_page() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("Admin clicks First page link")
//    public void admin_clicks_first_page_link() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("Admin should see the very first page record on the table with Previous page link are disabled")
//    public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//}
package com;


