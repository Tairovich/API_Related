package com.app.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

	private static Properties prop;
	
	static {
		
		try {
			String path = "configuration.properties";
			FileInputStream fis = new FileInputStream(path);
			
			prop = new Properties();
			
			prop.load(fis);
			fis.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static String getProperty(String keyName) {
		return prop.getProperty(keyName);
	}
}

