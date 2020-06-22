package com.DemoMakeMyTrip.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".\\src\\main\\java\\com\\DemoMakeMyTrip\\features"},
		glue= {"com.DemoMakeMyTrip.stepdefination"},
		dryRun=false,
		monochrome=true,
		tags= {"@Login_Testing"},
		plugin= {"pretty","json:target/cucumber-reports/cucumber.json"})

public class TestRunner {
		//oneway selecing assert getting faile
		//departure date selecting issue -- if if run single it's working
		//price sorting verfication
		
		//safe way trip selecting issue inconstinfd
}
