package com.DemoMakeMyTrip.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.DemoMakeMyTrip.EnviromentData.EnvironmentsData;





public class TestBase {
	
	public  static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase()
	{
		this.driver=driver;
		
		try{
			prop=new Properties();
			FileInputStream file =new FileInputStream(EnvironmentsData.Xpath_property);
			prop.load(file);
		}
		catch(IOException e){
			
			e.getMessage();	
		}
	}
	
	
	
	
	public static void initialization() throws InterruptedException 
	{
	String Browsername=EnvironmentsData.browser;
	
	if(Browsername.equals("chrome"))
	{
		System.setProperty(EnvironmentsData.Chrome_key, EnvironmentsData.Chrome_value);
		Thread.sleep(2000);
		driver =new ChromeDriver();
	}else if (Browsername.equals("FF"))
	{
		System.setProperty(EnvironmentsData.FF_key, EnvironmentsData.FF_value);
		Thread.sleep(3000);
		driver = new FirefoxDriver();
	}
	
	driver.get(EnvironmentsData.url);
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(EnvironmentsData.pageload, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(EnvironmentsData.implictwait, TimeUnit.SECONDS);
	
	}

}
