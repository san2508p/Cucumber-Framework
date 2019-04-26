package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() throws IOException{
		File src=new File("./Config/Config.properties");
		FileInputStream fis= new FileInputStream(src);
		pro= new Properties();
		pro.load(fis);
	}
	
	public  String getDatafromConfig(String Key){
		
		return pro.getProperty(Key);
		
	}

	public  String getBrowser(){
		return pro.getProperty("Browser");
	}
	
	public  String getURL(){
		return pro.getProperty("URL");
	}
}
