package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.LoggerLoad;

public class ProgramPageObject {

	public ProgramPageObject(WebDriver driver) {
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

	@FindBy(xpath = "//span[normalize-space()='LMS - Learning Management System']")
	@CacheLookup
	WebElement dashBoardheader;

	@FindBy(xpath = "//span[@class='mat-button-wrapper']")
	@CacheLookup
	WebElement programButton;

	@FindBy(xpath = "//div[normalize-space()='Manage Program']")
	@CacheLookup
	WebElement manageProgram;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-program[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/div[2]/div[1]")
	@CacheLookup
	WebElement footerMessage;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-program[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/p-paginator[1]/div[1]/span[1]")
	WebElement numberOfRecordstext;

	@FindBy(xpath = "/html/body/app-root/app-program/div/mat-card/mat-card-title/div[2]/div[1]/button")
	WebElement deleteButton;

	@FindBy(id = "filterGlobal")
	WebElement searchBox;

	@FindBy(xpath = "/html/body/app-root/app-program/div/mat-card/mat-card-title/div[2]/div[3]/button/span[2]")
	WebElement addProgramButton;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-program[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]")
	WebElement programNameHeader;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-program[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]")
	WebElement programDescriptionHeader;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-program[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[4]")
	WebElement programStatusHeader;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-program[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[5]")
	WebElement editDeleteHeader;

	// Arrows
	@FindBy(xpath = "/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[2]/p-sorticon/i")
	WebElement programNameArrowIcon;

	@FindBy(xpath = "/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[3]/p-sorticon/i")
	WebElement programDescriptionArrowIcon;

	@FindBy(xpath = "/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[4]/p-sorticon")
	WebElement programStatusArrowIcon;

	@FindBy(xpath = "//div[@class='p-checkbox-box']")
	WebElement checkBox;

	@FindBy(xpath = "//*[@id=\"editProgram\"]/span[2]")
	WebElement editicon;

	@FindBy(xpath = "//*[@id=\"deleteProgram\"]/span[2]")
	WebElement deleteicon;

	public String numberOfRecordstextValidate() {
		return numberOfRecordstext.getText();
	}

	public String getfooterMessage() {
		return footerMessage.getText();
	}

	public void enterUserName(String Uname) {
		username.sendKeys("sdetorganizers@gmail.com");
	}

	public void enterPasswordField(String Pwd) {
		password.sendKeys("UIHackathon@02");
	}

	public void clickOnLoginButton() {
		loginBtn.click();
	}

	public void headerIsDisplayed() {
		dashBoardheader.isDisplayed();
	}

	public void clickOnProgramButton() {
		programButton.click();
	}

	public String manageProgramIsDisplayed() {
		return manageProgram.getText();
	}

	public boolean deleteButtonValidation() {
		return deleteButton.isEnabled();
	}

	public boolean searchBoxValidation() {
		return searchBox.isDisplayed();
	}

	public String addProgramButtonValidation() {
		return addProgramButton.getText();
	}

	public void clickOnaddProgram() {
		addProgramButton.click();
	}

	public String programNameHeaderValidation() {
		return programNameHeader.getText();
	}

	public String programDescriptionHeaderValidation() {
		return programDescriptionHeader.getText();
	}

	public String programStatusHeaderValidation() {
		return programStatusHeader.getText();
	}

	public String editDeleteHeaderValidation() {
		return editDeleteHeader.getText();
	}

	public String programNameArrowIconValidation() {
		return programNameArrowIcon.getText();
	}

	public String programDescriptionArrowIconValidation() {
		return programDescriptionArrowIcon.getText();
	}

	public String programStatusArrowIconValidation() {
		return programStatusArrowIcon.getText();
	}

	public boolean checkBoxValidation() {
		return checkBox.isDisplayed();
	}

	public boolean editiconValidation() {
		return editicon.isDisplayed();
	}

	public boolean deleteiconValidation() {
		return deleteicon.isDisplayed();
	}

}
