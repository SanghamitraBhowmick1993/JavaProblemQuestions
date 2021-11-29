package com.crm.qa.pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ChatterPage extends TestBase{
	Actions action = new Actions(driver);

	@FindBy(xpath="//a//span[text()='Chatter']") WebElement chatterClick;
	@FindBy(xpath="//ul[@class='forceChatterFeedAnchorSubMenu']//li//a") WebElement hyperLinksinChatter;
	@FindBy(xpath="//span[@class='title' and text()='Poll']") WebElement pollClick;
	@FindBy(xpath="//textarea[@role='textbox']") WebElement pollQuestionTextBox;
	@FindBy(xpath="//label//span[text()='Choice 1']//parent::label//parent::div//input") WebElement option1;
	@FindBy(xpath="//label//span[text()='Choice 2']//parent::label//parent::div//input") WebElement option2;
	@FindBy(xpath="//button[@type='button' and text()='Ask']") WebElement clickAsk;
	@FindBy(xpath="(//span[@class='uiOutputText'])[3]") WebElement pollCreated;


	//initializing page objects
			public ChatterPage(){
				PageFactory.initElements(driver, this);
			}
	//Actions
	public boolean validateHyperlinks(){
		try{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", chatterClick);
		Thread.sleep(3000);
		}catch(Exception e){
			chatterClick.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		List<WebElement> allLinks = driver.findElements(By.xpath("//ul[@class='forceChatterFeedAnchorSubMenu']//li//a"));
		boolean flag = false;
		for(int i = 0;i<allLinks.size(); i++){
			allLinks.get(i).getText();
			 if(allLinks.size()==5)
				 flag = true;			 
		}		
		return flag;
		
	}
	public String createPoll() throws InterruptedException{
		try{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", chatterClick);
			Thread.sleep(3000);
			}catch(Exception e){
				chatterClick.click();
				Thread.sleep(3000);
			}
		pollClick.click();
		action.moveToElement(pollQuestionTextBox).click().sendKeys("Is Salesforce Trailhead a good option?").build().perform();
		action.moveToElement(option1).click().sendKeys("Yes").build().perform();
		action.moveToElement(option2).click().sendKeys("No").build().perform();
		clickAsk.click();
		Thread.sleep(3000);
		return pollCreated.getText();
	}
	public void validateAllLinks(){
		validateHyperlinks();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		List<String> urlList = new ArrayList<String>();
		for(WebElement e : links){
			String url = e.getAttribute("href");
			urlList.add(url);
			checkBrokenLink(url);
		}
	}
	public static void checkBrokenLink(String linkUrl){
		try{
			URL url = new URL(linkUrl);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();
			if(httpUrlConnection.getResponseCode()>=400){
				System.out.println(linkUrl + "---->" + httpUrlConnection.getResponseMessage() + "is a broken link");
			}
			else{
				System.out.println(linkUrl + "---->" + httpUrlConnection.getResponseMessage());
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
