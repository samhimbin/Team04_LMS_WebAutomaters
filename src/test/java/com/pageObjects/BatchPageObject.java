package com.pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Random;

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
	
	
	
	@FindBy(xpath="//*[@id='pr_id_5-label']") 
	static WebElement bacthDetailsBtn;
	@FindBy(xpath="//app-batch/p-dialog/div/div/div[2]/div[1]") 
	static WebElement popupName;
	@FindBy(xpath="app-batch/p-dialog/div/div/div[2]/div[3]/label") 
	static WebElement programName;
	@FindBy(xpath="//*[@id='batchName']") 
	static WebElement bacthName;
	@FindBy(id="programName") 
	static List<WebElement> programNameAddBatch;
	//@FindBy(xpath="app-batch/p-dialog/div/div/div[2]/div[3]/p-dropdown/div/div[2]/span") static List<WebElement> programNameAddBatch;
	@FindBy(xpath="app-batch/p-dialog/div/div/div[2]/div[4]/div[2]/p-radiobutton/div/div[2]") 
	static WebElement activeRadioBtn;
	@FindBy(xpath="app-batch/p-dialog/div/div/div[3]/button[2]") 
	static WebElement saveBtn;
	@FindBy(xpath="//div[@class= 'action']/span[2]")  
	static WebElement rowDeleteBtn;
//	@FindBy(xpath="//span[@class='p-button-label' and text()='Yes']") 
//	static WebElement  yesBtn;
	
	@FindBy(xpath="//p-confirmdialog/div/div/div[3]/button[2]/span[2]")
	static WebElement  yesBtn;
	//@FindBy(xpath="//span[text()=’No’]") static WebElement  noBtn;
	@FindBy(xpath="//*[text()='No']") 
	static WebElement  noBtn;
	//@FindBy(xpath="//span[@class='p-button-label' and text()='No']") static WebElement  noBtn;
	@FindBy(xpath="//*[@id='filterGlobal']") 
	static WebElement batchsearch;
	@FindBy(xpath="//div[@role = 'checkbox']")
	static WebElement checkboxBtn;
	@FindBy(xpath="//div[@role = 'checkbox']")
	static List<WebElement> checkboxBtn1;
	
	

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
	
	
	
	
	
	
public WebElement batchDetails() {
    	
    	return programName;
    }
    
    public void batchNameFunction() {
    	
    	
    	bacthName.sendKeys("Batch");
    	
    }
    
    public void selectActiveFunction() {
        
        activeRadioBtn.click();
        
        }
        
        public void saveFunction() {
        	saveBtn.click();
        	
        }
        public void rowDeleteFunction() {
        	rowDeleteBtn.click();
        }
        
        public void batchDeleteYes() {
        	yesBtn.click();
        }	

        public void batchDeleteNo() {
            	noBtn.click();
        }

        public void batchserachfunction() {
        	batchsearch.click();
        	batchsearch.sendKeys("a23");
    }
        
        public void checkboxFunction() {
        	
        	
        	boolean isSelected = checkboxBtn.isSelected();
            
            // Assert the checkbox status
            if (isSelected) {
                System.out.println("Checkbox is selected");
            } else {
            	
                System.out.println("Checkbox is not selected");
                
            }
            
        } 
            
            public void  selectOnlyOneRow() {
            	
                Random random = new Random();
                
                // Generate a random number between 1 and 5 (inclusive)
                int randomNumber = random.nextInt(5) + 1;
            	
            	
            	List<WebElement> rows = checkboxBtn1;
            	rows.get(randomNumber).click();
            	String rowMessage =  rows.get(randomNumber).getText();
            	System.out.println(" Selected random number: " + randomNumber);
            	
            	System.out.println("Deleted row is : " + randomNumber);
            	
            }
            
            public void disabledDeleteFunctiontoDelete() {
            	
            	disabledDeleteBtn.click();
            }
            
            public void  selectMultiRow() {
            	
            
            	List<WebElement> rows = checkboxBtn1;
               Random random = new Random();
                
                // Generate a random number between 1 and 5 (inclusive)
                int randomNumber = random.nextInt(5) + 1;
            	
            	if (rows.size() >= 2) {
                    // Select the first two rows
                    for (int i = 0; i < 2; i++) {
                        rows.get(randomNumber).click(); // Click to select the row
                        // Add additional logic if needed, such as waiting or verifying selection
                    }
                } else {
                    System.out.println("Not enough rows to select.");
                    // Handle the case wh
            	
            	}
            	
            }
        
}
