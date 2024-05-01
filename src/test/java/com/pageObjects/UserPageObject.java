package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.LoggerLoad;

public class UserPageObject {
	
	public UserPageObject(WebDriver driver) {
		LoggerLoad.info("entered Manage Program feature");
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	@CacheLookup
	WebElement username;

	@FindBy(id = "password")
	@CacheLookup
	WebElement password;

	@FindBy(id = "login")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(id = "user")
	@CacheLookup
	WebElement UserBtn;
	
	@FindBy(xpath = "//div[normalize-space()='Manage Program']")
	@CacheLookup
	static
	WebElement manageProgram;
	
	@FindBy(id = "new")
	@CacheLookup
	static
	WebElement addNewBtn;
	
	
	@FindBy(xpath = "/html/body/app-root/app-program/div/mat-card/mat-card-title/div[2]/div[3]/button/span[2]")
	WebElement addUserButton;
	
	
	@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[1]/div/div")
	WebElement popupwindow;
	

	@FindBy(xpath = "//*[@id=\"pr_id_53-label\"]")
	WebElement userdetailstitle;
	
	
	@FindBy(id= "d='mat-input-28")
	@CacheLookup
	static
	WebElement firstname;
	
	@FindBy(id= "mat-input-139\"]")
	@CacheLookup
	static
	WebElement middlename;
	
	@FindBy(xpath="//*[@id=\"mat-input-140\"]")
	@CacheLookup
	static
	WebElement lastname;
	
	@FindBy(xpath="//*[@id=\"mat-input-141\"]")
	@CacheLookup
	static
	WebElement locationname;
	
	@FindBy(xpath="//*[@id=\"mat-input-142\"]")
	@CacheLookup
	static
	WebElement phonenum;
	
	@FindBy(xpath = "//*[@id=\"mat-input-143\"]")
	@CacheLookup
	static
	WebElement linkedin;
	
	@FindBy(xpath = "//label[normalize-space()='User Role']")
	@CacheLookup
	static
	WebElement userrole;
	
	
	@FindBy(xpath = "//label[normalize-space()='User Role Status']")
	@CacheLookup
	static
	WebElement userrolestatus;
	
	@FindBy(xpath = "//label[normalize-space()='User Visa Status']")
	@CacheLookup
	static
	WebElement uservisastatus;
	
	@FindBy(xpath = "//*[@id=\"mat-input-144\"]")
	@CacheLookup
	static
	WebElement emailid;
	
	@FindBy(xpath="//*[@id=\"mat-input-145\"]")
	@CacheLookup
	static
	WebElement undergraduate;
	
	@FindBy(xpath="//*[@id=\"mat-input-146\"]")
	@CacheLookup
	static
	WebElement postgraduate;
	
	@FindBy(xpath="//*[@id=\"mat-input-147\"]")
	@CacheLookup
	static
	WebElement timezone;
	
	
	@FindBy(xpath="//*[@id=\"mat-input-148\"]")
	@CacheLookup
	static
	WebElement usercomments;
	
	@FindBy(xpath="/html/body/app-root/app-user/div/p-dialog[1]/div/div/div[2]/form/mat-card/mat-card-actions/button[1]/span[1]")
	@CacheLookup
	static
	WebElement cancelbtn;
	
	
	@FindBy(xpath = "/html/body/app-root/app-user/div/p-dialog[1]/div/div/div[2]/form/mat-card/mat-card-actions/button[2]/span[1]")
	@CacheLookup
	static
	WebElement savebtn;
	
	@FindBy(xpath ="/html/body/app-root/app-user/div/p-dialog[1]/div/div/div[1]/div/button")
	@CacheLookup
	static
	WebElement closebtn;
	
	
	public void enterUserName(String Uname) {
		username.sendKeys("sdetorganizers@gmail.com");
	}

	public void enterPasswordField(String Pwd) {
		password.sendKeys("UIHackathon@02");
	}

	public void clickOnLoginButton() {
		loginBtn.click();
	}
	public void clickOnProgramButton() {
		UserBtn.click();
	}
	
    public static String manageProgramIsDisplayed() {
		return manageProgram.getText();
	}
	
	public static void clickaddNewBtn() {
		addNewBtn.click();
	}
	public String checkfirstname() {
		 return firstname.getText();
	}
	public void popwindow() {
		popupwindow.click();
		
	}
	public  void userDetailsTitle() {
		userdetailstitle.getText();
		
		
	}

}
