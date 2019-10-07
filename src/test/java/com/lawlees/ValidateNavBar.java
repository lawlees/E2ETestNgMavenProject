package com.lawlees;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import junit.framework.Assert;
import pageObject.LandingPage;
import resources.Base;

public class ValidateNavBar extends Base{
		
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();	
		log.info("Driver Initialized");
	}
	
	
	@Test
	public void validateNav() throws InterruptedException {
		
		driver.get(prop.getProperty("url"));
		log.info("HomePage Navigated");
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavBar().isDisplayed());
		log.info("Validated Nav Bar");
		Thread.sleep(1000);
		
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
		driver=null;
	}
	
}
