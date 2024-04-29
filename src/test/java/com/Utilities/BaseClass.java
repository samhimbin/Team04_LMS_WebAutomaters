package com.Utilities;

import java.io.IOException;
import java.util.ArrayList;

import com.pageObjects.BatchPageObject;
import com.pageObjects.DashboardPageObject;
import com.pageObjects.LoginPageObject;
import com.pageObjects.ProgramPageObject;


public class BaseClass {

	public static String eXCEL = ".\\src/test/resources/TestData/LMS_data.xlsx";
	public ProgramPageObject programpage;
	public LoginPageObject loginpage;
	public DashboardPageObject dashboard;
	public BatchPageObject batchpage;
	
	//Manage Program 
	public static String ExpectedprogramUrl ="https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/program";
	//Manage Batch
	public static String expectedBatchUrl ="https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/Managebatch";
		
	// Extract the data from Excel and return the value as ArrayList
		public static ArrayList<String> excelValue(String sheetName, String testCase) throws IOException {
			LoggerLoad.info("ArrayList excelValuemethod");
			Excelreader ed = new Excelreader();
			ArrayList<String> data = ed.dataDriven(sheetName, testCase);
			System.out.println("PrintvaluesfromExcel"+data);
			return data;
		}
	
		
}
