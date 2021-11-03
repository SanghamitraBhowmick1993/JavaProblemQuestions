package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ServiceHomePage;
import com.crm.qa.pages.SetUpPage;
import com.crm.qa.util.TestUtil;

public class ServiceHomePageTest extends TestBase {
	LoginPage loginPage;
	SetUpPage setUp;
	ServiceHomePage serviceHome;
	TestUtil testUtil;
	
	String sheetName = "Account";
	
	public ServiceHomePageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		initilization();
		loginPage= new LoginPage();
		serviceHome= new ServiceHomePage();
		setUp =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		try {
			serviceHome=setUp.clickServiceHome();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException{
		Object [][] dataOne =TestUtil.getTestData(sheetName);
		 return dataOne;
	}
	
	@Test(priority = 1,dataProvider="getCRMTestData")
		public void createAccount(String accNm, String phNum,String accoNm, String rev) throws InterruptedException{		
		String acNmValidate= serviceHome.createAccount(accNm, phNum, accoNm, rev);
		Assert.assertEquals(acNmValidate,accNm);
		
		}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
