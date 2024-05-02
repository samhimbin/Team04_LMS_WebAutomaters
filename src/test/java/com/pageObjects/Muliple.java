package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Set;

public class Muliple {
    private WebDriver driver;
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

    @FindBy(xpath = "//tbody[@class='p-datatable-tbody']//tr[@class='ng-star-inserted'][1]//following-sibling::td[1]")//table[1]/tbody[1]/tr[1]/td[1]//div[1]/div[2]
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


   
    public Muliple(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public void selectOneProgramChk() {
//        programLink.click();
    

    public String SelectedProgramChk() {
        String Selected = programFirstRecordChk.getAttribute("aria-checked");
        System.out.println("Is checkbox selected? " + Selected);
        return Selected;
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
        String currentWindowHandle = driver.getWindowHandle();

        // Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Iterate through all handles
        for (String handle : allWindowHandles) {
            // Switch to the window
            driver.switchTo().window(handle);
            yesButton.click();
        }

        // Switch back to the original window
        driver.switchTo().window(currentWindowHandle);
    }

    public String getProgramHeaderName() {
        // Implement this method to return the header name
        // For example:
        // return programHeader.getText();
        return null;
    }

	
}
