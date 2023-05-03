package com.proj.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.proj.util.DriverFactory;

public class Dashboard {
	
	private WebDriver driver;
	
	@FindBy(xpath="//h6") private WebElement pageHeader;
	@FindBy(xpath="//a[contains(@class,'oxd-main-menu-item')]//span[text()='PIM']") private WebElement PIM;
	
	public Dashboard(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public String getPageHeader() {
		return pageHeader.getText().trim();
		
	}
	
	public PIMpage clickOnPIM() {
		PIM.click();
		return new PIMpage(driver);
	}

}
