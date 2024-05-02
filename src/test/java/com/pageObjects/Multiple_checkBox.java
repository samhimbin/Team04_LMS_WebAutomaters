package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Set;

public class Multiple_checkBox {
     WebDriver driver;
    public Multiple_checkBox(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/app-root/app-header/mat-toolbar/button[1]/span[1]")
    @CacheLookup
     WebElement programLink;

    @FindBy(xpath = "//table[1]/tbody[1]/tr[1]/td[1]//div[1]/div[2]")
    @CacheLookup
     WebElement programFirstRecordChk;

    @FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']")
    @CacheLookup
     WebElement commonDeleteButton;

    @FindBy(xpath = "//*[text()='Yes']")
    @CacheLookup
    private WebElement yesButton;

    @FindBy(xpath = "//*[text()='No']")
    @CacheLookup
    private WebElement noButton;

    
    

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

