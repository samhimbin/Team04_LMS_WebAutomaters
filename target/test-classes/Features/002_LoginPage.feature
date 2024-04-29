@login
Feature: Homepage verification

	Background:
    Given Admin gives the correct LMS portal URL
       
    #22  
    Scenario Outline: Validate login with null password
    Given Admin is in Home Page
    When Admin enter value only in username using "<SheetName>" and <rowNumber>
    And clicks login button
    Then Error message for null password " Please enter your password " 

    Examples: 
      | SheetName  | rowNumber |
      | Login |   3 |
      
    #21  
    Scenario Outline: Validate login with null username
    Given Admin is in Home Page
    When Admin enter value only in password using "<SheetName>" and <rowNumber>
    And clicks login button
    Then Error message for null username " Please enter your user name "

    Examples: 
      | SheetName  | rowNumber |
      | Login |   2 |
      
    #20  
    Scenario Outline: Validate login with invalid credentials
    Given Admin is in Home Page
    When Admin enter invalid credentials from "<SheetName>" and <rowNumber>
    And clicks login button
    Then Error message for "Invalid username and password Please try again" 

    Examples: 
      | SheetName  | rowNumber |
      | Login |   1 |
      
    #19
    Scenario Outline: Validate login with valid Credentials 
    Given Admin is in Home Page
    When Admin enter valid credentials from "<SheetName>" and <rowNumber>
    And clicks login button 
    Then Admin should land on dashboard page

    Examples: 
      | SheetName  | rowNumber |
      | Login |   0 |
      
    #24
    Scenario Outline: verify login button action through mouse
    Given Admin is in Home Page
    When Admin enter valid credentials from "<SheetName>" and <rowNumber>
    And clicks login button through mouse 
    Then Admin should land on dashboard page

    Examples: 
      | SheetName  | rowNumber |
      | Login |   0 |
      
    #23
    Scenario Outline: verify login button action through Keyboard
    Given Admin is in Home Page
    When Admin enter valid credentials from "<SheetName>" and <rowNumber>
    And clicks login button through keyboard 
    Then Admin should land on dashboard page

    Examples: 
      | SheetName  | rowNumber |
      | Login |   0 |
    