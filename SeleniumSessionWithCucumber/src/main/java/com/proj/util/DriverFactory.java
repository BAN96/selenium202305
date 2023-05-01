package com.proj.util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return 
	 * @return this will return tldriver.
	 */
	public WebDriver initWebdriver(String browser) {
		System.out.println("browser value is: "+browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("ff")) {
			tlDriver.set(new FirefoxDriver());
		}
		else {
			System.out.println("select the browser from these options only: /n chrome /n ff");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return getDriver();
	}
	
	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
