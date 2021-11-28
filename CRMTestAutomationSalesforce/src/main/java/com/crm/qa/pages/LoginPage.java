package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory or OR:
	@FindBy(name="username") WebElement usernm;
	@FindBy(name="pw") WebElement passwrd;
	@FindBy(name="Login") WebElement logIn;
	@FindBy(xpath="//img[@id='logo']") WebElement salesforceLogo;
	@FindBy(id="forgot_password_link") WebElement forgotpwd;

	//initializing page objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	public boolean validateSalesforceLogo(){
		return salesforceLogo.isDisplayed();
	}
	public SetUpPage login(String um,String pwd){
		usernm.sendKeys(um);
		passwrd.sendKeys(pwd);
		logIn.click();
		return new SetUpPage();
	}
}
