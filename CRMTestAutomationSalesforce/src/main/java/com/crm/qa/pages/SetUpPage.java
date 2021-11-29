package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class SetUpPage extends TestBase {
	@FindBy(xpath="//*[@class='slds-icon-waffle']") WebElement appLauncher;
	@FindBy(xpath="//p[text()='Service']") WebElement serviceClick;
	

//initializing page objects
	public SetUpPage(){
		PageFactory.initElements(driver, this);
	}
	//Actions
	public ServiceHomePage clickServiceHome() throws InterruptedException{
		appLauncher.click();
		Thread.sleep(5000);
		serviceClick.click();
		Thread.sleep(8000);
		return new ServiceHomePage();
	}
	
	
	
	
}