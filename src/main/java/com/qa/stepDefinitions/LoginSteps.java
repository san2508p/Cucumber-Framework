package com.qa.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.Pages.LoginPage;
import com.qa.util.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	
	public WebDriver driver;
	LoginPage loginObj;
	
	
	@Given("^User opens Chrome browser$")
	public void user_opens_Chrome_browser() throws Throwable {
	    BaseClass.setup();
	    
	}

	@When("^User enter username and password and login$")
	public void user_enter_username_and_password_and_login() throws Throwable {
		loginObj= new LoginPage();
		loginObj.ValidLogin();
	}

	@Then("^user clicks on Login button$")
	public void user_clicks_on_Login_button() throws Throwable {
	   System.out.println("one");
	}
     @Test
	@Then("^validate user login successfully$")
	public void validate_user_login_successfully() throws Throwable {
    	   System.out.println("one");
	}
	
	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  BaseClass.TearDown();
	}
	
	
	@When("^User enter invalid username and password and login$")
	public void user_enter_invalid_username_and_password_and_login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginObj= new LoginPage();
		loginObj.inValidLogin();
	   
	}

	@Then("^validate user not able to logged$")
	public void validate_user_not_able_to_logged() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	
	
	

}
