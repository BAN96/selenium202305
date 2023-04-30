package com.proj.appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.proj.util.ConfigReader;
import com.proj.util.DriverFactiry;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	private ConfigReader configReader;
	private DriverFactiry diverfactory;
	private WebDriver driver;
	Properties prop;
	
	@Before(order=0)
	public void getProperty() {
		configReader=new ConfigReader();
		prop=configReader.initProperties();
	}
	
	@Before(order=1)
	public void launchBrowser() {
		String browser=prop.getProperty("browser");
		diverfactory=new DriverFactiry();
		driver=diverfactory.initWebdriver(browser);
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order=1)
	public void teardwon(Scenario scenario) {
		if (scenario.isFailed()) 
		{
			String screenshotName=scenario.getName().replaceAll(" ", "_");
			byte[] img=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(img, "image/png", screenshotName);
		}
	}
}
