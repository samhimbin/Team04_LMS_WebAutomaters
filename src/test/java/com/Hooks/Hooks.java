package com.Hooks;

import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Utilities.LoggerLoad;
import com.driverFactory.DriverClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {
	
	@Before(order = 0)
	public static void setUp() throws IOException {
		DriverClass.setUpDriver();
		LoggerLoad.info("driver setup");
	}

	@Before(order = 1)
	public static void setup2() {
		DriverClass.getDriver();
		LoggerLoad.info("getdriver");
	}

	@After
	public static void tearDown(Scenario scenario) throws IOException {
		
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) DriverClass.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}

		//DriverClass.tearDown();
	}
}
