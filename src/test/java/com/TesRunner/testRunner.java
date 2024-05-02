package com.TesRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/LMS.html",  //cucumber reports
				"json:target/LMS.json",
				"rerun:target/rerun.txt"  ,//mandatory for capture failures 
				//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", //Extent Reports
				//"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"		
		},//reporting purpose-- html reports are created
		monochrome=false,  //console output color and eliminate junk characters
		//dryRun=false, // (=true)->compilation purpose mostly to chk stepdefinitions are implemented or not
			//tags="@portal or @login or @dash",	
		features = {
				//"src/test/resources/Features/007_MultipleProgramDelete.feature"
				//"src/test/resources/Features/002_LoginPage.feature",
				//"src/test/resources/Features/004_ManageProgram.feature",
				//"src/test/resources/Features/009_DeleteProgram.feature",
				//"src/test/resources/Features/005_ManageBatch.feature",
				//"src/test/resources/Features/007_Multiple.feature".
				//"src/test/resources/Features/015_LogOut.feature"
				"src/test/resources/Features"
				}, //location of feature files, we can give this way-->".//features//"
		glue= {"com.stepDefinitions","com.Hooks"}) //location of step definition files, gives granural level of info in test result

public class testRunner {

}
