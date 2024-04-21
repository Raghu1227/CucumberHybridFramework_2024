package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public Properties intializeProperties() throws IOException {
		
		Properties prop=new Properties();
		File proFile=new File(System.getProperty("user.dir")+"\\config\\config.properties");
		FileInputStream fis=new FileInputStream(proFile);
		prop.load(fis);
		return prop;
	}
	
}
