package com.pageObjects;

import java.util.List;

import javax.imageio.ImageIO;

import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.RuleMatch;
import org.languagetool.JLanguageTool; 
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import java.net.HttpURLConnection;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.Utilities.LoggerLoad;
import com.driverFactory.DriverClass;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class LoginPageObject {

	public LoginPageObject(WebDriver driver) {

		LoggerLoad.info("enter homepage feature");
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "username")WebElement username;
	@FindBy(id = "password")WebElement password;
	@FindBy(id = "login")WebElement loginbutton;
	@FindBy(id = "errormessage")WebElement errMessage;
	@FindBy(xpath = "//div/mat-error[@id='mat-error-0']")WebElement blankUser;
	@FindBy(xpath = "//div/mat-error[@id='mat-error-1']")WebElement blankPassword;
	@FindBy(tagName = "a")List<WebElement> urlLinks;
	@FindBy(xpath = "//form/mat-form-field/div//input")	List<WebElement> numberOfTextfields;
	@FindBy(xpath = "//form/p")	WebElement signInPhrase;
	@FindBy(xpath = "//img")WebElement image;
	@FindBy(xpath = "//div/span/label/span[2]")	WebElement asteriskAtFirstField;
	@FindBy(xpath = "//label[@id='mat-form-field-label-3']/span[2]")WebElement asteriskAtSecondField;
	@FindBy(xpath = "//body")WebElement spelltext;
    @FindBy(css = ".mat-card-content")WebElement formElement;
    @FindBy(xpath = "//div[@class='signin-content']")WebElement signInContent;
    @FindBy(xpath = "//form")WebElement form;
	
	public void enterUsernamePasswrd(String givenusrname, String givenpasswrd) {
		username.sendKeys(givenusrname);
		password.sendKeys(givenpasswrd);
	}

	public void loginbtnclk() {
		loginbutton.click();
	}

	public String getErrorMessage() {
		return errMessage.getText();
	}

	public String BlankUserMessage() {
		return blankUser.getText();
	}

	public String BlankPasswordMessage() {
		return blankPassword.getText();
	}
    public void clickOnFormElement() {
    	formElement.click();
    }
	public List<WebElement> getStatuscode() throws MalformedURLException, IOException {

		List<WebElement> urls = urlLinks;
		return urls;
	}

	public List<WebElement> getTotal_noOf_inputFields() {
		return numberOfTextfields;
	}

	public String getSignInContent() {
		return signInPhrase.getText();
	}
    
	//#5+
	public boolean checkLogoImage() {
		String imagesource = image.getAttribute("src");
		if (!imagesource.isBlank()) {
			return true;
		} else {
			return false;
		}
	}
    
	//#5
	public String checkLogoAlignment() {
		
		int logoX = image.getLocation().getX();
		int logoY = image.getLocation().getY();
		
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

	public String checkFirstTextField() {
		return username.getAttribute("data-placeholder");
	}

	public String checkSecondTextField() {
		return password.getAttribute("data-placeholder");
	}

	public String CheckAstericFirstTextfield() {
		return asteriskAtFirstField.getText();
	}

	public String CheckAstericSecondTextfield() {
		return asteriskAtSecondField.getText();
	}

	public boolean checkLoginButton() {
		return loginbutton.isDisplayed();
	}
	
    //#2
	public boolean getResponseCode() {
		
		// Execute JavaScript to check for 404 errors in the Network tab
		boolean has404Errors = (Boolean) ((JavascriptExecutor) DriverClass.getDriver()).executeScript(
				"return (function() {" + "   var entries = window.performance.getEntriesByType('resource');"
						+ "   for (var i = 0; i < entries.length; i++) {"
						+ "       if (entries[i].response && entries[i].response.status === 404) {"
						+ "           return true;" + "       }" + "   }" + "   return false;" + "})();");

		return has404Errors;
	}
    //#24
	public void mouseClickLoginButton() {
		Actions act = new Actions(DriverClass.getDriver());
		act.click(loginbutton).perform();
	}
    //#23
	public void keyBoardClickLoginButton() {
		loginbutton.sendKeys(Keys.ENTER);
	}
	//#4
	public void spellCheck() throws IOException {
	    // Get the text from the WebElement (assuming spelltext is a WebElement representing the text on the web page)
	    String pageText = spelltext.getText();
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
	                System.out.println("Potential typo at line " + error.getLine() + ", column " + error.getColumn() + ": " + error.getMessage());
	                System.out.println("Context: " + error.getShortMessage());
	                System.out.println("Suggested correction: " + error.getSuggestedReplacements());
	                System.out.println("---");
	            }
	        }
	    } catch (IOException e) {
	       	        e.printStackTrace();
	    }
	}
	//#14
	public String alignmentOfInputFields() {
		
		// Get positions of input fields
	    int field1X = username.getLocation().getX();
	    int field2X = password.getLocation().getX();

	    // Get width of the SignInContent
	    int signInContentWidth = signInContent.getSize().getWidth();

	    // Calculate the center X coordinate of the SignInContent
	    int centerX = signInContent.getLocation().getX() + signInContentWidth / 2;

	    // Determine the alignment based on the position
	    String alignment;
	    if (field1X < centerX && field2X < centerX) {
	        alignment = "Left";
	    } else if (field1X > centerX && field2X > centerX) {
	        alignment = "Right";
	    } else {
	        alignment = "Center";
	    }
	    return alignment;

	}
	//#16
	public String alignmentOfLoginButton() {
		
		// Get the coordinates of the form
        int formX = formElement.getLocation().getX();
        int formY = formElement.getLocation().getY();
        int formWidth = formElement.getSize().getWidth();
        int formHeight = formElement.getSize().getHeight();
        
     // Calculate the center coordinates of the form
        int centerX = formX + (formWidth / 2);
        int centerY = formY + (formHeight / 2);

        // Get the coordinates of the button
        int buttonX = loginbutton.getLocation().getX();
        int buttonY = loginbutton.getLocation().getY();
                
     // Determine the alignment of the button within the form
        String alignment;
        if (buttonX < centerX) {
            alignment = "Left";
        } else if (buttonX > centerX) {
            alignment = "Right";
        } else {
            alignment = "Center";
        }

        return alignment;
	}
    //#6 and #7
	public String ImageTextExtraction() throws IOException {
		
			String extractedText ="";
			
			// Capture screenshot of the webpage
	        File screenshotFile = ((TakesScreenshot)DriverClass.getDriver()).getScreenshotAs(OutputType.FILE);

	        // Get the location and dimensions of the image element
	        int x = image.getLocation().getX();
	        int y = image.getLocation().getY();
	        int width = image.getSize().getWidth();
	        int height = image.getSize().getHeight();

	        // Crop the screenshot to include only the image element
	        BufferedImage fullImage = ImageIO.read(screenshotFile);
	        BufferedImage croppedImage = fullImage.getSubimage(x, y, width, height);

	        // Save the cropped image to a file
	        File croppedFile = new File("cropped_image.png");
	        ImageIO.write(croppedImage, "png", croppedFile);

	        // Perform OCR using Tesseract
	        ITesseract tesseract = new Tesseract();
	        tesseract.setDatapath("/path/to/tessdata/directory");
	        
	        try {
	            extractedText = tesseract.doOCR(croppedFile);
	            System.out.println("Extracted Text: " + extractedText);
	        } catch (TesseractException e) {
	            System.err.println("Error during OCR: " + e.getMessage());
	        }
			
			return extractedText;

	    }
	//#17
	public String colorOfUserTextField() {
		String color = username.getCssValue("color");
		return color;
	}
	//#18
	public String colorOfPasswordTextField() {
		String color = password.getCssValue("color");
		return color;
	}
	
	//#3
	public int checkBrokenLink() throws MalformedURLException, IOException {
		List<WebElement> urls = urlLinks;
	    int brokenLinksCount = 0; // Counter for broken links
	    for (int i = 0; i < urls.size(); i++) {
	        String nameOfUrl = urls.get(i).getAttribute("href");
	        HttpURLConnection conn = (HttpURLConnection) new URL(nameOfUrl).openConnection();
	        conn.setRequestMethod("HEAD");
	        conn.connect();
	        int responsecode = conn.getResponseCode();
	        System.out.println(responsecode);
	        if (responsecode >= 400) {
	            System.out.println("Broken link: " + urls.get(i).getText() + " - " + responsecode);
	            brokenLinksCount++; // Increment the broken links count
	        }
	    }
	    return brokenLinksCount;
	}
	
	//#2
	public int getStatusCode() throws MalformedURLException, IOException {
		int responsecode=0;
		List<WebElement> urls = urlLinks;
		for (int i = 0; i < urls.size(); i++) {
	        String nameOfUrl = urls.get(i).getAttribute("href");
	        HttpURLConnection conn = (HttpURLConnection) new URL(nameOfUrl).openConnection();
	        conn.setRequestMethod("HEAD");
	        conn.connect();
	        responsecode = conn.getResponseCode();
	        System.out.println(responsecode);
	        if (responsecode == 404) {
	            System.out.println("Error Not Found: " + urls.get(i).getText() + " - " + responsecode);
	           
	        }
	    }
	    return responsecode;
	}
}
