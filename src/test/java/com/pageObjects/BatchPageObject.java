package com.pageObjects;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.LoggerLoad;
import com.driverFactory.DriverClass;

public class BatchPageObject {

	public BatchPageObject(WebDriver driver) {
		LoggerLoad.info("entered Dashboard feature");
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "batch")
	static WebElement batchBtn;
	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-title/div[1]")
	WebElement manageBatchText;
	@FindBy(xpath = "//p-paginator/div/button[1]/span")
	WebElement paginationText;
	@FindBy(xpath = "//p-table/div/div[1]/table/thead/tr")
	WebElement batchDataTable;
	@FindBy(xpath = "//mat-card-title/div[2]/div[1]/button/span[1]")
	WebElement disabledDeleteBtn;
	@FindBy(xpath = "//mat-card-title/div[2]/div[3]/button/span[2]")
	WebElement newBatchBtn;
	@FindBy(xpath = "//table/thead/tr/th[1]/p-tableheadercheckbox/div/div[2]")
	WebElement checkBoxBtn;
	@FindBy(xpath = "//p-table/div/div[1]/table/tbody/tr[1]/td[7]/div/span[1]/button/span[1]")
	WebElement editIconBtn;
	@FindBy(xpath = "//p-table/div/div[1]/table/tbody/tr[1]/td[7]/div/span[2]/button/span[1]")
	WebElement deleteIconBtn;

	public void clickBatchBtn() {
		batchBtn.click();
	}

	public String findCurrentUrl() {

		String currentUrlBatch = (DriverClass.getDriver()).getCurrentUrl();
		System.out.println("BatchUrl: " + currentUrlBatch);
		return currentUrlBatch;

	}

	public String manageBatchFunction() {

		String manageText = manageBatchText.getText();
		return manageText;

	}

	public String paginationFinder() {
		String pageText1 = paginationText.getText();
		return pageText1;

	}

	public String batchTableData() {

		String batchTableTexts = batchDataTable.getText();
		return batchTableTexts;

	}

	public boolean disabledDeleteFunction() {

		return disabledDeleteBtn.isDisplayed();
	}

	public boolean addNewButtonFunction() {

		return newBatchBtn.isDisplayed();
	}

	public boolean checkBoxFunction() {
		return checkBoxBtn.isDisplayed();

	}

	public boolean editIconFunction() {
		return editIconBtn.isDisplayed();

	}

	public boolean deleteIconFunction() {
		return deleteIconBtn.isDisplayed();

	}

	public void newBatchAlertFunction() {
		newBatchBtn.click();

	}

	public String alertDisplyFunction() {
		
		Alert alert = (DriverClass.getDriver()).switchTo().alert();
		String alertText = alert.getText();
		return alertText;
		
	}
}
