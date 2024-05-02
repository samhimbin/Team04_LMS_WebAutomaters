package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPageObjects {
	
	
	 @FindBy(xpath = "//button[@id=\"logout\"]")
	    private static  WebElement btnLogout;
	 
	 public LogOutPageObjects(WebDriver driver) {
	       
	        PageFactory.initElements(driver, this);
	    }

	
	    public static void clickLogout() {
	     btnLogout.click();
	    }

}
