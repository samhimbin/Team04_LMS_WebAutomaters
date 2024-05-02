package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navi {
    private WebDriver driver;
    
    @FindBy(xpath = "/html/body/app-root/app-header/mat-toolbar/button[1]/span[1]")
    private WebElement checkBoxButton;

    public Navi(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCheckBoxButton() {
        checkBoxButton.click();
    }

    // Method to get X location of the checkbox button
    public int getCheckBoxButtonXLocation() {
        return checkBoxButton.getLocation().getX();
    }
}
