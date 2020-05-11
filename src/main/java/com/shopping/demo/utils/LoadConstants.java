package com.shopping.demo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class LoadConstants{
	
	static Properties prop;
	
	public static String[] loadConstants(String objectName, String propertyFileName) throws IOException{
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\com\\shopping\\demo\\Resources\\objectRepository\\android";
		prop = loadProperty(filePath, propertyFileName);
		String objectValue = prop.getProperty(objectName);
		String[] objectSplit = objectValue.split("=");
		return objectSplit;
	}
	
	public static Properties loadProperty(String Filepath, String FileName) throws IOException{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(Filepath+FileName);
		prop.load(fis);
		return prop;
	}
}
