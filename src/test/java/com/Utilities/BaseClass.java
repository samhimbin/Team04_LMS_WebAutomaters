package com.Utilities;

import java.io.IOException;
import java.util.ArrayList;

import com.pageObjects.BatchPageObject;
import com.pageObjects.DashboardPageObject;
import com.pageObjects.LogOutPageObjects;
import com.pageObjects.LoginPageObject;
import com.pageObjects.ProgramPageObject;


public class BaseClass {

	public static String eXCEL = "src/test/resources/TestData/LMS_data.xlsx";
	public ProgramPageObject programPage;
	public LoginPageObject loginpage;
	public DashboardPageObject dashboard;
	public BatchPageObject batchpage;
	protected PageUtils pageUtils;
	public LogOutPageObjects logOutPage;
	//public UserPageObject userpage;
	
	//Manage Program 
	public static String ExpectedprogramUrl ="https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/";
	//Manage Batch
	public static String expectedBatchUrl ="https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/Managebatch";
	//Logout 
	public static String logOutExpectedUrl="https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/login";
		
	// Extract the data from Excel and return the value as ArrayList
	public static ArrayList<String> excelValue(String sheetName, String testCase) throws IOException {
		LoggerLoad.info("ArrayList excelValuemethod");
		Excelreader ed = new Excelreader();
		ArrayList<String> data = ed.dataDriven(sheetName, testCase);
		System.out.println("PrintvaluesfromExcel"+data);
		return data;
	}
	
	/*
	 * Invoke whenn there is a change to the results in the page
	 * (Number of rows / pages may change based on add / delete operations)
	 */
	public PageUtils getPageUtils(String rowsInfo) {
		pageUtils = new PageUtils(rowsInfo);
		return pageUtils;
	}
	
	/*
	 * Invoke whenn there is no change to the results in the page
	 * 
	 */
	public PageUtils getCurrentPageUtils(String rowsInfo) {
		if (pageUtils == null) {
			return getPageUtils(rowsInfo);
		}
		
		return pageUtils;
	}
	
}
