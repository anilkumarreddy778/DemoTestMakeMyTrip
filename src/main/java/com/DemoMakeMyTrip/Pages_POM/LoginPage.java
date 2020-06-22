package com.DemoMakeMyTrip.Pages_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoMakeMyTrip.Utilities.TestBase;



public class LoginPage extends TestBase
{

	
	
	//Page Factory - 	
	@FindBy(xpath="//*[.=' Login or Create Account']")
	private WebElement loginTrigger;
	
	@FindBy(xpath="//input[@class='font14 fullWidth']")
	private WebElement  username;
	
	@FindBy(xpath="(//*[.='Continue'])[2]")
	private WebElement continu;
	
	@FindBy(xpath="//a[.='or Login via Password']")
	private WebElement loginViaPassword;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath ="//button[@class='capText font16']//span[.='Login']/..")
	private WebElement loginbutton;
	
	
	//initializing the page object
	public LoginPage(WebDriver driver){
		super();
		PageFactory.initElements(driver, this);	
	}
	
	
	//Actions
	public String validateLoginPageTitle()
	{
		
		return driver.getTitle();
	}
	
	public void loginTrigger()
	{
		loginTrigger.click();
		System.out.println("click on logintrigger");
	}
	
	public void username(String user)
	{
		username.sendKeys(user);
	}
	
	public void continu() throws InterruptedException
	{
		username.click();
//		JavascriptExecutor js =(JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click()", continu);
//		try { Thread.sleep(15000);}
//		catch (InterruptedException e) {System.out.println("error.......");}
		Thread.sleep(10000);
	//	driver.findElement(By.xpath("//a[.=' Create New Account ']")).click();
		continu.click();
		Thread.sleep(15000);
	}
	
	public void loginViaPassword()
	{
		loginViaPassword.click();
	}
	
	public void sendpassword(String passwor)
	{
		password.sendKeys(passwor);
	}
	
	public void login()
	{
		loginbutton.click();
	}
	
	
}
