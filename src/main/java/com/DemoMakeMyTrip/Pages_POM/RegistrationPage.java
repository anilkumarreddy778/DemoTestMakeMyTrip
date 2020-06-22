package com.DemoMakeMyTrip.Pages_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoMakeMyTrip.Utilities.TestBase;

public class RegistrationPage extends TestBase {
	
	@FindBy(xpath="//*[.=' Create New Account ']")
	private WebElement  createnewAccount;
	
	@FindBy(xpath="//*[@id='emailOrPhone']")
	private WebElement emailorMobileNum;
	
	@FindBy(xpath="//*[@id='password']")
	private WebElement enterPassword;
	
	
	@FindBy(xpath="//*[.='Verify Number & Create Account']//span")
	private WebElement verifyandregister;

	
	//initializing the page object
		public RegistrationPage(WebDriver driver){
			super();
			PageFactory.initElements(driver, this);	
		}
		
		public void createnewAccount()
		{
			createnewAccount.click();
		}
		
		public void emailorMobileNum(String username)
		{
			emailorMobileNum.sendKeys(username);
		}
		
		public void enterPassword(String newpassword)
		{
			enterPassword.sendKeys(newpassword);
		}
		
		public void verifyandregister()
		{
			verifyandregister.click();
		}
}
