package com.proj.stepDefinations;

import com.proj.pages.Dashboard;
import com.proj.pages.LoginPage;
import com.proj.util.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
	Dashboard dashboard;
	
	@Given("user opens the url")
	public void user_opens_the_url() {
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");
	}

	@When("user enter the username {string}")
	public void user_enter_the_username(String user) {
		loginpage.enterUsername(user);
	    
	}

	@When("user enters the password {string}")
	public void user_enters_the_password(String pass) {
	    loginpage.enterPassword(pass);
	}
	
	@When("user clicks on submit button")
	public void user_clicks_on_submit_button() {
	    loginpage.clicksOnSubmit();
	}

	@Then("user on dashboard page")
	public void user_on_dashboard_page() {
		System.out.println("user on dashboard page");
	}

}
