package com.DemoMakeMyTrip.stepdefination;

import org.openqa.selenium.WebDriver;

import com.DemoMakeMyTrip.EnviromentData.EnvironmentsData;
import com.DemoMakeMyTrip.Pages_POM.HomePage;
import com.DemoMakeMyTrip.Pages_POM.LoginPage;
import com.DemoMakeMyTrip.Pages_POM.RegistrationPage;
import com.DemoMakeMyTrip.Utilities.TestBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginHomePageSteps extends TestBase
{
	
	RegistrationPage registr;
	LoginPage login ;
	HomePage homepage;
	

	
	//Registraton actions
	
	@When("^Launch the browser and Navigate the URL$")
	public void launch_the_browser_and_Navigate_the_URL() throws Exception {
		TestBase.initialization();
		login=new LoginPage(driver);
		login.loginTrigger();
		Thread.sleep(2000);
	}


	@Then("^Click on the User Register button$")
	public void click_on_the_User_Register_button() {
		registr=new RegistrationPage(driver);
		registr.createnewAccount();
	}

	@Then("^Enter the the User info$")
	public void Enter_the_the_User_info() {
	   registr.emailorMobileNum(prop.getProperty("newregister"));
	   registr.enterPassword(prop.getProperty("password2"));
	}

	@Then("^click on the Register button$")
	public void click_on_the_Register_button() {
	   
	}
	
	
	
	//Login Actions

	@When("^Launch the browser and Navigate the URL and Verify the Welcome Page$")
	public void launch_the_browser_and_Navigate_the_URL_and_Verify_the_Welcome_Page() throws InterruptedException {
		login=new LoginPage(driver);
		TestBase.initialization();
	    String title=login.validateLoginPageTitle();
	    Assert.assertEquals(title, prop.getProperty("homePageTitle"));
	    System.out.println("testing is going on");
	}
	
	
	@Then("^click on the Login button to enter username and password$")
	public void click_on_the_Login_button_to_enter_username_and_password() throws InterruptedException {
		login=new LoginPage(driver);
		login.loginTrigger();
		Thread.sleep(2000);
	}

	@Then("^Enter the Username and Password$")
	public void enter_the_Username_and_Password() throws InterruptedException {
		
		//for time being i am doing hard coded
	    login.username(prop.getProperty("username2"));
	    Thread.sleep(2000);
	    login.continu();
	    login.loginViaPassword();
	    login.sendpassword(prop.getProperty("password2"));
	}

	@Then("^Click on the Login button$")
	public void click_on_the_Login_button() {	 
	 login.login();
	}

	@Then("^Select the one way option from the trip type$")
	public void select_the_one_way_option_from_the_trip_type() throws Exception {
		
		homepage=new HomePage(driver);
		String oneway = homepage.oneway();
		System.out.println("Oneway value is "+oneway);
	
	}

	@Then("^Select the Source and Destination$")
	public void select_the_Source_and_Destination() throws Exception {
		Thread.sleep(3000);
		homepage=new HomePage(driver);
	   homepage.fromPlace();
	   homepage.toPlace();
	}

	@Then("^Select the Departure Date$")
	public void select_the_Departure_Date() throws Exception {
		homepage=new HomePage(driver);
		Thread.sleep(2000);
		homepage.departure();
	}

	@Then("^Select the two passanger$")
	public void select_the_two_passanger() throws Exception {
		homepage=new HomePage(driver);
	 homepage.travellers();
	}

	@Then("^Click on the Search button\\.$")
	public void click_on_the_Search_button() throws Exception {
		homepage=new HomePage(driver);
	   homepage.searchfilgts();
	}

	@Then("^click on the Sort filter and select the Low to high price$")
	public void click_on_the_Sort_filter_and_select_the_Low_to_high_price() throws Exception {
		homepage=new HomePage(driver);
	    homepage.soartprice();
	}

	@Then("^Validate Price is displying in the Sorted order$")
	public void validate_Price_is_displying_in_the_Sorted_order() {
	    
	}

	@Then("^click on the Book now button$")
	public void click_on_the_Book_now_button() throws Exception {
		homepage.booknowlist();
		
	}

	@Then("^click on the Yes the Secure My trip radio button$")
	public void click_on_the_Yes_the_Secure_My_trip_radio_button() throws Exception {
	   homepage.securemytrip();
	}

	@Then("^click on the continue button$")
	public void click_on_the_continue_button() throws Exception {
	   homepage.continuetobook();
	}

	@Then("^Verify the Flight summary$")
	public void verify_the_Flight_summary() {
	 
		String placefromandTo= homepage.flightfromandTo();
		Assert.assertEquals(prop.getProperty("FlightFromAndTo2"), placefromandTo);
		  String departdata=homepage.flightDeparturedate();
		   Assert.assertEquals(prop.getProperty("flightDeparDate"), departdata);
	}

	@Then("^Verify the total amount is displaying$")
	public void verify_the_total_amount_is_displaying() {
		
	 String amount = homepage.TotalAmount();
	 System.out.println();
	}
}
