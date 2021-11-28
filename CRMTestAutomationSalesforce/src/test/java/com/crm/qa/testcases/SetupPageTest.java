package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ServiceHomePage;
import com.crm.qa.pages.SetUpPage;

public class SetupPageTest extends TestBase {
	LoginPage loginPage;
	SetUpPage setUp;
	ServiceHomePage serviceHome;
	
	public SetupPageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		initilization();
		loginPage= new LoginPage();
		setUp =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void serviceClick() throws InterruptedException{
		serviceHome=setUp.clickServiceHome();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
