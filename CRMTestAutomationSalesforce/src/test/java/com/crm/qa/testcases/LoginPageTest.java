package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.SetUpPage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	SetUpPage setupPage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initilization();
		loginPage= new LoginPage();
	}
	@Test(priority = 1)
	public void loginPageTitleTest(){
		String title =loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login | Salesforce");
	}
	
	@Test(priority = 2)
		public void salesforceLogoTest(){
			boolean flag = loginPage.validateSalesforceLogo();
			Assert.assertTrue(flag);
		}	

	
	@Test(priority = 3)
	public void loginTest(){
		setupPage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
