package com.shopping.demo.StepDefinition;

import com.shopping.demo.pages.Login.LoginBasePage;
import com.shopping.demo.pages.Login.LoginPageAndroid;

import cucumber.api.Scenario;

import freemarker.log.Logger;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ScenarioHooks{
	LoginBasePage login = new LoginPageAndroid();
@Before
public void beforeScenario(Scenario scenario){
	Logger.getLogger("Before scenario :" + scenario.getName() + "tag:" + scenario.getSourceTagNames());
	
}

@After
public void afterScenario(Scenario scenario){
	Logger.getLogger("After scenario :" + scenario.getName() + "tag:" + scenario.getStatus());
	Logger.getLogger("Time: " + java.time.LocalTime.now());
	
	try{
		if(scenario.getSourceTagNames().contains("@LogOut")){
			login.logOut();
			Logger.getLogger("Logging out of the application");
		}
	}
	
	catch(Exception e){
		Logger.getLogger("There is error in Scenario Hooks");
	}
	
}
}
