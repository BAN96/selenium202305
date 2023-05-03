package com.proj.stepDefinations;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.proj.pages.Dashboard;
import com.proj.pages.LoginPage;
import com.proj.pages.PIMpage;
import com.proj.util.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardSteps {
	private LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
	private Dashboard dashboard;
	String pageHeader;
	private PIMpage pimpage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
		
		List<Map<String, String>> credTable=dataTable.asMaps();
		String username=credTable.get(0).get("username");
		String password=credTable.get(0).get("password");
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");
		dashboard=loginpage.loginToApp(username, password);
	}

	@When("user get the page title")
	public void user_get_the_page_title() {
		pageHeader=dashboard.getPageHeader();
		System.out.println("pageHeader");
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String pageheading) {
	    Assert.assertTrue(pageHeader.equals(pageheading));
	}

	@When("user clicks on PIM in side menu")
	public void user_clicks_on_pim_in_side_menu() {
		pimpage=dashboard.clickOnPIM();
	}

	@Then("user on PIM Page")
	public void user_on_pim_page() {
	    System.out.println("user on PIM Page");
	}

}
