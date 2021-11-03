package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ChatterPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ServiceHomePage;
import com.crm.qa.pages.SetUpPage;
import com.crm.qa.util.TestUtil;

public class ChatterPageTest extends TestBase {
	LoginPage loginPage;
	SetUpPage setUp;
	ServiceHomePage serviceHome;
	TestUtil testUtil;
	ChatterPage chatterPage;
	
	public ChatterPageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		initilization();
		loginPage= new LoginPage();
		serviceHome= new ServiceHomePage();
		chatterPage = new ChatterPage();
		setUp =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		try {
			serviceHome=setUp.clickServiceHome();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 1)
	public void validateHyperLinkinChatter(){
		boolean flag = chatterPage.validateHyperlinks();
		Assert.assertTrue(flag);
	}
	@Test(priority = 2)
	public void createPollTest() throws InterruptedException{
		String actual = chatterPage.createPoll();
		Assert.assertEquals(actual, "Is Salesforce Trailhead a good option?");
	}
	@Test(priority = 3)
	public void validateAllLinksTest() throws InterruptedException{
		chatterPage.validateAllLinks();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
