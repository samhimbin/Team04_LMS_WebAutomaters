package com.TesRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html:target/LMS_Report.html", //cucumber report
		//"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		"json:target/cucumber-reports/cucumber.json",
//		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", //Extent Reports
//		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"		
		}, // reporting purpose
		monochrome = false, // console output color
				//tags="",
				features = {"src/test/resources/Features/"},
						glue= {"com.stepDefinitions","com.Hooks"})
public class TestNgTestRunner extends AbstractTestNGCucumberTests {

}
