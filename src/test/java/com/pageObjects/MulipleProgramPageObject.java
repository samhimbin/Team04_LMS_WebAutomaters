package com.pageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.driverFactory.DriverClass;


public class MulipleProgramPageObject {
	
    public MulipleProgramPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
	
    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(id = "login")
    private WebElement btnLogin;

    @FindBy(id = "logout")
    private WebElement btnLogout;
    @FindBy(linkText = "Program")
    private WebElement programLink;

    @FindBy(xpath = "//table[1]/tbody[1]/tr[1]/td[1]//div[1]/div[2]")
    private WebElement programFirstRecordChk;

    @FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']")
    private WebElement commonDeleteButton;

    @FindBy(xpath = "//*[text()='Yes']")
    private WebElement yesButton;

    @FindBy(xpath = "//*[text()='No']")
    private WebElement noButton;

    public void loginPage(String username, String password) {
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public void clickLogout() {
        btnLogout.click();
    }

    public void selectOneProgramChk() {
        programLink.click();
    }

    public String isSelectedProgramChk() {
        String isSelected = programFirstRecordChk.getAttribute("aria-checked");
        System.out.println("Is checkbox selected? " + isSelected);
        return isSelected;
    }

    public boolean isEnabledCommonDeleteBtn() {
        boolean isEnabled = commonDeleteButton.isEnabled();
        System.out.println("isEnabledCommonDeleteBtn? " + isEnabled);
        return isEnabled;
    }

    public void clickCommonDeleteButton() {
        commonDeleteButton.click();
    }

    public void commonDeleteAlertConfirmYes() {
        // Get the current window handle
        String currentWindowHandle = DriverClass.getDriver().getWindowHandle();

        // Get all window handles
        Set<String> allWindowHandles = DriverClass.getDriver().getWindowHandles();

        // Iterate through all handles
        for (String handle : allWindowHandles) {
            // Switch to the window
            DriverClass.getDriver().switchTo().window(handle);
            yesButton.click();
        }

        // Switch back to the original window
        DriverClass.getDriver().switchTo().window(currentWindowHandle);
    }

    public String getProgramHeaderName() {
        // Implement this method to return the header name
        // For example:
        // return programHeader.getText();
        return null;
    }
}
