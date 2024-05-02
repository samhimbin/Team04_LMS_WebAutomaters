
package com.pageObjects;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.LoggerLoad;
import com.driverFactory.DriverClass;

public class UserPageObject 
{
    private WebDriver driver;

	public UserPageObject(WebDriver driver) 
	{
		LoggerLoad.info("Entered User Feature");
       // this.driver = driver;

		PageFactory.initElements(driver, this);
	}

  
	@FindBy(id = "user")
	WebElement userButton;
	
	@FindBy(xpath = ("//div[contains(text(), \"Manage User\")]"))
	WebElement headerString;
	
	@FindBy(xpath = "//p-paginator/div/span[contains(text(), 'Showing')]")
    List<WebElement> paginationString;
	
	@FindBy(xpath = "//*[contains(@class, 'p-paginator-next')]")
    private WebElement paginationNextIcon;

    @FindBy(xpath = "//*[contains(@class, 'p-paginator-last')]")
    private WebElement paginationLastIcon;

    @FindBy(xpath = "//*[contains(@class, 'p-paginator-first')]")
    private WebElement paginationFirstIcon;

    @FindBy(xpath = "//*[contains(@class, 'p-paginator-prev')]")
    private WebElement paginationPrevIcon;

    @FindBy(xpath = "//table[@role = 'grid']")
    private WebElement userDataTable;

    @FindBy(tagName = "th")
    private List<WebElement> tableHeaders;
    
    @FindBy(xpath = "//div[@class='box']//button[@icon='pi pi-trash']")
    private WebElement deleteButton;
    
    @FindBy(xpath = "//button[@label='Add New User']")
    private WebElement addNewUserButton;

    @FindBy(xpath = "//button[@label='Assign Student']")
    private WebElement assignStudentButton;

    @FindBy(xpath = "//button[@label='Assign Staff']")
    private WebElement assignStaffButton;
	
    @FindBy(xpath = "//table[@role=\"grid\"]")
    private WebElement dataTable;

    @FindBy(xpath = "//i[@class=\"pi pi-search\"]")
    private WebElement searchIcon;

    @FindBy(xpath = "//table[@role='grid']/tbody/tr")
    private List<WebElement> dataRows;
    
    @FindBy(id = "filterGlobal")
    private WebElement searchBox;
    
    @FindBy(xpath = "//tbody/tr/td[3]")
    private List<WebElement> userElements;
    
    @FindBy(xpath = "//div[@role='dialog']")
    private WebElement popup;

    @FindBy(xpath = "//button[@label='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[@label='Cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//span[@id='pr_id_7-label']/../div/button")
    private WebElement closeButton;
    
    @FindBy(id = "roleId")
    private WebElement userRoleField;

    @FindBy(id = "userId")
    private WebElement studentEmailIdField;

    @FindBy(id = "programName")
    private WebElement programNameField;

    @FindBy(id = "batchName")
    private WebElement batchNameField;

    @FindBy(xpath = "//div[@class='radio']")
    private WebElement statusField;
    
    @FindBy(id = "Active")
    private WebElement activeRadioButton;

    @FindBy(id = "Inactive")
    private WebElement inactiveRadioButton;
    
    @FindBy(xpath = "//div[contains(text(), 'User Email Id is required.')]")
    private WebElement errorMessage;

//    @FindBy(xpath = "//button[@label='Cancel']")
//    private WebElement cancelButton;

    @FindBy(id = "userId")
    private WebElement emailIdDropdown;
    
//    @FindBy(xpath = "//p-dropdown[@id='userId']")
//    private WebElement userIdDropdown;

    @FindBy(xpath = "//p-dropdown[@formcontrolname=\"userId\"]//div[3]//input")
    private WebElement emailListBox;

    @FindBy(xpath = "//p-dropdown[@id=\"userId\"]//li")
    private WebElement emailSelection;
    
    @FindBy(xpath = "//p-dropdown[@id='programName']")
    private WebElement programIdDropdown;

    @FindBy(xpath = "//p-dropdownitem/li[@aria-label='Team3 Program']")
    private WebElement programSelection;
    
    @FindBy(xpath = "//p-dropdown[@id='batchName']")
    private WebElement batchIdDropdown;

    @FindBy(xpath = "//p-dropdownitem/li[@aria-label='Team3 Batch']")
    private WebElement batchSelection;
    
    @FindBy(xpath = "//div[@role='alert']/div/div[2]")
    private WebElement assignStudentSuccessMessage;

   
    
    public void clickUserButton() 
    {
        userButton.click();
    }
    
    public WebElement getHeaderString() 
    {
        return headerString;
    }
        
    public List<WebElement> getPaginationString() 
    {
        return paginationString;
    }

    public boolean isPaginationNextIconDisplayed() 
    {
        return paginationNextIcon.isDisplayed();
    }

    public boolean isPaginationLastIconDisplayed() 
    {
        return paginationLastIcon.isDisplayed();
    }

