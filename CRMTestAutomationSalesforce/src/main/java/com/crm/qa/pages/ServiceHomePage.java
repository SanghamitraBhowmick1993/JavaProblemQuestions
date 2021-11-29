package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ServiceHomePage extends TestBase{
	Actions actions = new Actions(driver);

	@FindBy(xpath="//a//span[text()='Accounts']") WebElement accountsClick;
	@FindBy(xpath="//div[@title='New']") WebElement newClick;
	@FindBy(xpath="//div[@class='slds-modal__header']//h2") WebElement newAccountTitle;
	@FindBy(xpath="//input[contains(@id,'input') and @name='Name']") WebElement AccountName;
	@FindBy(xpath="//input[contains(@id,'input') and @name='Phone']") WebElement PhoneNumber;
	@FindBy(xpath="//input[contains(@id,'input') and @name='AccountNumber']") WebElement AccountNumber;
	@FindBy(xpath="//input[contains(@id,'input') and @name='AnnualRevenue']") WebElement AnnualRevenue;
	@FindBy(xpath="//button[@name='SaveEdit' and @type='button']") WebElement Save;
	@FindBy(xpath="//span[@class='custom-truncate uiOutputText']") WebElement validateAcNm;
	
	//initializing page objects
		public ServiceHomePage(){
			PageFactory.initElements(driver, this);
		}
		//Actions
		public String verifyServicePageTitle(){
			return driver.getTitle();
		}
		public String createAccount(String accountName,String phoneNum,String accNum,String annualRevenue) throws InterruptedException{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", accountsClick);
			newClick.click();
			Thread.sleep(3000);			
			try {
				Action accNm = actions.moveToElement(AccountName).click().sendKeys(accountName).build();
				accNm.perform();
			} catch (Exception e) {
				AccountName.sendKeys(accountName);
			}
			try {
				Action ph = actions.moveToElement(PhoneNumber).click().sendKeys(phoneNum).build();
				ph.perform();
			} catch (Exception e) {
				PhoneNumber.sendKeys(phoneNum);
			}
			try {
				Action accNumr = actions.moveToElement(AccountNumber).click().sendKeys(accNum).build();
				accNumr.perform();
			} catch (Exception e) {
				AccountNumber.sendKeys(accNum);
			}
			js.executeScript("window.scrollBy(0,250)", "");
			try {
				Action annRev = actions.moveToElement(AnnualRevenue).click().sendKeys(annualRevenue).build();
				annRev.perform();
			} catch (Exception e) {
				AnnualRevenue.sendKeys(annualRevenue);
			}
			try{
			Save.click();
			}catch(Exception e){
				js.executeScript("arguments[0].click();", Save);

			}
			return validateAcNm.getText();

		}
}
