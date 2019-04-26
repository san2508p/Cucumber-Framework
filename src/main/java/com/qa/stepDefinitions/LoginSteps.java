package com.qa.stepDefinitions;

import org.openqa.selenium.WebDriver;

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
	   
	}

	@Then("^validate user login successfully$")
	public void validate_user_login_successfully() throws Throwable {
	    
	}
	
	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  BaseClass.TearDown();
	}

	
	
	

}
