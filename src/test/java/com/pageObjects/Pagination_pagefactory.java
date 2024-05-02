package com.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pagination_pagefactory {
	 WebDriver driver;
	 private By programnutton=By.xpath("//button[@id='program']");
	private By nextBtn = By.xpath("//button[@class='p-paginator-next p-paginator-element p-link p-ripple']");
	private By lastBtn = By.xpath("//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']");
	private By prevBtn = By.xpath("//button[@class='p-paginator-prev p-paginator-element p-link p-ripple']");
	private By firstBtn = By.xpath("//button[@class='p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted']");
	
	
	public String getProgramHeaderName() {
		driver.findElement(programnutton).click();
		return null;
	}
	public void clickNextLink()
	{
		driver.findElement(nextBtn).click();
	}
	

	public boolean isActiveNextLink()
	{
        // Wait for the table to reload with the next page records
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));

		
//        // Find the disabled element using JavaScript Executor
//        WebElement nextBtn = (WebElement) ((JavascriptExecutor) driver)
//                .executeScript("return document.getElementsByClassName('p-paginator-next p-paginator-element p-link p-ripple');");
		// Check if the next page button is enabled
//        boolean isNextEnabled = nextBtn.isEnabled();
//        boolean isNextEnabled = driver.findElement(nextBtn).isEnabled();
//        boolean isNextEnabled = !driver.findElement(nextBtn).getAttribute("class").contains("disabled");
//        System.out.println("isNextEnabled "+isNextEnabled);  
        boolean isNextEnabled;
        List<WebElement> elements = driver.findElements(nextBtn);
        if (!elements.isEmpty()) {
            WebElement button = elements.get(0);
            isNextEnabled = button.isEnabled();
            // Perform actions on the button
        } else {
        	
            // Element not found, handle accordingly
        	isNextEnabled = false;
        }

        return isNextEnabled;

//        // Verify that the "Next" link in the pagination is active
//        WebElement nextPageActiveLink = driver.findElement(By.xpath("//a[@class='next-page-link' and @aria-disabled='false']"));
//        // Perform assertions or further verification on the "Next" active link
	}
	public void clicklastbutton()
	{
		driver.findElement(lastBtn).click();
	}
	public void clickpreviousbutton()
	{
		driver.findElement(prevBtn).click();
	}
	public void clickfirstbutton()
	{
		driver.findElement(firstBtn).click();
	}

	
	
}
   
    
//    @FindBy(xpath = "//*[contains(text(),'Manage Program')]")////button[@id='program']
//    WebElement programHeaderName;
//    
//    @FindBy(id = "Del2")
//    List<WebElement> nameprogram;
//
//    @FindBy(xpath = "//button[normalize-space()='2']")
//    WebElement nextlink;
//
//    public Pagination_pagefactory(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//
//    public String getProgramHeaderName() {
//        return programHeaderName.getText();
//    }
//
//    public List<WebElement> clickNameprogram() {
//        return nameprogram;
//    }
//
////    public  clickNextPageLink() {
////        
////		return nextlink.click();;
////    }
//
//    public String getActiveLinkText() {
//        WebElement activeLink = nextlink.findElement(By.xpath(".//a[@class='active']"));
//        return activeLink.getText();
//    }
//}