    public boolean isPaginationFirstIconDisplayed() 
    {
        return paginationFirstIcon.isDisplayed();
    }

    public boolean isPaginationPrevIconDisplayed() 
    {
        return paginationPrevIcon.isDisplayed();
    }
    
    public WebElement getUserDataTable() 
    {
        return userDataTable;
    }

    public List<WebElement> getTableHeaders() 
    {
        return tableHeaders;
    }
	
    public WebElement getDeleteButton() 
    {
        return deleteButton;
    }
    public WebElement getAddNewUserButton() 
    {
        return addNewUserButton;
    }

    public WebElement getAssignStudentButton() 
    {
        return assignStudentButton;
    }

    public WebElement getAssignStaffButton() 
    {
        return assignStaffButton;
    }
    
    public WebElement getDataTable() 
    {
        return dataTable;
    }

    public WebElement getSearchIcon() 
    {
        return searchIcon;
    }
    
    public int getDataTableRowCount() 
    {
        return dataTable.findElements(By.tagName("tr")).size() - 1; // Subtracting header row
    }
    
    public boolean areCheckboxesPresentInAllRows() 
    {
        for (WebElement row : dataRows) 
        {
            List<WebElement> checkboxes = row.findElements(By.xpath(".//input[@type='checkbox']"));
            if (checkboxes.isEmpty()) 
            {
                return false; // If any row doesn't have a checkbox, return false
            }
        }
        return true; // All rows have checkboxes
    }
    
    public boolean areEditIconsEnabledInAllRows() 
    {
        for (WebElement row : dataRows) 
        {
            WebElement editIcon = row.findElement(By.xpath(".//button[@icon='pi pi-pencil']"));
            if (!editIcon.isEnabled()) 
            {
                return false; // If any edit icon is not enabled, return false
            }
        }
        return true; // All edit icons are enabled
    }
    
    public boolean areDeleteIconsEnabledInAllRows() 
    {
        for (WebElement row : dataRows) 
        {
            WebElement deleteIcon = row.findElement(By.xpath(".//button[@icon='pi pi-trash']"));
            if (!deleteIcon.isEnabled()) {
                return false; // If any delete icon is not enabled, return false
            }
        }
        return true; // All delete icons are enabled
    }

    public void enterSearchText(String searchText) 
    {
        searchBox.clear(); // Clear the search box before entering a new value
        searchBox.sendKeys(searchText);
    }

    public int getMatchingUserCount() 
    {
        String enteredName = searchBox.getAttribute("value").trim();
        System.out.println("The name of the user to be searched is " + enteredName);

        int userCount = 0;
        // Iterate over each user element
        for (WebElement userElement : userElements) 
        {
            // Get the text of the user name element
            String userName = userElement.getText().trim();
            System.out.println("User exists with name " + userName);
            String[] splitName = userName.split("\\s+");
            String firstName = splitName[0].trim();

            // Check if the user name matches the entered name
            if (firstName.equalsIgnoreCase(enteredName)) 
            {
                // Increment user count if user found
                userCount++;
            }
        }
        System.out.println("Total number of users found: " + userCount);
        return userCount;
    }
    
    public void enterKeywordInSearchBox(String keyWord) 
    {
        searchBox.clear(); // Clear the search box before entering a new value
        searchBox.sendKeys(keyWord);
    }
    
    public void verifyNoEntriesDisplayed() 
    {
        String enteredName = searchBox.getAttribute("value").trim();
        System.out.println("The name of the user to be searched is " + enteredName);
        if (userElements.isEmpty()) 
        {
            System.out.println("No user with the entered name was found");
        }
    }
    
    public void clickButton(String buttonName) throws InterruptedException 
    {
        WebElement button = driver.findElement(By.xpath("//button[@label='" + buttonName + "']"));
        // Click the button
        Thread.sleep(1000);
        button.click();
    }
    
    public void verifyPopupDisplayed() 
    {
        assert popup.isDisplayed() : "Pop up window is not displayed";
    }

    public void verifyEmptyForm() {
        // Logic to verify the form inside the pop up is empty
    }

    public void verifySaveAndCancelButton() 
    {
        assert saveButton.isDisplayed() : "Save button is not present";
        assert cancelButton.isDisplayed() : "Cancel button is not present";
    }
    public void verifyCloseButton() 
    {
        assert closeButton.isDisplayed() : "Close (X) icon is not present";
    }
    
    public void verifyUserRole(String expectedUserRole) 
    {
        assert userRoleField.getAttribute("value").equals(expectedUserRole) : "User Role field does not have the expected value: " + expectedUserRole;
    }

    public void verifyOtherFields() 
    {
        assert studentEmailIdField.isDisplayed() : "Student Email id field is not present";
        assert programNameField.isDisplayed() : "Program Name field is not present";
        assert batchNameField.isDisplayed() : "Batch Name field is not present";
        assert statusField.isDisplayed() : "Status field is not present";
    }
    
