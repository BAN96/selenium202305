package com.proj.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.remote.Browser;

public class ConfigReader {
	
	private Properties prop;
	
	public Properties initProperties() {
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("./src/test/resources/com/config/config.properties");
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
