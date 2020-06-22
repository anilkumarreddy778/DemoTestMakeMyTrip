package com.DemoMakeMyTrip.Pages_POM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoMakeMyTrip.Utilities.TestBase;

import junit.framework.Assert;

public class HomePage extends TestBase {
	
	@FindBy(className="selected")
	private WebElement oneway;
	
	@FindBy(xpath="//*[@id='fromCity']")
	private WebElement  fromPlace;
	
	@FindBy(xpath="//*[@placeholder='From']")
	private WebElement  placeText;
	
	@FindBy(xpath="//*[.='Bengaluru, India']")
	private WebElement  fromCityName;
	
	@FindBy(xpath="//*[@placeholder='To']")
	private WebElement toText;
	
	@FindBy(xpath="//*[@id='toCity']")
	private WebElement toPlace;
	
	@FindBy(xpath="//*[.='Delhi, India']")
	private WebElement destinationCity;
	////*[@id='departure']
	@FindBy(xpath="//*[@data-cy='departureDate']")
	private WebElement departure;
	//div[@aria-label='Tue Mar 10 2020']//p[.='10']
	@FindBy(xpath="//*[.='10']")
	private WebElement departuredate;
	
	@FindBy(xpath ="//*[@data-cy='travellerText']")
	private WebElement travellers;
	
	@FindBy(xpath ="//ul[@class='guestCounter font12 darkText']//li[@data-cy='adults-2']")
	private WebElement travellerscount;
	
	@FindBy(xpath ="//button[.='APPLY']")
	private WebElement applytravellersdata;
	
	@FindBy(xpath ="//a[.='Search']")
	private WebElement searchfilgts;
	
	@FindBy(xpath ="//span[@class='pointer']//span[@class]/..")
	private WebElement soartprice;
	
	@FindBy(xpath ="//div[@class='pull-left  make_relative price']")
	private List<WebElement> soartpricelist;
	
	
	@FindBy(xpath ="//*[@class='dept-options']//div[4]")
	private List<WebElement> bookvalidationtext;
	
	@FindBy(xpath ="//span[@class='mltfr-arrow arrow-down-icon-white']")
	private List<WebElement> viewfares;
	
	@FindBy(xpath ="//*[.='Book Now']")
	private List<WebElement> booknowlist;
	
	@FindBy(css="body")
	private WebElement tabswtich;
	
	@FindBy(xpath="//*[@class='font20 append_bottom5 LatoLight']")
	private WebElement securetriptext;
	//*[.='I agree to the ']
	@FindBy(xpath ="//*[.='I agree to the ']/..//*[@type='radio']")
	private WebElement securemytripRadio;
	
	
	@FindBy(xpath ="//*[.='ADD']/..//a[.='ADD']")
	private WebElement securemytripADD;
	
	@FindBy(xpath = "//*[@id='review-continue']")
	private WebElement continuetobook;
	
	@FindBy(xpath = "//*[.='Bengaluru - New Delhi']")
	private WebElement flightfromandTo;
	
	
	@FindBy(xpath = "//*[@class='font18']//*[.='Departure Tue, 10 Mar']")
	private WebElement flightDeparturedate;
	
	
	@FindBy(xpath = "//*[.='Total Amount:']/..")
	private WebElement TotalAmount;
	
	public HomePage(WebDriver driver)
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	public String oneway() throws Exception
	{  Thread.sleep(4000);
		String value1 = oneway.getAttribute("class");
		System.out.println(value1);
		Thread.sleep(4000);
		return value1;
	}
	
	public void fromPlace() throws Exception
	{
		Thread.sleep(4000);
		fromPlace.click();
		
		placeText.sendKeys(prop.getProperty("From"));
		Thread.sleep(2000);
		fromCityName.click();
	}
	
	

	public void toPlace() throws Exception
	{
		toPlace.click();
		toText.sendKeys(prop.getProperty("To"));
		Thread.sleep(2000);
		destinationCity.click();
		Thread.sleep(4000);
	}
	
	public void departure() throws Exception
	{

		Thread.sleep(3000);
//		JavascriptExecutor js =(JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click()", departuredate);
		departuredate.click();
		Thread.sleep(2000);
	}
	
	public void travellers() throws Exception
	{
		Thread.sleep(1000);
		travellers.click();
		Thread.sleep(2000);
		travellerscount.click();
		Thread.sleep(2000);
		applytravellersdata.click();
	}
	
	public void searchfilgts() throws Exception
	{
		Thread.sleep(1000);
		searchfilgts.click();
		Thread.sleep(6000);
	}
	
	public void soartprice() throws Exception
	{
		soartprice.click();
		Thread.sleep(2000);
		soartprice.click();
		Thread.sleep(3000);
		soartpricelist.size();
	
		List<String> unsorted=new ArrayList<>();
		for(int i=0; i<soartpricelist.size();i++){
			String value = soartpricelist.get(i).getText();
			unsorted .add(value);
		}
		
		ArrayList<String> sorted =new ArrayList<String>();
		sorted.addAll(unsorted);
		Collections.sort(sorted);
		Assert.assertEquals("Value are not sorted", unsorted,sorted);
		
	}
	
	public void booknowlist() throws Exception
	{
		
		Thread.sleep(4000);
			String text=bookvalidationtext.get(0).getText();
			System.out.println(text+" bookvalidationtext_1232313");
			Thread.sleep(4000);
			if(text.equals("VIEW FARES"))
			{
				System.out.println("-----i am View Fares Label------");
				int vfares = viewfares.size();
				for(int m=0;m<vfares;m++)
				{
					if(m==0)
					{
						viewfares.get(m).click();
					}
				}
				
				int booknowlb = booknowlist.size();
				
				for(int k=0;k<booknowlb;k++)
				{
					if(k==0)
					{
						WebElement bookele=booknowlist.get(k);
						System.out.println(bookele.getText());
						Thread.sleep(4000);
						bookele.click();
					}
				}
			}else if(text.equals("BOOK NOW"))
			{
				System.out.println("-----i am Book Now Label------");
				Thread.sleep(4000);
				int booknowlb = booknowlist.size();
				
				for(int j=0;j<booknowlb;j++)
				{
					if(j==0)
					{
						WebElement bookele=booknowlist.get(j);
						System.out.println(bookele.getText());
						Thread.sleep(4000);
						bookele.click();
					}
				}
			}
			
			
		
				
	}
	
	public void securemytrip() throws Exception
	{
//		ArrayList tabs = new ArrayList (driver.getWindowHandles());
//		driver.switchTo().window(tabs.get(0));
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(3000);
		driver.switchTo().window(tabs2.get(0));
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(2000);
		driver.get(driver.getCurrentUrl());
		
		Thread.sleep(5000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 670);");
		Thread.sleep(4000);
		
		String radiotext=securetriptext.getText();
		
		System.out.println(radiotext);
		Thread.sleep(2000);
		if(radiotext.equals(prop.getProperty("secureradiotext")))
		{
			securemytripRadio.click();
		}else if(radiotext.equals(prop.getProperty("secureaddtext")))
		{
			Thread.sleep(2000);
			securemytripADD.click();
		}

		
	}
	public void continuetobook() throws Exception
	{
		
		Thread.sleep(3000);
		continuetobook.click();
	}
	
	public String flightfromandTo()
	{
		return flightfromandTo.getText();
	}
	
	public String flightDeparturedate()
	{
		return flightDeparturedate.getText();
	}
	
	public String TotalAmount()
	{
		return TotalAmount.getText();
	}
	
	
}
