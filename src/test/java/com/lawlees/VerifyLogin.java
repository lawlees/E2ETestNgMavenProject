package com.lawlees;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.LandingPage;
import pageObject.Login;
import resources.Base;

public class VerifyLogin extends Base{
	
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();	
		log.info("Driver initialized");
	}
	
	@Test(dataProvider="getGoodLoginData")
	public void verifyGoodLogin(String username, String password) throws InterruptedException {
		driver.get(prop.getProperty("url"));
		log.info("Navigated homepage");
		LandingPage l = new LandingPage(driver);
		Login login = new Login(driver);
		
		l.getLogin().click();
		log.info("Clicked login link");
		login.getUsername().sendKeys(username);
		log.info("Input Username");
		login.getPassword().sendKeys(password);
		log.info("Input Password");
		login.getLoginButton().click();
		log.info("Clicked login button");
		String verifyTextString= l.getLogout().getText();
		Assert.assertEquals(verifyTextString, "Log out");
		log.info("Verified Successful login");
		l.getLogout().click();
		log.info("Clicked Logout button");
	}
	
	@Test(dataProvider="getBadLoginData")
	public void verifyBadLogin(String username, String password) throws InterruptedException {
		driver.get(prop.getProperty("url"));
		log.info("Navigated Homepage");
		LandingPage l = new LandingPage(driver);
		Login login = new Login(driver);
		l.getLogin().click();
		log.info("Clicked Login link");
		login.getUsername().sendKeys(username);
		log.info("Input Username");
		login.getPassword().sendKeys(password);
		log.info("Input Password");
		login.getLoginButton().click();
		log.info("Clicked Login Button");
		String verifyTextString= l.getMessageBox().getText();
		Assert.assertTrue(verifyTextString.contains("Your username and password didn't match.Please try again!"));
		log.info("Verified Bad Login");
	}
	
	@DataProvider
	public Object[][] getGoodLoginData(){
		//row = number of different types of data
		//column number of different test
		Object[][] data = new Object[1][2];
		data[0][0]= "lawlees";
		data[0][1]="admin";
		return data;	
	}
	
	@DataProvider
	public Object[][] getBadLoginData(){
		//row = number of different types of data
		//column number of different test
		Object[][] data = new Object[2][2];
		data[0][0]= "incorrect";
		data[0][1]="admin";
		data[1][0]= "lawlees";
		data[1][1]="incorrect";
		return data;	
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
		driver=null;
	}

}
