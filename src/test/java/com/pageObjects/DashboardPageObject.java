package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.RuleMatch;
import org.languagetool.JLanguageTool;
import com.Utilities.LoggerLoad;
import com.driverFactory.DriverClass;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class DashboardPageObject {

	public DashboardPageObject(WebDriver driver) {
		LoggerLoad.info("enter homepage feature");
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[contains(text(),'Manage Program')]")
	WebElement manageProgramHeader;

	@FindBy(xpath = "//mat-toolbar/span[1]")
	WebElement lmsTitle;

	@FindBy(xpath = "//mat-toolbar/button/span[1]")
	List<WebElement> navigationBarOptions;

	@FindBy(xpath = "//app-header")
	WebElement headerNavigationBar;

	@FindBy(xpath = "//span[normalize-space()='LMS - Learning Management System']")
	WebElement spelltext;

	@FindBy(xpath = "//span[normalize-space()='Program']")
	WebElement navigationProgram;

	@FindBy(xpath = "//*[@id=\"batch\"]/span[1]")
	WebElement navigationBatch;

	@FindBy(xpath = "//button[@id='user']")
	WebElement navigationUser;

	@FindBy(xpath = "//button[@id=\"logout\"]")
	WebElement btnLogout;

	public String getHeaderText() {
		return manageProgramHeader.getText();
	}

	public long responseTime() {
		int maxNavigationTime = 30000;
		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();

		long totalTime = endTime - startTime;
		if (totalTime <= maxNavigationTime) {
			System.out.println("Response time is within acceptable limits: " + totalTime + " milliseconds");
		} else {
			System.out.println("Response time exceeds the maximum allowed time: " + totalTime + " milliseconds");
		}
		return totalTime;
	}

	public String getNavigationBarText1() {
		return navigationProgram.getText();
	}

	public String getNavigationBarText2() {
		return navigationBatch.getText();
	}

	public String getNavigationBarText3() {
		return navigationUser.getText();
	}

	public String getNavigationBarText4() {
		return btnLogout.getText();
	}

	// check lms title is present
	public String lmsmanagetitle() {
		return lmsTitle.getText();
	}

	// #5
	public String checkLMStitleAlignment() {

		int logoX = lmsTitle.getLocation().getX();
		int logoY = lmsTitle.getLocation().getY();

		// Get the width of the page
		int pageWidth = (DriverClass.getDriver()).manage().window().getSize().getWidth();

		// Calculate the center position of the page
		int centerX = pageWidth / 2;

		// Determine the alignment based on the position
		String alignment;
		if (logoX < centerX) {
			alignment = "Left";
		} else if (logoX > centerX) {
			alignment = "Right";
		} else {
			alignment = "Center";
		}
		return alignment;

	}

	// #6
	public void spellCheck() throws IOException {
		// Get the text from the WebElement (assuming spelltext is a WebElement
		// representing the text on the web page)
		String pageText = headerNavigationBar.getText();
		System.out.println(pageText);
		// Initialize LanguageTool with American English
		JLanguageTool languageTool = new JLanguageTool(new AmericanEnglish());

		try {
			// Perform spell check on the page text
			List<RuleMatch> errors = languageTool.check(pageText);

			// Output errors
			if (errors.isEmpty()) {
				System.out.println("No spelling mistakes found.");
			} else {
				System.out.println("Spelling mistakes found:");
				for (RuleMatch error : errors) {
					// Print the error message and context
					System.out.println("Potential typo at line " + error.getLine() + ", column " + error.getColumn()
							+ ": " + error.getMessage());
					System.out.println("Context: " + error.getShortMessage());
					System.out.println("Suggested correction: " + error.getSuggestedReplacements());
					System.out.println("---");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// #7
	public void spellCheckForLMStitle() throws IOException {
		// Get the text from the WebElement (assuming spelltext is a WebElement
		// representing the text on the web page)
		String pageText = lmsTitle.getText();
		System.out.println(pageText);
		// Initialize LanguageTool with American English
		JLanguageTool languageTool = new JLanguageTool(new AmericanEnglish());

		try {
			// Perform spell check on the page text
			List<RuleMatch> errors = languageTool.check(pageText);

			// Output errors
			if (errors.isEmpty()) {
				System.out.println("No spelling mistakes found and have correct space .");
			} else {
				System.out.println("Spelling mistakes found:");
				for (RuleMatch error : errors) {
					// Print the error message and context
					System.out.println("Potential typo at line " + error.getLine() + ", column " + error.getColumn()
							+ ": " + error.getMessage());
					System.out.println("Context: " + error.getShortMessage());
					System.out.println("Suggested correction: " + error.getSuggestedReplacements());
					System.out.println("---");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// #8
	public String checkNavigationAlignment() {

		int logoX = navigationProgram.getLocation().getX();
		int logoY = navigationProgram.getLocation().getY();

		// Get the width of the page
		int pageWidth = (DriverClass.getDriver()).manage().window().getSize().getWidth();

		// Calculate the center position of the page
		int centerX = pageWidth / 2;

		// Determine the alignment based on the position
		String alignment;
		if (logoX < centerX) {
			alignment = "Left";
		} else if (logoX > centerX) {
			alignment = "Right";
		} else {
			alignment = "Center";
		}
		return alignment;

	}

	// #9
	public String orderProgramNavigationBar() {
		String option = "";

		for (int i = 0; i < navigationBarOptions.size(); i++) {
			if (navigationBarOptions.get(i).getText().equalsIgnoreCase("Program")) {
				option = (i + 1) + "st Program";
				break;
			}
		}

		return option;
	}

	// #10
	public String orderBatchNavigationBar() {
		String option = "";

		for (int i = 0; i < navigationBarOptions.size(); i++) {
			if (navigationBarOptions.get(i).getText().equalsIgnoreCase("Batch")) {
				option = "Batch";
				break;
			}
		}

		return option;
	}

	// #11
	public String orderUserNavigationBar() {
		String option = "";

		for (int i = 0; i < navigationBarOptions.size(); i++) {
			 if (navigationBarOptions.get(i).getText().equalsIgnoreCase("User")) {
				option = "User";
				break;
			} 
		}

		return option;
	}
	
	// #12
		public String orderLogoutNavigationBar() {
			String option = "";

			for (int i = 0; i < navigationBarOptions.size(); i++) {
				 if (navigationBarOptions.get(i).getText().equalsIgnoreCase("Logout")) {
					option ="Logout";
					break;
				}
			}

			return option;
		}
}