    public boolean isStatusRadioButtonsDisplayed() 
    {
        return activeRadioButton.isDisplayed() && inactiveRadioButton.isDisplayed();
    }
    
    public void clickSaveButton() 
    {
       // WebElement saveButton = driver.findElement(By.xpath("//button[@label=\'" + buttonName + "\']"));
        saveButton.click();
    }
    
    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }
    
    public void verifyNoOptionSelected() {
        WebElement selectedOption = emailIdDropdown.findElement(By.className("p-dropdown-label"));
        assertEquals("Select Email ID", selectedOption.getText().trim());
    }
    
    public void verifyErrorMessageAlert(String errorMessage) {
        try {
            WebElement errorMessageAlert = driver.findElement(By.xpath("//div[@class='ng-star-inserted' and contains(text(),'" + errorMessage + "')]"));
            assertTrue("Error message alert is not displayed", errorMessageAlert.isDisplayed());
            System.out.println("Error message alert: " + errorMessageAlert.getText());
        } catch (NoSuchElementException e) {
            System.err.println("Error message alert element not found: " + errorMessage);
        } catch (AssertionError e) {
            System.err.println("Error message alert verification failed: " + e.getMessage());
        } finally {
            WebElement cancelButton = driver.findElement(By.xpath("//button[@label='Cancel']"));
            cancelButton.click();
        }
    }
    
    public void clickButtonWithoutSelectingProgram(String buttonName) throws InterruptedException {
        System.out.println("Now I am trying to test the blank program field");

        try 
        {
            Thread.sleep(3000);
            emailIdDropdown.click();
            Thread.sleep(3000);
            emailListBox.sendKeys("seleniumsquad.squadsquad354@gmail.com");
            Thread.sleep(2000);
            emailSelection.click();
            saveButton.click();
        } 
        catch (NoSuchElementException e) 
        {
            System.out.println("Error: Email ID dropdown element not found");
            e.printStackTrace();
        }
    }

    public void clickButtonWithoutSelectingBatch(String buttonName) throws InterruptedException {

        Thread.sleep(3000);

        // Click on the email ID dropdown to open the options
        emailIdDropdown.click();
        Thread.sleep(1000);

        // Enter email ID
        emailListBox.sendKeys("seleniumsquad.squadsquad354@gmail.com");

        // Wait for the options to become visible
        Thread.sleep(1000);
        emailSelection.click();
        Thread.sleep(1000);

        // Click on the program dropdown to open the options
        programIdDropdown.click();
        Thread.sleep(1000);

        // Select a program
        programSelection.click();
        Thread.sleep(1000);

        // Click the button
        WebElement saveButton = driver.findElement(By.xpath("//button[@label= '" + buttonName + "']"));
        saveButton.click();
        Thread.sleep(3000);
    }
    
    public void clickButtonWithoutGivingStatus(String buttonName) throws InterruptedException 
    {
        Thread.sleep(1000);

        // Click on the email ID dropdown to open the options
        emailIdDropdown.click();
        Thread.sleep(1000);
        emailListBox.sendKeys("seleniumsquad.squadsquad354@gmail.com");
        Thread.sleep(1000);
        emailSelection.click();
        Thread.sleep(1000);

        // Click on the program dropdown to open the options
        programIdDropdown.click();
        Thread.sleep(1000);

        // Select a program
        programSelection.click();
        Thread.sleep(2000);

        // Click on the batch dropdown to open the options
        batchIdDropdown.click();
        Thread.sleep(1000);

        // Select a batch
        batchSelection.click();
        Thread.sleep(2000);

        // Click the button
        saveButton.click();
        Thread.sleep(2000);
    }

    public boolean isassignStudentSuccessMessageDisplayed() 
    {
        try 
        {
            return assignStudentSuccessMessage.isDisplayed(); // Return true if success message is displayed
        } 
        catch (NoSuchElementException e) 
        {
            return false; // Return false if success message is not found
        }
    }

    public void clickCloseButton() 
    {
        closeButton.click();
        
     }
    
    public void selectEmail() throws InterruptedException 
    {
    	 emailIdDropdown.click();
    	 Thread.sleep(1000);
    	 emailListBox.sendKeys("seleniumsquad.squadsquad354@gmail.com");
    	 Thread.sleep(1000);
    	 emailSelection.click();
    	 Thread.sleep(1000);
    }

    public void selectProgram() throws InterruptedException 
    {
    	// Click on the program dropdown to open the options
        programIdDropdown.click();
        Thread.sleep(1000);

        // Select a program
        programSelection.click();
        Thread.sleep(2000);
     }

    public void selectBatch() throws InterruptedException 
    {
    	// Click on the batch dropdown to open the options
        batchIdDropdown.click();
        Thread.sleep(1000);

        // Select a batch
        batchSelection.click();
        Thread.sleep(2000);
    }

    public void selectStatus() {
    	activeRadioButton.click();
    }

    
}
    
    

