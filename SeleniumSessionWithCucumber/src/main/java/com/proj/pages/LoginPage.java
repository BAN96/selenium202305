package com.proj.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	Dashboard dashboard;
	
	@FindBy(xpath="//input[@name='username']") private WebElement username;
	@FindBy(name="password") private WebElement password;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver,this);;
	}
	
	public Dashboard loginToApp(String user,String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		password.submit();
		return new Dashboard(driver);
	}
	
	public void enterUsername(String user) {
		username.sendKeys(user);
	}
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	public Dashboard clicksOnSubmit() {
		password.submit();
		return new Dashboard(driver);
	}
	

}
